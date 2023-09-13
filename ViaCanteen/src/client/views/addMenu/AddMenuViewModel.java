package client.views.addMenu;

import client.clientmodel.Admin;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferobjects.Menu;

/**
 * @author Nauman
 * A class that will set up values for Add Menu
 */

public class AddMenuViewModel
{

  private Admin admin;
  //-----------------------------------------------
  private StringProperty menuName, menuIngredient, IsMenuVeg;
  private StringProperty menuQuantity;
  private StringProperty price;
  private StringProperty menuType;



  /**
   * A constructor that will initialize all the variables
   * @param admin
   */
  public AddMenuViewModel(Admin admin)
  {
    this.admin = admin;

    menuName = new SimpleStringProperty();
    menuIngredient = new SimpleStringProperty();
    IsMenuVeg = new SimpleStringProperty();
    menuQuantity = new SimpleStringProperty();
    price = new SimpleStringProperty();
    menuType = new SimpleStringProperty();
    //    error=new SimpleStringProperty();
  }

  /**
   * A function that will return username used by receptionist
   * @return menuName menuIngredient IsMenuVeg menuQuantity price menuType
   */
  StringProperty menuNameProperty() {return menuName;}
  StringProperty menuIngredientProperty()
  {
    return menuIngredient;
  }
  StringProperty isMenuVegProperty()
  {
    return IsMenuVeg;
  }
  StringProperty menuQuantityProperty()
  {
    return menuQuantity;
  }
  StringProperty priceProperty()
  {
    return price;
  }
  StringProperty getMenuType()
  {
    return menuType;
  }
  //   StringProperty errorProperty() {return error;}

  //----------------------------------------------------------------


  //----------------------------------------------------------------
  /**
   * A function that will add menu
   */
  public void addMenu()
  {
    String menu_Name = menuName.get().trim();
    String menu_Price = price.get().trim();
    int menu_Quantity = Integer.parseInt(menuQuantity.get().trim());
    String menu_Ingredient = (menuIngredient.get().trim());
    String menu_IsMenuVeg = IsMenuVeg.get().trim();
    String menu_Type = (menuType.get().trim());
    Menu menu = new Menu(menu_Name, menu_Price, menu_Quantity, menu_Ingredient,
        menu_IsMenuVeg, menu_Type);
    admin.addMenu(menu);
  }
}
