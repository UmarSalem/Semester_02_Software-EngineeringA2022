package server.servermodel.serverModel;

import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;

import java.beans.PropertyChangeListener;
import java.util.List;
/**
 * A proxy Class for server model
 */
public class ServerModelProxy implements ServerModel
{
  private ServerModel serverModel;
  /**
   * A constructor that initiate the server model
   */

  public ServerModelProxy()
  {
    serverModel = new ServerModelImp();
  }

  @Override public String verifyUserIdAndCode(String loginId, String code)
  {
    return serverModel.verifyUserIdAndCode(loginId, code);
  }

  @Override public void addMenu(Menu menu)
  {
    serverModel.addMenu(menu);
  }

  @Override public void deleteMenu(Menu menu)
  {
    serverModel.deleteMenu(menu);
  }

  @Override public List<Reservation> getReservationList()
  {
    return serverModel.getReservationList();
  }

  @Override public List<Reservation> searchReservation(String phone)
  {
    return serverModel.searchReservation(phone);
  }

  @Override public List<Reservation> upDateReservationPickUp(String phone,
      String isPickedUp)
  {
    return serverModel.upDateReservationPickUp(phone,
       isPickedUp);
  }

  @Override public void deleteReservation(Reservation reservation)
  {
   serverModel.deleteReservation(reservation) ;  }

  @Override public List<Menu> getMenuList()
  {
    return serverModel.getMenuList();
  }

  @Override public void createReservation(Reservation reservation)
  {
    serverModel.createReservation(reservation);
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    serverModel.addListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    serverModel.removeListener(eventName, listener);
  }

}
