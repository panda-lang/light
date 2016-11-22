package net.dzikoysk.lightmc.util.generator;

import net.dzikoysk.lightmc.util.generator.util.Generator;
import net.dzikoysk.lightmc.util.generator.util.GeneratorUtils;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.*;

public class StructuresGenerator implements Generator {

    private final File directory;
    private final Collection<String> classes;
    private FileWriter fileWriter;
    private String structureName;

    public StructuresGenerator(String dir) {
        this.directory = new File(dir);
        this.classes = new ArrayList<>();
    }

    public void addClass(String className) {
        classes.add(className);
    }

    @Override
    public void generate() throws Exception {
        boolean isDirectoryCreated = directory.mkdirs();

        if (!isDirectoryCreated) {
            throw new RuntimeException("Directory " + directory.getName() + " doesn't exist and the generator cannot create it");
        }

        Reflections reflections = new Reflections("org.bukkit");
        Set<Class<? extends Object>> eventClasses = reflections.getSubTypesOf(Object.class);

        for (String className : classes) {
            Class structureClass = Class.forName(className);
            Set<Method> methods = ReflectionUtils.getAllMethods(structureClass);
            structureName = structureClass.getSimpleName();

            System.out.println("[ " + structureClass.getName() + " --------------------------------- ]");
            System.out.println("Adding " + structureClass + " as '" + structureName + "'");

            File structureFile = new File(directory, structureName + ".java");
            fileWriter = new FileWriter(structureFile);

            String structureClassTemplate = getClassTemplate();
            Map<String, String> expressionTemplates = new HashMap<>();

            for (Method method : methods) {
                String methodName = method.getName();

                if (methodName.startsWith("extractToken")) {
                    if (method.getParameterCount() > 0) {
                        continue;
                    }

                    String expressionNameWithSpaces = GeneratorUtils.transformName("extractToken", methodName, true);
                    String expressionTemplate = expressionTemplates.get(expressionNameWithSpaces);
                    String patternName = structureName.toLowerCase() + (structureName.equals("Player") || structureName.equals("Entity") ? "'s " : " ") + expressionNameWithSpaces;

                    if (expressionTemplate == null) {
                        expressionTemplate = getExpressionTemplate()
                                .replace("{expression.pattern}", patternName);
                    }

                    String getValueTemplate = getValueMethodTemplate()
                            .replace("{get_value.source}", "{element.name} object = ray.getExpressionValue(0);\n" +
                                    "                return object." + methodName + "();");

                    expressionTemplate = expressionTemplate.replace("{get_value.method}", getValueTemplate);
                    expressionTemplates.put(expressionNameWithSpaces, expressionTemplate);

                    System.out.println("- extractToken: \"" + patternName + "\"");
                }
                else if (methodName.startsWith("set")) {
                    if (method.getParameterCount() != 1) {
                        continue;
                    }

                    String expressionNameWithSpaces = GeneratorUtils.transformName("set", methodName, true);
                    String expressionTemplate = expressionTemplates.get(structureClassTemplate);
                    String patternName = structureName.toLowerCase() + (structureName.equals("Player") || structureName.equals("Entity") ? "'s " : " ") + expressionNameWithSpaces;

                    if (expressionTemplate == null) {
                        expressionTemplate = getExpressionTemplate()
                                .replace("{expression.pattern}", patternName);
                    }

                    String modifyTemplate = getModifyMethodTemplate()
                            .replace("{modify.source}", "if (modification.getType() == ModificationType.SET) {\n" +
                                    "                    {element.name} object = ray.getExpressionValue(0);\n" +
                                    "                    " + method.getParameterTypes()[0].getSimpleName() + " value = ray.getExpressionValue(1);\n" +
                                    "                    object." + methodName + "(value);\n" +
                                    "                }");

                    expressionTemplate = expressionTemplate.replace("{modify.method}", modifyTemplate);
                    expressionTemplates.put(expressionNameWithSpaces, expressionTemplate);

                    System.out.println("- set: \"" + patternName + "\"");
                }
            }

            StringBuilder expressionsBuilder = new StringBuilder();
            for (Map.Entry<String, String> entry : expressionTemplates.entrySet()) {
                String expressionTemplate = entry.getValue()
                        .replace("{modify.method}", "")
                        .replace("{get_value.method}", "");

                expressionsBuilder.append(expressionTemplate);
                expressionsBuilder.append(System.lineSeparator());
                expressionsBuilder.append(System.lineSeparator());
            }

            structureClassTemplate = structureClassTemplate
                    .replace("{expressions}", expressionsBuilder.toString())
                    .replace("{serialize}", "")
                    .replace("{deserialize}", "return null;")
                    .replace("{to_string}", "return object.toString();")
                    .replace("{element.name}", structureName);

            fileWriter.write(structureClassTemplate);
            fileWriter.flush();
            fileWriter.close();
        }
    }

    public static void main(String[] args) throws Exception {
        StructuresGenerator structuresGenerator = new StructuresGenerator("structures");
        structuresGenerator.addClass("org.bukkit.entity.Player");
        structuresGenerator.addClass("org.bukkit.World");
        structuresGenerator.addClass("org.bukkit.Location");
        structuresGenerator.addClass("org.bukkit.block.Block");
        structuresGenerator.addClass("org.bukkit.inventory.ItemStack");
        structuresGenerator.addClass("org.bukkit.Material");
        structuresGenerator.addClass("org.bukkit.Bukkit");
        structuresGenerator.addClass("org.bukkit.entity.Entity");
        structuresGenerator.addClass("org.bukkit.util.Vector");
        structuresGenerator.addClass("org.bukkit.inventory.Inventory");
        structuresGenerator.generate();
    }

    private String getClassTemplate() {
        return "public class {element.name}Structure extends Structure<{element.name}> {\n" +
                "\n" +
                "    @Override\n" +
                "    public void initialize(LightCore lightCore) {\n" +
                "        hookClass({element.name}.class);\n" +
                "\n" +
                "{expressions}" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void serialize(DataSerializer dataSerializer, {element.name} object) throws IOException {\n" +
                "        {serialize}\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public {element.name} deserialize(DataSerializer dataSerializer) throws IOException {\n" +
                "        {deserialize}\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public String toString({element.name} object) {\n" +
                "        {to_string}\n" +
                "    }\n" +
                "\n" +
                "}";
    }

    private String getExpressionTemplate() {
        return "        addExpressionRepresentation(\"{expression.pattern}\", new Expression() {\n" +
                "{modify.method}" +
                "{get_value.method}" +
                "        });";
    }

    private String getModifyMethodTemplate() {
        return "           @Override\n" +
                "            public void modify(Modification modification) {\n" +
                "                Ray ray = modification.getRay();\n" +
                "                {modify.source}\n" +
                "            }\n";
    }

    private String getValueMethodTemplate() {
        return "           @Override\n" +
                "            public Object getValue(Ray ray) {\n" +
                "                {get_value.source}\n" +
                "            }\n";
    }

}
