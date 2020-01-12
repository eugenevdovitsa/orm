package metadata;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Хранилище данных по каждой таблице: имя, поля, тип связи
 * Ещё надо добавить указание на ПК, ФК, Конструктор
 * Это пока сложный класс
 * */

public class TableData {
    private String tablename;
    private Set<FieldData> fieldData = new LinkedHashSet<>();
    private String relation;

    public TableData(String tablename) {
        this.tablename = tablename;
    }

    public TableData(String tablename, Set<FieldData> fieldData) {
        this.tablename = tablename;
        this.fieldData = fieldData;
    }

    public TableData(String tablename, Set<FieldData> fieldData, String relation) {
        this.tablename = tablename;
        this.fieldData = fieldData;
        this.relation = relation;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public Set<FieldData> getFieldData() {
        return fieldData;
    }

    public void setFieldData(Set<FieldData> fieldData) {
        this.fieldData = fieldData;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "TableData{" +
                "tablename='" + tablename + '\'' +
                ", fieldData=" + fieldData.toString() +
                //", relation='" + relation + '\'' +
                '}';
    }
}
