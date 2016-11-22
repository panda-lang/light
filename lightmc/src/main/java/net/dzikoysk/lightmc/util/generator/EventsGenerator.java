package net.dzikoysk.lightmc.util.generator;

import net.dzikoysk.lightmc.util.generator.util.Generator;
import net.dzikoysk.lightmc.util.generator.util.GeneratorUtils;
import org.bukkit.event.Event;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.*;

public class EventsGenerator implements Generator {

    private final File directory;

    public EventsGenerator(String dir) {
        this.directory = new File(dir);
    }

    @Override
    public void generate() throws Exception {
        boolean isDirectoryCreated = directory.mkdirs();

        if (!isDirectoryCreated) {
            throw new RuntimeException("Directory " + directory.getName() + " doesn't exist and the generator cannot create it");
        }

        Reflections reflections = new Reflections("org.bukkit.event");
        Set<Class<? extends Event>> eventClasses = reflections.getSubTypesOf(Event.class);
        Map<String, Collection<Class<? extends Event>>> eventsMap = new HashMap<>();

        for (Class<? extends Event> eventClass : eventClasses) {
            Package eventPackage = eventClass.getPackage();
            Collection<Class<? extends Event>> classes = eventsMap.get(eventPackage.getName());

            if (classes == null) {
                classes = new ArrayList<>();
                eventsMap.put(eventPackage.getName(), classes);
            }

            classes.add(eventClass);
        }

        for (Map.Entry<String, Collection<Class<? extends Event>>> entry : eventsMap.entrySet()) {
            String eventPackage = entry.getKey();
            System.out.println("");
            System.out.println("[ " + eventPackage + " --------------------------------- ]");

            File eventsFile = new File(directory, eventPackage + ".events");
            FileWriter fileWriter = new FileWriter(eventsFile);

            for (Class<? extends Event> eventClass : entry.getValue()) {
                String eventClassName = eventClass.getSimpleName();
                String eventName = GeneratorUtils.transformName(eventPackage, eventClass.getSimpleName(), false, "Event");
                String eventNameWithSpaces = GeneratorUtils.transformName(eventPackage, eventClass.getSimpleName(), true, "Event");
                Set<Method> methods = ReflectionUtils.getAllMethods(eventClass);

                System.out.println("Adding event " + eventClassName + " -> 'on " + eventNameWithSpaces + " {}'");
                fileWriter.write("ScopeUnit " + eventName + "ScopeUnit = lightmc.registerEvent(" + eventClass.getSimpleName() + ".class, \"" + eventNameWithSpaces + "\");");

                Collection<String> addedMethods = new ArrayList<>();
                for (Method method : methods) {
                    String methodName = method.getName();

                    addMethod:
                    if (methodName.startsWith("extractToken")) {
                        if (method.getParameterCount() > 0) {
                            continue;
                        }

                        if (methodName.contains("Handler")) {
                            continue;
                        }

                        for (String addedMethodName : addedMethods) {
                            if (addedMethodName.equals(methodName)) {
                                break addMethod;
                            }
                        }

                        String argumentName = GeneratorUtils.transformName("extractToken", methodName, true);
                        System.out.println("- '" + argumentName + "'");
                        fileWriter.write(System.lineSeparator());
                        fileWriter.write(getArgumentInitializer(argumentName, eventName, eventClassName, "event." + methodName + "();"));
                        addedMethods.add(methodName);
                    }
                }

                fileWriter.write(System.lineSeparator());
                fileWriter.write(System.lineSeparator());
            }

            fileWriter.flush();
            fileWriter.close();
        }
    }

    public String getArgumentInitializer(String argumentName, String eventName, String eventClassName, String argumentSource) {
        return eventName + "ScopeUnit.registerArgument(\"" + argumentName + "\", new ArgumentInitializer<" + eventClassName + ">() {\n" +
                "    @Override\n" +
                "    public Object extractToken(Ray ray, " + eventClassName + " event) {\n" +
                "        return " + argumentSource + "\n" +
                "    }\n" +
                "});";
    }

    public static void main(String[] args) throws Exception {
        EventsGenerator eventsGenerator = new EventsGenerator("events");
        eventsGenerator.generate();
    }

}
