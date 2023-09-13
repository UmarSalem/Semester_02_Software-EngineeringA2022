package client.views.manageOrdering;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.Menu;
/**
 * A class that will set up values for manageOrdering.fxml
 */

public class ManageOrderingController implements ViewController
{
  //-----------menuList--------------------------------------
  @FXML private TableView<Menu> menuTableView;
  @FXML private TableColumn<String, Menu> menuName;
  @FXML private TableColumn<String, Menu> price;
  @FXML private TableColumn<String, Menu> IsMenuVeg;
  @FXML private TableColumn<String, Menu> menuIngredient;
  @FXML private TableColumn<String, Menu> menuType;
 @FXML private TableColumn<Integer, Menu> menuId;
  //  @FXML private ChoiceBox<Menu.MenuType> menuChoiceBox;

  //-----------Reserve Menu--------------------------------
  @FXML private TextField phoneField;
  @FXML private Label error;
  //-----------------Other attribute-------------------------------
  //  private ObservableList<Menu> MenuListToShow;
  private ViewHandler vh;
  private ManageOrderingViewModel vm;



  /**
   * A function that will initialize the variable,and having a method to create binding of variable
   *   @param vh vmf
   */
  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    vm = vmf.getManageOrderingViewModel();
    vm.loadMenus();
    menuTableView.setItems(vm.getMenuList());
    error.textProperty().bind(vm.getError());
    phoneField.textProperty().bindBidirectional(vm.getPhone());
    initializeMenuList();

    initializeMenuTableView();

  }
  /**
   * A function that will create binding for menu list in Manage Ordering Controller
   */
  public void initializeMenuTableView()
  {
    vm.loadMenus();
    menuTableView.setItems(vm.getMenuList());
    //-----Getter method-----------------

    //-----------Create binding for reservation list with view model---------------------
    IsMenuVeg.setCellValueFactory(new PropertyValueFactory<>("IsMenuVeg"));
    menuIngredient.setCellValueFactory(new PropertyValueFactory<>("menuIngredient"));
    menuName.setCellValueFactory(new PropertyValueFactory<>("menuName"));
    menuType.setCellValueFactory(new PropertyValueFactory<>("menuType"));
    price.setCellValueFactory(new PropertyValueFactory<>("menuPrice"));
    menuId.setCellValueFactory(new PropertyValueFactory<>("id"));

  }






  //--------method use to select menu from menu list-----------------
  @FXML void reserveMenu()
  {
    vm.setSelectedMenu(menuTableView.getSelectionModel().getSelectedItems());
    vm.reserveMenu();
    initializeMenuList();
  }

  private void initializeMenuList()
  {
    menuTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

  }

  @FXML void searchingMenu()
  {

  }
  @FXML void refreshButton()
  {
initializeMenuTableView();
  }


}
