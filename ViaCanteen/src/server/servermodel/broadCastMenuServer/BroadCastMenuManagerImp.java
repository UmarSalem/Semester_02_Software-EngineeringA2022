package server.servermodel.broadCastMenuServer;//package server.servermodel.broadCastMenuServer;
//
//import client.network.MenuBroadCastClient;
//import shared.transferobjects.Menu;
//import shared.transferobjects.MenuList;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BroadCastMenuManagerImp implements BroadCastMenuManager
//{
//  private List<MenuBroadCastClient> broadcastClients = new ArrayList<>();
//  private MenuList menuList;
//
//  public BroadCastMenuManagerImp(MenuList menuList)
//  {
//    this.menuList = menuList;
//  }
//
////  @Override public MenuList getMenuList(List<Menu> menu,
////      MenuBroadCastClient menuClient) throws RuntimeException, RemoteException
//
//  @Override public List<Menu> getMenuList(MenuBroadCastClient menuClient)
//      throws RemoteException
//  {
//
////    List<Menu> result =  menuList;
//    try {
//      Thread.sleep(2000);
//
//      return  menuList;
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
////    broadcastToClients((List<Menu>) menuList, menuClient);
//
//
//  }
//
//
//  @Override public void registerMenuClient(MenuBroadCastClient menuClient)
//  {
//    broadcastClients.add(menuClient);
//  }
//
//  private List<Menu> broadcastToClients( MenuBroadCastClient client)
//      throws RemoteException
//  {
//    List <Menu>  list=new ArrayList<>();
//    for (MenuBroadCastClient bClient : broadcastClients) {
//
//       list.add((Menu) bClient.getMenuList());
//
////      bClient.updateMenuList(menu);
////      if(!bClient.equals(client)){
////      }
//    }
//return list;
//  }
//
//
//
//}
