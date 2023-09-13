package server.networking;

import server.servermodel.serverModel.ServerModel;
import shared.networking.ClientCallback;
import shared.networking.RMIServer;
import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIServerImpl implements RMIServer
{

  private ServerModel serverModel;
  //private Guest guest;
  //  private BroadCastMenuManager broadCastMenuManager;

  public RMIServerImpl(ServerModel serverModel) throws RemoteException
  {
    this.serverModel = serverModel;
    UnicastRemoteObject.exportObject(this, 0);
  }

  public void startServer()
  {
    Registry registry = null;
    try
    {
      registry = LocateRegistry.createRegistry(1099);
      registry.bind("ViaCanteen", this);
    }
    catch (RemoteException | AlreadyBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public String verifyUserIdAndCode(String str, String code)
      throws RemoteException
  {
    return serverModel.verifyUserIdAndCode(str, code);
  }

  @Override public void addMenu(Menu menu) throws RemoteException
  {
    serverModel.addMenu(menu);
    System.out.println("Server added menu");
  }

  @Override public void deleteMenu(Menu menu) throws RemoteException
  {
    serverModel.deleteMenu( menu);
    System.out.println("Server delete menu");
  }

  @Override public List<Menu> getMenuList() throws RemoteException
  {
    return serverModel.getMenuList();
  }

  @Override public List<Reservation> searchReservation(String phone)
      throws RemoteException
  {
    return serverModel.searchReservation(phone);
  }

  @Override public List<Reservation> upDateReservationPickUp(String phone,
      String isPickedUp) throws RemoteException
  {
    return serverModel.upDateReservationPickUp( phone,
       isPickedUp);
  }

  @Override public void deleteReservation(Reservation reservation)
      throws RemoteException
  {
    serverModel.deleteReservation(reservation);
    System.out.println("Server deleteReservation");
  }

  @Override public void createReservation(Reservation reservation)
      throws RemoteException

  {
    serverModel.createReservation(reservation);
    System.out.println("RMI server create reservation");
  }

  @Override public List<Reservation> getReservationList() throws RemoteException
  {
    return serverModel.getReservationList();
  }

  @Override public void registerCallback(ClientCallback ccb)
      throws RemoteException
  {
    serverModel.addListener("NewMenuEntry", evt -> {
      try
      {
        ccb.update((Menu) evt.getNewValue());
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
    });
  }

  //  @Override public List<Menu> getMenuList(List<Menu> menu,
  //      MenuBroadCastClient menuClient) throws RuntimeException, RemoteException
  //  {
  //    broadCastMenuManager.getMenuList(menu,menuClient);
  //    return menu;
  //  }
  //
  //  @Override public void registerMenuClient(MenuBroadCastClient menuClient)
  //      throws RuntimeException
  //  {
  //broadCastMenuManager.registerMenuClient(menuClient);
  //  }

  //    @Override
  //    public String toUppercase(String str) throws RemoteException {
  //        return textManager.toUppercase(str);
  //    }
  //
  //    @Override
  //    public List<LogEntry> getLogs() throws RemoteException {
  //        return textManager.getLog();
  //    }

  //    @Override
  //    public void registerCallback(ClientCallback ccb) throws RemoteException {
  //        textManager.addListener("NewLogEntry", evt -> {
  //            try {
  //                ccb.update((LogEntry) evt.getNewValue());
  //            } catch (RemoteException e) {
  //                e.printStackTrace();
  //            }
  //        });
  //    }

  //    @Override public void createLogin(String userId, String passward) throws RemoteException
  //    {
  //         textManager.createLogin(userId,passward);
  //    }
}
