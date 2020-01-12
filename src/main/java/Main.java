import metadata.MetaDataSchema;
import model.Autos;
import model.Company;
import model.Users;
import reflection.DataClassBuilder;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {


    public static void main(String[] args) throws SQLException {

        // Добавление классов в ОРМ
        DataClassBuilder dataClassBuilder = new DataClassBuilder();

        dataClassBuilder.addAnnotationClass(Users.class);
        dataClassBuilder.addAnnotationClass(Company.class);
        dataClassBuilder.addAnnotationClass(Autos.class);

        //Построение конфига
        dataClassBuilder.bulidConfig();

        // Test INSERT into Table
        Users user2 = new Users("John", 23, "Rome");
        Users user3 = new Users("Helena", 19, "Сызрань");

        StatementBuilder statementBuilder = new StatementBuilder();
        statementBuilder.save(user2);
        statementBuilder.save(user3);



        // Tests access to DB
/*        String queryBuilder = "SELECT * FROM " + MetaDataSchema.getTableName(Users.class) + " WHERE id = 2";
        String query = "SELECT * FROM users";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println(resultSet);

        while (resultSet.next()) {

            System.out.println(resultSet.getInt(1));
           // System.out.print(": ");
            System.out.println(resultSet.getString(2));
        }

        connection.close();*/



    }
}
