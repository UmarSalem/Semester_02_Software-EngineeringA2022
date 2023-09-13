package server.servermodel.Guest;

import shared.transferobjects.Reservation;

public interface Guest
{
  void createReservation(Reservation reservation);
  //Request createReservation(Reservation reservation);
  //Request updateReservation(String phone,String menuName,
  // String menuPrice, int menuQuantity ,String IsMenuPickedUp,String menuType);
}


