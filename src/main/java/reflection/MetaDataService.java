package reflection;

import annotation.ColumnSoft;
import annotation.ExcludeSoft;
import annotation.TableSoft;
import metadata.FieldData;
import metadata.MetaDataSchema;
import metadata.TableData;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Класс для создания метаданных по аннотированным классам
*/

public class MetaDataService {
    private String tableName;
    private TableData tableData;
    private Set<FieldData> fieldsData = null;

    public void createMetaDataSchema(Set<Class> listClassAnnotation) {
        for (Class annotatedClass : listClassAnnotation
        ) {
            createTableData(annotatedClass);
            MetaDataSchema.addToClassMap(annotatedClass, tableData);
        }
    }

    /**
     * Метод для создания данных таблицы
     */

    private void createTableData(Class annotatedClass) {
        setTableName(annotatedClass);
        addFields(annotatedClass);
        tableData = new TableData(tableName, fieldsData);
    }

    /**
     * Добавляем поля в таблицу
     */

    private void addFields(Class annotatedClass) {
        Field[] fields = annotatedClass.getDeclaredFields();
        fieldsData = new LinkedHashSet<>();
        for (Field field : fields
        ) {
            if (isColumnInBase(field)) {
                FieldData fieldData = new FieldData(field.getName(), field.getType().getSimpleName());
                setColumnName(field, fieldData);
                fieldsData.add(fieldData);
            }
        }
    }

    /**
     * Метод для добавления имени таблицы
     */

    private void setTableName(Class classAnnotation) {
        Annotation annotation = classAnnotation.getAnnotation(TableSoft.class);
        TableSoft tableSoft = (TableSoft) annotation;
        tableName = tableSoft.name();
    }

    /**
     * Метод для добавления имени колонки для поля
     */

    private void setColumnName(Field field, FieldData fieldData) {
        if (field.getDeclaredAnnotation(ColumnSoft.class) != null && !field.getDeclaredAnnotation(ColumnSoft.class).name().equals("")) {
            fieldData.setNameColumn(field.getDeclaredAnnotation(ColumnSoft.class).name());
        } else {
            fieldData.setNameColumn(fieldData.getNameField().toLowerCase());
        }
    }

    /**
     * Проверка на аннотацию @ExcludeSoft
     * Эта аннотация исключает поле из схемы маппинга
     * @see annotation.ExcludeSoft
     */

    private boolean isExcludeField (Field field) {
        return field.getDeclaredAnnotation(ExcludeSoft.class) != null;
    }

    private boolean isColumnInBase (Field field) {
        return field.getDeclaredAnnotation(ColumnSoft.class) != null;
    }


}




