package Connection;

import java.sql.*;

public class DBConnection {
    private String user;
    private String password;
    private String nameDb;
    private String url;

    private Connection mysqlConnect;

    public DBConnection(String root, String password, String nameDb)
    {
        this.user = root;
        this.password = password;
        this.nameDb = nameDb;
    }

    public void initProperties()
    {
        url= "jdbc:mysql://localhost:3311" + "/" + nameDb;

        System.out.println("URL: " + url);

    }

    public void init()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            mysqlConnect = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String query) {
        ResultSet resultSet = null;
        try {
            Statement stmt = mysqlConnect.createStatement();
            resultSet = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

    public void updateQuery(String query)
    {
        try {
            Statement stmt = mysqlConnect.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
