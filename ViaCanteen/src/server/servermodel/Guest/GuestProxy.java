package server.servermodel.Guest;

import shared.transferobjects.Reservation;

public class GuestProxy implements Guest
{
  private Guest guest;

  public GuestProxy()
  {
    guest = new GuestImp();
  }

  @Override public void createReservation(Reservation reservation)
  {
    guest.createReservation(reservation);
  }

  /*@Override public Request updateReservation(String phone, String menuName,
      String menuType, String IsMenuPickedUp)
  {
    return guest.updateReservation(phone,menuName,menuType,IsMenuPickedUp);
  }*/
}
