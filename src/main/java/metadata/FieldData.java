package metadata;

/**
 * Здесь хранятся данные о полях, полученные с помощью рефлексии. Пока тут только пара имя поля и тип. Но со временем
 * вижу, что будет расширение
 * */

public class FieldData {
    private String nameField;
    private String nameColumn;
    private String type;
    private String anno;

    //Конструктор


    public FieldData(String nameField, String type) {
        this.nameField = nameField;
        this.type = type;
    }

    public FieldData(String nameField, String type, String anno) {
        this.nameField = nameField;
        this.type = type;
        this.anno = anno;
    }


    //Геттеры и сеттеры

    public String getNameField() {
        return nameField;
    }

    public void setNameField(String nameField) {
        this.nameField = nameField;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getNameColumn() {
        return nameColumn;
    }

    public void setNameColumn(String nameColumn) {
        this.nameColumn = nameColumn;
    }

    @Override
    public String toString() {
        return "FieldData {" +
                "nameField='" + nameField + '\'' +
                ", nameColumn='" + nameColumn + '\'' +
                ", type='" + type + '\'' +
                //", anno='" + anno + '\'' +
                '}';
    }

//Дополнительные методы


}
