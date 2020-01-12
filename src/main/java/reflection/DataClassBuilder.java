package reflection;


import exception.AnnotationException;
import metadata.MetaDataSchema;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Класс для запуска работы ОРМ
 * Последовательно проверяет аннотации,
 * а потом расскладывает поля класса в метаданные
 * */

public class DataClassBuilder {
    private Set<Class> checkedClass = new LinkedHashSet<>();
    private AnnotationService annotationService = new AnnotationService();
    private MetaDataService metaDataService = new MetaDataService();

    public DataClassBuilder() {
    }

    public void addAnnotationClass (Class annoClass) {
        checkedClass.add(annoClass);
    }

    public void bulidConfig () throws AnnotationException {
        annotationService.checkAllAnnotation(checkedClass);
        metaDataService.createMetaDataSchema(checkedClass);

/*        Set<Class<?>> classSet = MetaDataSchema.getClassMap().keySet();
        for (Class<?> cl : classSet
             ) {
            MetaDataSchema.printClassMap(cl);
        }*/



    }


}
