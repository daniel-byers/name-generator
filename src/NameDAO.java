import java.util.*;
import java.sql.*;

public class NameDAO {

  public ArrayList<String> getFirstNames() {
    return retrieveFromDatabase("SELECT * FROM first_names");
  }

  public ArrayList<String> getLastNames() {
    return retrieveFromDatabase("SELECT * FROM last_names");
  }

  private ArrayList<String> retrieveFromDatabase(String query) {
    ArrayList<String> nameList = new ArrayList<String>();
    ResultSet resultSet = null;
    PreparedStatement ptmt = null;
    Connection connection = null;
    
    try {
      connection = ConnectionFactory.getInstance().getConnection();
      ptmt      = connection.prepareStatement(query);
      resultSet = ptmt.executeQuery();

      while (resultSet.next())
        nameList.add(resultSet.getString("name"));
      
    } catch (SQLException e) { e.printStackTrace(); } 
    finally {
      try {
        if (resultSet != null)  resultSet.close();
        if (ptmt != null)       ptmt.close();
        if (connection != null) connection.close();
      } catch (SQLException e)  { e.printStackTrace(); }
    }

    return nameList;
  }
}