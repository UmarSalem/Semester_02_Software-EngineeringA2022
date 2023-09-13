package client.views.manageCanteen;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class AdminUserIdController implements ViewController
{
  private AdminUserIdViewModel viewModel;
  private ViewHandler vh;

  @FXML private Label errorLabel;
  @FXML private TextField passwardField;
  @FXML private TextField userIdField;


  /**
   * A constructor that will initialize all the variables
   * @param  vh vmf
   */
  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewModel = vmf.getUppercaseViewModel();
    this.vh = vh;
    userIdField.textProperty().bindBidirectional(viewModel.userIdProperty());
    passwardField.textProperty()
        .bindBidirectional(viewModel.passwardProperty());
    errorLabel.textProperty().bind(viewModel.errorProperty());
  }

  @FXML void onLogIn()
  {

    {
      //-------verify login and passward for Admin-----------
      viewModel.onLogIn();
    }
    loginSuccessFull();
    //----------end--------------------
    //    vh.openToAdminCanteen();
  }

  /**
   * A function that will return Admin login window if login successful
   * @return admin window
   */
  void loginSuccessFull()
  {
    if (viewModel.onLogIn() == true)
      vh.openToAdminCanteen();
  }

}
