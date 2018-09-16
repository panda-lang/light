package org.panda_lang.light.framework.language.architecture.linguistic.phraseme.loader;

import org.panda_lang.light.LightException;
import org.panda_lang.light.framework.design.architecture.linguistic.Context;
import org.panda_lang.light.framework.design.architecture.linguistic.phraseme.Phraseme;
import org.panda_lang.panda.utilities.annotations.AnnotationsScannerProcess;

import java.util.Collection;

public class PhrasemesLoader {

    public Collection<Phraseme> load(Context context, AnnotationsScannerProcess process) {
        try {
            return loadAll(context, process);
        } catch (Exception e) {
            throw new LightException("Cannot load phrasemes: " + e.getMessage(), e);
        }
    }

    private Collection<Phraseme> loadAll(Context context, AnnotationsScannerProcess process) throws Exception {
        Collection<Phraseme> phrasemes;

        PhrasemeRepresentationLoader representationLoader = new PhrasemeRepresentationLoader();
        phrasemes = representationLoader.load(context, process);

        PhrasemeGroupLoader groupLoader = new PhrasemeGroupLoader();
        phrasemes.addAll(groupLoader.load(context, process));

        return phrasemes;
    }

}
