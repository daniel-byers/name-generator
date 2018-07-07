import java.sql.*;

public class ConnectionFactory {

  private static ConnectionFactory connectionFactory = null;
  
  public static ConnectionFactory getInstance() {
    if (connectionFactory == null)  connectionFactory = new ConnectionFactory();
    return connectionFactory;
  }

  public Connection getConnection() throws SQLException {
    Connection connection = DriverManager.getConnection("jdbc:sqlite:names.db");
    return connection;
  }
}