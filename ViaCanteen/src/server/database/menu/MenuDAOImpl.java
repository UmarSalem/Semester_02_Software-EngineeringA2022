package server.database.menu;

import server.database.DataBaseConnection;
import shared.transferobjects.Menu;
import shared.transferobjects.Request;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Umar,Nauman,Saqlain,Digvijaya
 * A class that will execute all the function from MenuDAO interface
 */
public class MenuDAOImpl implements MenuDAO
{


  /**
   * A private constructor  that will register driver to db
   */

  private MenuDAOImpl()
  {

    try
    {
      DriverManager.registerDriver(new org.postgresql.Driver());
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }

  /**
   * A function that will do instance in singleton
   *
   * @return instance
   */
  private static MenuDAO instance;
  private static Lock lock = new ReentrantLock();

  public static MenuDAO getInstance() throws SQLException
  {
    if (instance == null)
    {
      synchronized (lock)
      {
        if (instance == null)
        {
          instance = new MenuDAOImpl();
        }
      }
    }
    return instance;
  }

  /**
   * A function that will create a menu to db
   * @param menu menu
   */
  @Override public void create(Menu menu) throws SQLException
  {
    try (Connection connection = DataBaseConnection.getConnection())
    {

      //            PreparedStatement statement = connection.prepareStatement("set schema 'umar';");
      PreparedStatement statement1 = connection.prepareStatement(
          //   "INSERT INTO \"Menu\"(\" menuName\",\"menuPrice\",\"menuQuantity\",\"menuIngredient\",\"IsMenuVeg\" ,\"menuType\")VALUES(?,?,?,?,?,?);");
          "INSERT INTO Menu (id,menuName,menuPrice,menuQuantity,menuIngredient,IsMenuVeg,menuType) VALUES (DEFAULT,?,?,?,?,?,?);");
      //statement1.setInt(1,menu.getId());
      statement1.setString(1, menu.getMenuName());
      statement1.setString(2, menu.getMenuPrice());
      statement1.setInt(3, menu.getMenuQuantity());
      statement1.setString(4, menu.getIsMenuVeg());
      statement1.setString(5, menu.getMenuIngredient());
      statement1.setString(6, menu.getMenuType());
      statement1.executeUpdate();
    }
  }

  /**
   * A function that will return all the menus
   * @return list of menus
   * @throws SQLException
   */
  @Override public ArrayList<Menu> getMenuList() throws SQLException
  {
    try (Connection connection = DataBaseConnection.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM Menu;");
      //"SELECT * FROM \"Menu\";");
      return (ArrayList<Menu>) getMenus(statement);
    }
  }
  /**
   * A function that will delete the menu
   * @throws SQLException
   */
  @Override public void deleteMenu(Menu menu) throws SQLException
  {
    try (Connection connection = DataBaseConnection.getConnection())
    {

      PreparedStatement statement = connection.prepareStatement(
          "delete from Menu where  id = ?;");
      //statement.setString(1, menu.getMenuName());
      statement.setInt(1,menu.getId());
      statement.executeQuery();

    }

  }
  /**
   * A function that will return a list of menus
   * @param statement
   * @return list of menus
   * @throws SQLException
   */
  private List<Menu> getMenus(PreparedStatement statement) throws SQLException
  {ResultSet resultSet = statement.executeQuery();
    List<Menu> menuList = new ArrayList<>();
    while (resultSet.next())
    {int id=resultSet.getInt("id");
      String menuName = resultSet.getString("menuName");
      String menuPrice = resultSet.getString("menuPrice");
      int menuQuantity = resultSet.getInt("menuQuantity");
      String menuIngredient = resultSet.getString("menuIngredient");
      String IsMenuVeg = resultSet.getString("IsMenuVeg");
      String menuType = resultSet.getString("menuType");
      Menu menu = new Menu(id,menuName, menuPrice, menuQuantity, menuIngredient,
          IsMenuVeg, menuType);
      menuList.add(menu);
    }return menuList;
  }


}
