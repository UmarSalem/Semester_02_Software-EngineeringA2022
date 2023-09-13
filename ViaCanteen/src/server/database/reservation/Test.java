package server.database.reservation;

import shared.transferobjects.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test
{
  public static void main(String[] args) throws SQLException
  {
    ReservationDAO reservationDAO = ReservationDAOImp.getInstance();
    List <Reservation> list=new ArrayList<>();

    System.out.println(reservationDAO.getReservationList());

    //Menu menu = new Menu("butterChicken", "35", 3, "tomoator sacuch", "yes", "Veg");
    // List<Menu> list=new ArrayList<>();
    //list.add(menu);
    //Reservation reservation = new Reservation(menu, "21694020");
    //menuDAO.createReservation(reservation);
    //menuDAO.create(menu);*/
    //System.out.println(menuDAO.createReservation(reservation));

  }
}
