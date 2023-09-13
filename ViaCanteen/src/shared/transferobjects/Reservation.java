package shared.transferobjects;

import java.io.Serializable;
/**
 * The Reservation class that is shared between client and server
 */

public class Reservation implements Serializable
{

  @Override public String toString()
  {
    return "Reservation{" + "phone='" + phone + '\'' + ", menuName='" + menuName
        + '\'' + ", menuPrice='" + menuPrice + '\'' + ", menuQuantity="
        + menuQuantity + ", IsMenuPickedUp='" + IsMenuPickedUp + '\''
        + ", menuType='" + menuType + '\'' + ", IsItPickedUp='" + '\'' +'}';
  }
  private String phone;
  private String menuName;
  private String menuPrice;
  private String IsMenuPickedUp;
  private String menuType;
  private String menuQuantity ;
//private String IsItPickedUp;

/*  public Reservation(String phone, String menuName,
      String IsItPickedUp)
  {
    this.phone = phone;
    this.menuName = menuName;
    this.IsItPickedUp = IsItPickedUp;
  }*/


  /**
   * The constructor that initiate reservation attributes
   * @param menuName
   * @param menuPrice
   * @param phone
   * @param isMenuPickedUp
   * @param menuType
   */
  public Reservation(String phone, String menuName, String menuPrice,String isMenuPickedUp, String menuType)
  {
    this.phone = phone;
    this.menuName = menuName;
    this.menuPrice = menuPrice;
    IsMenuPickedUp = isMenuPickedUp;
    this.menuType = menuType;

  }


  public String getPhone()
  {
    return phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }



  public String getMenuName()
  {
    return menuName;
  }

  public void setMenuName(String menuName)
  {
    this.menuName = menuName;
  }

  public String getMenuPrice()
  {
    return menuPrice;
  }

  public void setMenuPrice(String menuPrice)
  {
    this.menuPrice = menuPrice;
  }




  public String getIsMenuPickedUp()
  {
    return IsMenuPickedUp;
  }

  public void setIsMenuPickedUp(String isMenuPickedUp)
  {
    IsMenuPickedUp = isMenuPickedUp;
  }

  public String getMenuType()
  {
    return menuType;
  }

  public void setMenuType(String menuType)
  {
    this.menuType = menuType;
  }

  public enum IsItPickedUp
  {
    YES, NO
  }


}