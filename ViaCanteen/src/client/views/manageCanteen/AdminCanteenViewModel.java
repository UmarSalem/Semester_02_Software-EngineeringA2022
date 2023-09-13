package client.views.manageCanteen;

import client.clientmodel.Admin;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;

import java.util.ArrayList;
import java.util.List;

public class AdminCanteenViewModel
{

  private Admin admin;
private StringProperty phoneNo;
  private StringProperty IsPickUp;
private List<Reservation> selectedPickedUpReservation;

  //------------Constructor--------------------------------
  public AdminCanteenViewModel(Admin admin)
  {
    this.admin = admin;
    error = new SimpleStringProperty();
    IsPickUp= new SimpleStringProperty();
    phoneNo= new SimpleStringProperty();
    selectedAdminMenus=new ArrayList<>();
    selectedPickedUpReservation=new ArrayList<>();
  }

//---------------Code for reservation list----------------------
  private ObservableList<Reservation> reservationObservableList;
  private StringProperty error;

  public void loadReservation()
  {
    if (true)
    {
      List<Reservation> reservationList = admin.getReservationList();
      reservationObservableList = FXCollections.observableArrayList(reservationList);
      error.set("load reservation list");
    }
    else
      error.set("load reservation list failed");
  }

  ObservableList<Reservation> getReservationList() {return reservationObservableList;}

  //------------------code for Admin menu list----------------------
  private ObservableList<Menu> menuAdminObservableList;
  private List<Menu> selectedAdminMenus;
  public void loadAdminMenus()
  {
    List<Menu> menuList = admin.getMenuList();
   // System.out.println(menuList+"admin menulist are here");
    menuAdminObservableList = FXCollections.observableArrayList(menuList);
  }
  ObservableList<Menu> getAdminMenuList()
  {
    return menuAdminObservableList;
  }

  //------------------------Code for Delete menu------------------------
  public void onDeleteMenu()
  {
   Menu menu=selectedAdminMenus.get(0);
    admin.deleteMenu(menu);
    menuAdminObservableList.remove(selectedAdminMenus.get(0));
    selectedAdminMenus.clear();
    System.out.println(selectedAdminMenus.get(0).toString());
  }
  public void setSelectedAdminMenu(ObservableList<Menu> selectedAdminMenus)
  {
    for (Menu i : selectedAdminMenus)
    {
      this.selectedAdminMenus.add(i);
      System.out.println(selectedAdminMenus);
    }
  }
//----------------------Code for Delete Menu End here-------------------------------
  //--------------------Code for Confirmed pickup and delete Reservation here-----------------

  //---TODO-----------------------------
  public void setSelectedAdminReservation(Reservation selectedAdminReservation)
  {
   /* for (Reservation i : selectedAdminReservation)
    {
      this.selectedPickedUpReservation.add(i);
      System.out.println(selectedAdminReservation);
    }*/
    selectedAdminReservation.setIsMenuPickedUp(IsPickUp.get());
    admin.upDateReservationPickUp(selectedAdminReservation.getPhone(),IsPickUp.get());
    System.out.println(selectedAdminReservation.getIsMenuPickedUp()+selectedAdminReservation.getPhone());
  }
  public void onDeleteReservation(Reservation reservation)
  {

    admin.deleteReservation(reservation);;
    System.out.println(reservation);
  }
  //---TODO-----------------------------
  public void createPickedUpList()
  {
   // Reservation pickedUpList=new Reservation(selectedPickedUpReservation.get(0).getPhone(),selectedPickedUpReservation.get(0).getMenuName(),IsPickUp.get());
    //System.out.println("Create picked up list"+pickedUpList);
    /*List <Reservation> list=new ArrayList<>();
    admin.getReservationList();
    for (Reservation i : selectedPickedUpReservation)
    {
      i.setIsMenuPickedUp(IsPickUp.get());
      this.reservationObservableList.add(i);
      //System.out.println(reservationObservableList);
    }*/
  }


  public void upDateMenuList()
  {
loadAdminMenus();
   // admin.getTotalMenuNo();
    }

  StringProperty getError() {return error;}

  StringProperty getPhoneNo() {return phoneNo;}

  public void searchReservation()
  {
    List<Reservation> reservationList = admin.searchReservation(phoneNo.get().trim());
    List<Reservation> list=new ArrayList<>();
    System.out.println(phoneNo.get());
    System.out.println(" reservationList by phone VW are here"+reservationList);
    for (Reservation i : reservationList)
    {
      if (i.getPhone().equals(phoneNo.get()) )
     list.add(i);
      System.out.println(list);
    }
    reservationObservableList = FXCollections.observableArrayList(list);
  }

  public StringProperty getIsPickUp()
  {return IsPickUp;}


  //StringProperty getTotalMenuNo() {return totalMenuNo;}


}
