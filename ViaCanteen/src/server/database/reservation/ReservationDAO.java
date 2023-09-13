package server.database.reservation;

import shared.transferobjects.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * The interface access object for reservation
 */

public interface ReservationDAO
{
  ArrayList<Reservation> getReservationList() throws SQLException;

  void createReservation(Reservation reservation) throws SQLException;
  ArrayList<Reservation> searchReservation(String phone) throws SQLException;
  ArrayList<Reservation> upDateReservationPickUp(String phone, String isPickedUp) throws SQLException;;
  void deleteReservation(Reservation reservation)throws SQLException;
}
