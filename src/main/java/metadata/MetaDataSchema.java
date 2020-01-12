package metadata;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для хранения метаданных для аннотированных классов
 * */

public class MetaDataSchema {
    private static Map<Class<?>, TableData> classMap = new HashMap<>();
    private String someDetail;

    public static Map<Class<?>, TableData> getClassMap(){
        return classMap;
    }


    public static void  addToClassMap (Class<?> annotatedClass, TableData tableData){
        classMap.put(annotatedClass, tableData);
    }

    public static TableData getTableData(Class annotatedClass) {
        return classMap.get(annotatedClass);
    }

    public static String getTableName(Class annotatedClass){
        return getTableData(annotatedClass).getTablename();
    }

    public static String getColumnName (Class annotatedClass, Field field){
        return "Hello";
    }

    public static void printClassMap (Class annotatedClass) {
        String nameClass = annotatedClass.getSimpleName();
        String nameTable = classMap.get(annotatedClass).getTablename();
        String fields = classMap.get(annotatedClass).getFieldData().toString();
        System.out.println("name class: " + nameClass);
        System.out.println("name table: " + nameTable);
        System.out.println("Fields: " + fields);
    }


}
