package server.database;

import server.database.menu.MenuDAO;
import server.database.menu.MenuDAOImpl;

import java.sql.SQLException;

public class Test
{
  public static void main(String[] args) throws SQLException
  {
    MenuDAO menuDAO = MenuDAOImpl.getInstance();

    try
    {
           /*Menu menu = new Menu("pasta","35",3,"tomoator sacuch" ,"yes","Veg");
           menuDAO.create(menu);*/
      System.out.println(menuDAO.getMenuList());
    }

    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }
}
