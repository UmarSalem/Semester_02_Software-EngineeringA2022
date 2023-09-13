package client.clientmodel;

import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;
import shared.util.Subject;

import java.util.List;

/**
 * @author umar
 * interface for Admin manager
 */
public interface Admin extends Subject
{
  /**
   *verify userid and password
   * @param text the userid for Admin login
   * @param code the password for Admin login
   */
  String verifyUserIdAndCode(String text, String code);
  /**
   * To create a menu
   * @param menu the menu
   */
  void addMenu(Menu menu);
  /**
   * To return a list of reservation
   * @return  List<Reservation>  reservation list
   */
  List<Reservation> getReservationList();
  /**
   * To return a list of reservation
   * @param phone phone
   * @return  List<Reservation>  reservation list
   */
  List<Reservation> searchReservation(String phone);
  /**
   * To return a list of update reservation
   * @param phone phone
   * @param isPickedUp
   * @return  List<Reservation>  reservation list
   */
  List<Reservation> upDateReservationPickUp(String phone, String isPickedUp);
  /**
   * To delete a reservation
   * @param reservation the reservation
   */
  void deleteReservation(Reservation reservation);

  //----------Clint side------------
  /**
   * To return a list of menu
   * @return  List<Menu>  menu list
   */
  List<Menu> getMenuList();
  /**
   * To create a reservation
   * @param reservation the reservation
   */
  void createReservation(Reservation reservation);
  /**
   * To delete a menu
   * @param menu the menu
   */
  void deleteMenu(Menu menu);


  ;

  //  void addMenu(Menu menu);

  //    String toUppercase(String text);
  //    List<LogEntry> getLogs();

  //umar code-----//

  // void createLogin(String userId, String passward);
}


