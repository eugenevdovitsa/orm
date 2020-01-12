import metadata.FieldData;
import metadata.MetaDataSchema;
import metadata.TableData;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * Пока здесь хранится и создание Statement, и примеры небольших запросов. Потом в плане разнести всё это на отдельные сущности
 * */

public class StatementBuilder {
    private static PreparedStatement statement = null;
    private static Connection connectionDB = null;
    private String query;

    public StatementBuilder() {
    }



    public void save(Object object) throws SQLException {
        try {
            // Получаем имя таблицы
            TableData tableData = MetaDataSchema.getTableData(object.getClass());
            String tableName = (tableData.getTablename());

            // Стринги для имен полей и их значений
            StringBuffer nameFields = new StringBuffer();
            StringBuffer values = new StringBuffer("'");

            // Заполняем имена и значения
            //TODO ещё посмотреть этот цикл
            for (FieldData tableColumn: tableData.getFieldData()
                 ) {
                Field field = object.getClass().getDeclaredField(tableColumn.getNameField());
                field.setAccessible(true);
                nameFields.append(tableColumn.getNameColumn()).append(", ");
                values.append(field.get(object)).append("', '");
            }

            //Удаляем лишнее, потому что криво написано заполнение выше, надо потом сделать лучше
            nameFields.delete(nameFields.length()-2, nameFields.length());
            values.delete(values.length()-3, values.length());

            // Формируем запрос на основе форматированной стринги
            String query = String.format("INSERT into %s (%s) VALUES (%s)", tableName, nameFields.toString(), values.toString());

            // Подключаемся к базе и выполняем запрос
            connectionDB = ConnectionDB.getConnection();
            statement = connectionDB.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException | NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (connectionDB != null) {
                connectionDB.close();
            }

        }
    }



/*    public void setById(int idQuery, Object object) throws SQLException {
        StringBuilder queryBuilder;
        try {
            connectionDB = ConnectionDB.getConnection();
            statement = connectionDB.createStatement();
            return statement.executeQuery("SELECT * FROM users");
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (connectionDB != null) {
                connectionDB.close();
            }


        }
    }*/

}
