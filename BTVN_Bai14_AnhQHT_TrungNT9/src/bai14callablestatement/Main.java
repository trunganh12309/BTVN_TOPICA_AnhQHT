package bai14callablestatement;

import java.sql.*;

public class Main {

    private static int port = 5432;
    private static String host = "localhost";
    private static String databaseName = "jdbctestdb";
    private static String database = "postgresql";
    private static String dbUsername = "trunganh";
    private static String dbPassword = "ta781996";

    public static void main(String[] args) {
        String url = "jdbc:"+database+"://"+host+":"+port+"/"+databaseName;
        try (Connection connection = DriverManager.getConnection(url,dbUsername,dbPassword)) {
//            Class.forName("org.postgresql.Driver");
            CallableStatement callableStatement = connection.prepareCall("select findPersonByName(?);");
            callableStatement.setString(1,"test%");
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}
