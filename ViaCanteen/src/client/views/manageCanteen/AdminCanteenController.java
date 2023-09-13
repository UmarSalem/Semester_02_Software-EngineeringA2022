package client.views.manageCanteen;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.Menu;
import shared.transferobjects.Reservation;
/**
 * A class that will set up values for Admin canteen controller and manage AdminCanteen.fxml
 */

public class AdminCanteenController implements ViewController
{


  @FXML private ComboBox<String> IsItPickedUp;
  //----------reservationList variables ----------------------------------
  @FXML private TableView<Reservation> reservationTableView;
  @FXML private TableColumn<String, Reservation> phone;
  @FXML private TableColumn<String, Reservation> menuName;
  @FXML private TableColumn<String, Reservation> menuPrice;
  @FXML private TableColumn<String, Reservation> menuQuantity;
  @FXML private TableColumn<String, Reservation> IsMenuPickedUp;
  @FXML private TableColumn<String, Reservation> menuType;


  //-----------menuList  variables--------------------------------------
  @FXML private TableView<Menu> menuTableViewAdmin;
  @FXML private TableColumn<String, Menu> menuNameAdmin;
  @FXML private TableColumn<String, Menu> menuPriceAdmin;
  @FXML private TableColumn<String, Menu> IsMenuVegAdmin;
  @FXML private TableColumn<String, Menu> menuIngredientAdmin;
  @FXML private TableColumn<String, Menu> menuTypeAdmin;
  @FXML private TableColumn<Integer, Menu> idMenuAdmin;

  @FXML private Label errorField;
  @FXML private TextField phoneNo;
  @FXML private TextField totalMenuNo;


  private ViewHandler vh;
  private AdminCanteenViewModel vm;



  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    vm = vmf.getAdminCanteenViewModel();
    //----Binding----------------------------
    errorField.textProperty().bind(vm.getError());
    phoneNo.textProperty().bindBidirectional(vm.getPhoneNo());


//vm.getTotalMenuNo();
    //-----------------------To Display Reservation list---------------------
    vm.loadReservation();
    initializeReservationTableViewAdmin();
    //-----Getter method-----------------

    //-----------Create binding for reservation list with view model---------------------


    //------------Create binding for Admin menu list--------------------------
    initializeMenuTableViewAdmin();
//------------Update Reservation Pickup------------------------------------------
    IsItPickedUp.valueProperty().bindBidirectional(vm.getIsPickUp());
    IsItPickedUp.setItems(
        FXCollections.observableArrayList(Reservation.IsItPickedUp.NO.toString(),
            Reservation.IsItPickedUp.YES.toString()));
    IsItPickedUp.getSelectionModel().selectFirst();
  }
  /**
   * A function that will create binding for reservation list
   */
  public void initializeReservationTableViewAdmin()
  {

    //-----Getter method-----------------
    reservationTableView.setItems(vm.getReservationList());
    //-----------Create binding for reservation list with view model---------------------
    phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
    menuName.setCellValueFactory(new PropertyValueFactory<>("menuName"));
    menuPrice.setCellValueFactory(new PropertyValueFactory<>("menuPrice"));
    //menuQuantity.setCellValueFactory(new PropertyValueFactory<>("menuQuantity"));
    IsMenuPickedUp.setCellValueFactory(new PropertyValueFactory<>("IsMenuPickedUp"));
    menuType.setCellValueFactory(new PropertyValueFactory<>("menuType"));
  }
  /**
   * A function that will create binding for menu list
   */
  public void initializeMenuTableViewAdmin()
  {
    vm.loadAdminMenus();
    menuTableViewAdmin.setItems(vm.getAdminMenuList());
    menuNameAdmin.setCellValueFactory(new PropertyValueFactory<>("menuName"));
    menuPriceAdmin.setCellValueFactory(new PropertyValueFactory<>("menuPrice"));
    IsMenuVegAdmin.setCellValueFactory(new PropertyValueFactory<>("IsMenuVeg"));
    menuIngredientAdmin.setCellValueFactory(new PropertyValueFactory<>("menuIngredient"));
    menuTypeAdmin.setCellValueFactory(new PropertyValueFactory<>("menuType"));
    idMenuAdmin.setCellValueFactory(new PropertyValueFactory<>("id"));

    initializeAdminMenuList();
  }
//-----------------Code for delete Menu-------------------------
  @FXML
  void onDeleteMenu() {
    vm.setSelectedAdminMenu(menuTableViewAdmin.getSelectionModel().getSelectedItems());
    vm.onDeleteMenu();
    initializeAdminMenuList();
  }

  @FXML void onDeleteReservation() {
    vm.onDeleteReservation(reservationTableView.getSelectionModel().getSelectedItem());
    //vm.onDeleteMenu();
   // initializeAdminMenuList();
  }
  private void initializeAdminMenuList()
  {menuTableViewAdmin.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);}
//------------------Code for delete Menu end here----------------------------
//---TODO-----------------------------
  @FXML void PickedUpReservationList()
{vm.setSelectedAdminReservation(reservationTableView.getSelectionModel().getSelectedItem());
  vm.createPickedUpList();vm.loadReservation();}



  @FXML void onAddMenu()
  {
    vh.openToAddMenu();
  }
//----------------Admin Menulist end here

  @FXML
  void upDateMenuList() {
   // vh.openToAdminCanteen();
//vm.upDateMenuList();
    initializeMenuTableViewAdmin();
  }

  /**
   * A function that will refresh reservation list and menu list
   */
  @FXML
  void refreshButton ()
  {
    vm.loadReservation();  initializeReservationTableViewAdmin(); initializeMenuTableViewAdmin();
  }

  @FXML
  void searchReservation() {
    vm.searchReservation();
    initializeReservationTableViewAdmin();
  }



}
