package server.servermodel.serverModel;

import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;
import shared.util.Subject;

import java.util.List;
/**
 * interface for server model
 */

public interface ServerModel extends Subject
{
  /**
   *verify userid and password
   * @param loginId the userid for Admin login
   * @param code the password for Admin login
   */
  String verifyUserIdAndCode(String loginId, String code);
  /**
   * To create a menu
   * @param menu the menu
   */
  void addMenu(Menu menu);
  void deleteMenu(Menu menu);
  List<Reservation> getReservationList();
  List<Reservation> searchReservation(String phone);
  List<Reservation> upDateReservationPickUp(String phone, String isPickedUp);
  void deleteReservation(Reservation reservation);
  //-------Client Side---------------
  List<Menu> getMenuList();
  void createReservation(Reservation reservation);


  //    String toUppercase(String str);
  //    List<LogEntry> getLog();
  //    void createLogin(String userId, String passward);
}
