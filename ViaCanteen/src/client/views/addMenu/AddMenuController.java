package client.views.addMenu;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import shared.transferobjects.MenuType;

/**
 * @author Nauman
 * A class that will set up values for AddMenu.fxml
 */
public class AddMenuController implements ViewController
{

  private ViewHandler vh;
  private AddMenuViewModel vM;

  @FXML private TextField IsMenuVegField;
  @FXML private TextField menuIngredientField;
  @FXML private TextField menuNameField;
  @FXML private TextField menuPriceField;
  @FXML private TextField menuQuantityField;
  @FXML private ComboBox<String> menuTypeChoiceBox;

  /**
   * A function that will initialize the variable,create a binding of variable
   *   @param vh vmf
   */
  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    this.vM = vmf.getAddMenuViewModel();
    menuNameField.textProperty().bindBidirectional(vM.menuNameProperty());
    IsMenuVegField.textProperty().bindBidirectional(vM.isMenuVegProperty());
    menuQuantityField.textProperty()
        .bindBidirectional(vM.menuQuantityProperty());
    menuIngredientField.textProperty()
        .bindBidirectional(vM.menuIngredientProperty());
    menuPriceField.textProperty().bindBidirectional(vM.priceProperty());
    menuTypeChoiceBox.valueProperty().bindBidirectional(vM.getMenuType());
    menuTypeChoiceBox.setItems(
        FXCollections.observableArrayList(MenuType.SAND_WITCH.toString(),
            MenuType.WARM_MENU.toString(), MenuType.COLD_MENU.toString()));
    menuTypeChoiceBox.getSelectionModel().selectFirst();
  }

  /**
   * A function that will add menu
   */
  @FXML void addMenu()
  {

    vM.addMenu();
    System.out.println("add menu working");
  }

  @FXML void cancelMenu()
  {
    vh.openToAdminCanteen();
  }

  @FXML void back()
  {
    vh.openToAdminCanteen();
  }

}
