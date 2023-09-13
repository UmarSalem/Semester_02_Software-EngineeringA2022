package client.views.loginWindow;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.manageCanteen.AdminUserIdViewModel;
import javafx.fxml.FXML;
/**
 * A class that will set up values for login.fxml
 */
public class LoginViewController implements ViewController
{

  private AdminUserIdViewModel viewModel;
  private ViewHandler vh;

  @FXML void loginAsAdmin()
  {
    vh.openToAdminUserIdScene();
    //    vh.openToAdminCanteen();
    System.out.println("welcome Admin");
  }

  @FXML void loginAsGuest()
  {
    vh.openToReservation();
    System.out.println("welcome guest");
  }

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;

  }
}
