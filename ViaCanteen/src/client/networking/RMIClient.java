package client.networking;

import shared.networking.ClientCallback;
import shared.networking.RMIServer;
import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

/**
 @author Muhammad Umar Saleem, Nauman Iftikhar, Saqlain,Dijvijayah
 * A class that will initialize the RMI protocol between Client and server
 */
public class RMIClient implements Client, ClientCallback
{

  private RMIServer server;
  private PropertyChangeSupport support;
  //    private MenuBroadCastServer menuBroadCastServer;

  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
  }

  /**
   * A function that will initialize the RMI protocol between Client and server
   */
  @Override public void startClient()
  {
    Registry registry = null;
    try
    {
      registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (RMIServer) registry.lookup("ViaCanteen");
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }
  /**
   * A function that will verify userId and password
   * @param str the userid
   * @param code the password
   */

  @Override public String verifyUserIdAndCode(String str, String code)
  {
    try
    {
      return server.verifyUserIdAndCode(str, code);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not connect to the server :(");
    }
  }


  /**
   * A function that create  menu
   * @param menu today menu
   */
  @Override public void addMenu(Menu menu)
  {
    try
    {
      server.addMenu(menu);
      System.out.println("client added menu");
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not connect to the server :(");
    }
  }

  /**
   * A function that delete  menu
   * @param menu  menu
   */
  @Override public void deleteMenu(Menu menu)
  {
    try
    {
      server.deleteMenu( menu);
      System.out.println("RmiClient delete menu");
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not connect to the server :(");
    }
  }

  /**
   * A function that will search Reservation by phone
   * @param phone phone number
   */

  @Override public List<Reservation> searchReservation(String phone)
  {
  //        result = "";
    try
  {
    return server.searchReservation(phone);
  }
    catch (RemoteException e)
  {
    throw new RuntimeException(
        "Could not search reservation List form server :(");
  }
  }

  /**
   * A function that update the pickup status for Reservation
   * @param phone phone
   * @param isPickedUp IsPickedUp
   * @return  List<Reservation>
   */
  @Override public List<Reservation> upDateReservationPickUp(String phone,
      String isPickedUp)
  {
    //        result = "";
    try
    {
      return server.upDateReservationPickUp(phone, isPickedUp);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(
          "Could not get upDateReservationPickUp(phone, isPickedUp) form server :(");
    }
  }


  /**
   * A function that will delete reservation
   * @param reservation reservation
   */
  @Override public void deleteReservation(Reservation reservation)
  {
    try
    {
      server.deleteReservation(reservation);
      System.out.println("client deleteReservation");
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not connect to the server :(");
    }
  }
  /**
   * A function that will return list of reservation
   * @return  List<Reservation> reservation
   */
  @Override public List<Reservation> getReservationList()
  {
    //        result = "";
    try
    {
      return server.getReservationList();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(
          "Could not get reservation List form server :(");
    }
  }

  /**
   * A function that will return list of menu
   * @return  List<Menu> menu list
   */

  @Override public List<Menu> getMenuList()
  {
    //        result = "";
    try
    {
      return server.getMenuList();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not get menuList form server :(");
    }
    //            result = server.toUpperCase(arg, this);
    //           return menuBroadCastServer.getMenuList(menu,this)
  }
  /**
   * A function that will create a reservation
   * @param reservation   reservation
   */

  @Override public void createReservation(Reservation reservation)
  {
    try
    {
      server.createReservation(reservation);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(
          "Could not able to create reservation RMI client :(");
    }
  }
  /**
   * A function that will fire an event and update a list into client window
   * @param menu   menu
   */

  @Override public void update(Menu menu) throws RemoteException
  {
    support.firePropertyChange("NewMenuEntry", null, menu);
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


