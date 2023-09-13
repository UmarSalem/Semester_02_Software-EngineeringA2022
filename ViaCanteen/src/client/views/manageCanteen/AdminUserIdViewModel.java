package client.views.manageCanteen;

import client.clientmodel.Admin;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * A class that will set up values for Admin UserId view model
 */


public class AdminUserIdViewModel
{

  private Admin admin;

  private StringProperty userId;
  private StringProperty passward;
  private StringProperty error;

  private StringProperty createuserId;
  private StringProperty createPassward;
  private StringProperty request;
  private StringProperty reply;

  /**
   * A constructor that will initialize all the variables
   * @param admin
   */

  public AdminUserIdViewModel(Admin admin)
  {
    this.admin = admin;
    request = new SimpleStringProperty();
    reply = new SimpleStringProperty();
    error = new SimpleStringProperty();

    //-----------Umar code
    passward = new SimpleStringProperty();
    userId = new SimpleStringProperty();

  }

  /**
   * A function that will check login credentials
   * @return error values
   */
  boolean onLogIn()
  {
    String input1 = userId.get();
    String input2 = passward.get();
    if (((input1 != null) && !"".equals(input1)) && ((input2 != null)
        && !"".equals(input2)))
    {
      String result = admin.verifyUserIdAndCode(input1, input2);

      if (result.equals("Invalid Username or Password!"))
      {
        error.set(result);
        userId.set("");
        passward.set("");
        return false;
      }
      else
      {
        error.set(result);
        return true;
      }
    }
    else
    {
      error.set("login failed");
      return false;
    }
  }

  StringProperty userIdProperty()
  {
    return userId;
  }
  StringProperty passwardProperty()
  {
    return passward;
  }
  StringProperty errorProperty()
  {
    return error;
  }

}
