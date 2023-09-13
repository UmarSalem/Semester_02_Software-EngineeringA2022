package client.clientmodel;

import client.networking.Client;
import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

/**
 * @author umar, saqlain, nauman, digvijaya
 * @version 0.1
 * A class that is implement all the function from model
 */
public class AdminManager implements Admin
{

  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Client client;
  /**
   * A constructor that will initialize the client
   */
  public AdminManager(Client client)
  {
    this.client = client;
    client.startClient();
    client.addListener("NewMenuEntry", this::onNewMenuEntry);
  }

  /**
   * A function that is starting a fire property
   */
  private void onNewMenuEntry(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }

  //----------Client side-----------------
  /**
   * An override method that will get menu list from  RMI
   */
  @Override public List<Menu> getMenuList()
  {
    return client.getMenuList();
  }

  /**
   * An override method that will create reservation and passing the values to the RMI
   * @param reservation the reservation
   */

  @Override public void createReservation(Reservation reservation)
  {
    client.createReservation(reservation);
    System.out.println("client model manager added reservation");
  }

  //------Admin Side-------------------------------------------------

  /**
   * An override method that will verify user id and passward and passing the values to the RMI
   * @param text the userid
   * @param text the password
   */

  @Override public String verifyUserIdAndCode(String text, String code)
  {
    return client.verifyUserIdAndCode(text, code);
  }

  /**
   * An override method that will create a menu and passing the values to the RMI
   * @param menu the Menu
   */
  @Override public void addMenu(Menu menu)
  {
    client.addMenu(menu);
    System.out.println("Admin added menu");

  }

/**
 * An override method that will get reservation list from the RMI client
 * @return List<Reservation> the reservation list
 */
  @Override public List<Reservation> getReservationList()
  {
    return client.getReservationList();
  }

  /**
   * An override method that will return list of  reservation  from the RMI client and passing the phone value
   * @param phone phone number
   *  @return List<Reservation> the reservation list
   */
  @Override public List<Reservation> searchReservation(String phone)
  {
    return client.getReservationList();
  }
  /**
   * An override method that will return updated list of  reservation  from the RMI  and passing the phone value and is pick up
   * @param phone phone number
   * @param isPickedUp picked up status
   *  @return List<Reservation> the reservation list
   */

  @Override public List<Reservation> upDateReservationPickUp(String phone,
      String isPickedUp)
  {
    return client.upDateReservationPickUp(phone,
        isPickedUp);
  }

  /**
   * An override method that will delete reservation  and passing the phone value to RMI
   * @param reservation reservation
   */
  @Override public void deleteReservation(Reservation reservation)
  {
    client.deleteReservation( reservation);
  }
  /**
   * An override method that will delete  menu  and passing the Menu value to RMI
   * @param menu menu
   */
  @Override public void deleteMenu(Menu menu)
  {
client.deleteMenu(menu);
  }



  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}


