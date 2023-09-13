package server.database.reservation;

import server.database.DataBaseConnection;
import shared.transferobjects.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReservationDAOImp implements ReservationDAO
{

  /**
   * @author Umar,Nauman,Saqlain,Digvijaya
   * A class that will execute all the function from ReservationDAO interface
   */
  private static ReservationDAO instance;
  private static Lock lock = new ReentrantLock();

  /**
   * A constructor  that will register driver to db
   */

  private ReservationDAOImp()
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
  public static ReservationDAO getInstance() throws SQLException
  {
    if (instance == null)
    {
      synchronized (lock)
      {
        if (instance == null)
        {
          instance = new server.database.reservation.ReservationDAOImp();
        }
      }
    }
    return instance;
  }
  /**
   * A function that create reservation
   * @param reservation reservation
   */
  @Override public void createReservation(Reservation reservation)
      throws SQLException

  {try (Connection connection = DataBaseConnection.getConnection())
    {PreparedStatement statement1 = connection.prepareStatement(
          "INSERT INTO Reservation (phone , menuName ,menuPrice,IsMenuPickedUp ,menuType) VALUES (?,?,?,?,?);");
      statement1.setString(1, reservation.getPhone());
      statement1.setString(2, reservation.getMenuName());
      statement1.setString(3, reservation.getMenuPrice());
      statement1.setString(4, reservation.getIsMenuPickedUp());
      statement1.setString(5, reservation.getMenuType());

      statement1.executeUpdate();
    }
  }


  /**
   * A function that will return all the reservation
   *
   * @return list of reservation
   * @throws SQLException
   */
  @Override public ArrayList<Reservation> getReservationList()
      throws SQLException
  {
    try (Connection connection = DataBaseConnection.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM Reservation;");
      //"SELECT * FROM \"Menu\";");
      return (ArrayList<Reservation>) getReservation(statement);
    }
  }

  /**
   * A private function that will return a list of reservation
   *
   * @param statement
   * @return list of reservation
   * @throws SQLException
   */
  private List<Reservation> getReservation(PreparedStatement statement)
      throws SQLException
  {
    ResultSet resultSet = statement.executeQuery();
    List<Reservation> reservationList = new ArrayList<>();
    while (resultSet.next())
    {

      String phone= resultSet.getString("phone");
      String menuName = resultSet.getString("menuName");
      String menuPrice = resultSet.getString("menuPrice");
      //int menuQuantity = resultSet.getInt("menuQuantity");
      String IsMenuPickedUp = resultSet.getString("IsMenuPickedUp");
      String menuType = resultSet.getString("menuType");

     Reservation reservation = new Reservation(phone, menuName,
          menuPrice,  IsMenuPickedUp, menuType);

      reservationList.add(reservation);
    }
    return reservationList;
  }
  //-----------------Search Reservation by phone-----------------------------
  /**
   * A function that will return all the reservation by phone number
   *
   * @return list of reservation
   * @throws SQLException
   */
  @Override public ArrayList<Reservation> searchReservation(String phoneNo)
      throws SQLException
  {
    try (Connection connection = DataBaseConnection.getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM Reservation WHERE phone=?;");
      statement.setString(1,phoneNo);
      ResultSet resultSet = statement.executeQuery();
      List<Reservation> reservationList = new ArrayList<>();
      if (resultSet.next())
      {

        String phone= resultSet.getString("phone");
        String menuName = resultSet.getString("menuName");
        String menuPrice = resultSet.getString("menuPrice");
        String IsMenuPickedUp = resultSet.getString("IsMenuPickedUp");
        String menuType = resultSet.getString("menuType");
       // String menuIngredient= resultSet.getString("menuIngredient");

        Reservation reservation = new Reservation(phone, menuName,
            menuPrice,  IsMenuPickedUp , menuType);

        reservationList.add(reservation);
      }
      return (ArrayList<Reservation>) reservationList;
      //"SELECT * FROM \"Menu\";");
      //return (ArrayList<Reservation>) getSearchReservation(statement);
    }
  }
  /**
   * A function that will update Picked up and return all the reservation using phone No
   * @return list of reservation
   * @throws SQLException
   */
  @Override public ArrayList<Reservation> upDateReservationPickUp(String phone,
      String isPickedUp) throws SQLException

    {
      try (Connection connection = DataBaseConnection.getConnection())
      {
        PreparedStatement statement = connection.prepareStatement(
            "UPDATE Reservation SET ismenupickedup =? WHERE phone = ?;");

        statement.setString(1,isPickedUp);
        statement.setString(2, phone);
        //"SELECT * FROM \"Menu\";");
        statement.executeUpdate();  }catch (SQLException e)
      {
        System.out.println(e.getMessage());
      }
        try (Connection connection1 = DataBaseConnection.getConnection())
        {
          PreparedStatement statement1 = connection1.prepareStatement(
              "SELECT * FROM Reservation;");
          //"SELECT * FROM \"Menu\";");
          return (ArrayList<Reservation>) getReservation(statement1);
        }
      }
  /**
   * A function that will delete reservation
   * @throws SQLException
   */
  @Override public void deleteReservation(Reservation reservation)
      throws SQLException
  {
    try (Connection connection = DataBaseConnection.getConnection())
    {

      PreparedStatement statement = connection.prepareStatement(
          "delete  from Reservation where  phone = ?;");
      //statement.setString(1, menu.getMenuName());
      statement.setString(1,reservation.getPhone());
      statement.executeQuery();

    }

  }

  /*private List<Reservation> getSearchReservation(PreparedStatement statement)
      throws SQLException
  {

  }*/
  //-----------------Search Reservation by phone End here--------------------------
}
