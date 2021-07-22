package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class userData {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=record;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "1234";
    private static Connection connect;
    private static Statement statement;

    public static Connection getConnection(String dbURL, String userName,
                                           String password) {
        Connection conn = null;
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    static String[] record = new String[5];

    public static String[] LoadRecord(){
        int i=0;
        try {
            connect = getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connect.createStatement();

            ResultSet rs = statement.executeQuery("select * from BestRecord where score>0 order by score asc");

            while (rs.next() && i<5) {
                record[i]=(rs.getString(1) + " " + rs.getInt(2));
                i++;
            }
            connect.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return record;
    }

    public static void SaveRecord(String player,int score){
        try {
            connect = getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connect.createStatement();
            
            statement.executeUpdate("insert into BestRecord(name,score) values ('"+player+"',"+score+");");
            
            connect.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
