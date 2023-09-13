package server.servermodel.Guest;

import server.database.reservation.ReservationDAO;
import server.database.reservation.ReservationDAOImp;
import shared.transferobjects.Reservation;

import java.beans.PropertyChangeSupport;
import java.sql.SQLException;

public class GuestImp implements Guest
{
  private ReservationDAO reservationDAO;
  private PropertyChangeSupport support;
  private Reservation reservation;

  public GuestImp()
  {
    try
    {
      reservationDAO = ReservationDAOImp.getInstance();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void createReservation(Reservation reservation)
  {
    try
    {
      reservationDAO.createReservation(reservation);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    //return new Request("resrvation added",null);
  }




   /* String phone = reservation.getPhone();
    Menu menu=reservation.getMenu();
   // List<Menu> selected = reservation.getMenu();

    Request temp =new Request("Error", null);
    for (Menu i : selected) {
      try {
        temp= reservationDAO.createReservation(phone, i);
      } catch (Exception e) {
        return new Request(e.getMessage(), null);
      }
    }

    return temp;*/


  /*@Override public Request updateReservation(String phone, String menuName,
      String menuPrice, int menuQuantity, String IsMenuPickedUp,
      String menuType)
  {
    try
    {
      return reservationDAO.updateReservation(phone,menuName,
          menuPrice,menuQuantity,IsMenuPickedUp,menuType);
      //System.out.println("Reservation added in to the data base");
    }
    catch (Exception e)
    {e.printStackTrace();}

    return  new Request("Reservation add Successfully",null);
  }*/

}
