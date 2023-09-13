package shared.networking;

import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 * The RMIServer interface that is shared between client and server
 */
public interface RMIServer extends Remote
{
  /**
   *verify userid and password
   * @param str the userid for Admin login
   * @param code the password for Admin login
   * @throws RemoteException
   */
  String verifyUserIdAndCode(String str, String code) throws RemoteException;
  /**
   * create  menus
   * @param menu menu
   * @throws RemoteException
   */
  void addMenu(Menu menu) throws RemoteException;
  /**
   * delete  menu
   * @param menu menu
   * @throws RemoteException
   */
  void deleteMenu(Menu menu) throws RemoteException;;
  /**
   * return list of menus
   * @return list of menus
   * @throws RemoteException
   */
  List<Menu> getMenuList() throws RemoteException;
  /**
   * return list of reservations
   * @return list of reservations
   * @throws RemoteException
   */
  List<Reservation> searchReservation(String phone)throws RemoteException;
  /**
   * update the pickup status by phone  and return a list of reservations
   * @return list of reservations
   * @throws RemoteException
   */
  List<Reservation> upDateReservationPickUp(String phone, String isPickedUp)throws RemoteException;;

  /**
   * delete the reservation
   * @param  reservation reservation
   * @throws RemoteException
   */
  void deleteReservation(Reservation reservation)throws RemoteException;

  /**
   * register client call back method
   * @param  ccb client call back interface object
   * @throws RemoteException
   */
  void registerCallback(ClientCallback ccb) throws RemoteException;
  void createReservation(Reservation reservation) throws RemoteException;
  List<Reservation> getReservationList() throws RemoteException;


  ;

  //    String toUppercase(String str) throws RemoteException;
  //    List<LogEntry> getLogs() throws RemoteException;

  //  void createLogin(String userId, String passward) throws RemoteException;
}
