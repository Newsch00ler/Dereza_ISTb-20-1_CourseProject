package DB;

import java.sql.*;

public class Database {
    private static Connection connection;
    public static PreparedStatement statement;
    public static ResultSet resSet;
    public static final String PATH_TO_DB_FILE = "players.db";
    public static final String URL = "jdbc:sqlite:" + PATH_TO_DB_FILE;

    public static void initDB() throws SQLException{
        connection = DriverManager.getConnection(URL);
        if(connection != null){
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getDriverName());
        }
    }

    public static void closeDB() throws SQLException{
        connection.close();
    }

    public static void createDB() throws SQLException, Exception{
        statement = connection.prepareStatement("CREATE TABLE if nit exists 'soccers' ('')");
        statement.execute();
        statement = connection.prepareStatement("CREATE TABLE if nit exists 'hockeypls' ('')");
        statement.execute();
        statement = connection.prepareStatement("CREATE TABLE if nit exists 'basketpls' ('')");
        statement.execute();
        statement.close();
    }
}
