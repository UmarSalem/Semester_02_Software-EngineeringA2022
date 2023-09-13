package client.core;

import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * A class that deals with loading fxml files and loading stages.
 */

public class ViewHandler
{
  private Stage stage;
  private ViewModelFactory vmf;
  private Scene logScene;
  //----------umar code--------------
  private Scene loginScene;
  private Scene reservationScene;
  private Scene adminScene;
  private Scene adminUserIdScene;
  private Scene addMenuScene;

  /**
   * A constructor that will initialize viewmodelfactory and stage
   */


  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  /**
   * A function that will start the stage on login app.
   * */
  public void start()
  {
    stage = new Stage();
    openToLogin();
    //        openToUppercase();

  }
  /**
   * Opens the login scene in a new Stage
   */
  public void openToLogin()
  {
    if (loginScene == null)
    {
      try
      {
        Parent root = loadFXML("../views/loginWindow/login.fxml");

        stage.setTitle("VIA CANTEEN Welcome Window");
        loginScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    stage.setScene(loginScene);
    stage.show();
  }
  /**
   * Opens the Manage ordering scene in a new Stage
   */
  public void openToReservation()
  {
    if (reservationScene == null)
    {
      try
      {
        Parent root = loadFXML("../views/ManageOrdering/manageOrdering.fxml");
        stage.setTitle("Client Ordering Window");
        reservationScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    stage.setScene(reservationScene);
    stage.show();
  }

  /**
   * Opens the Admin Canteen scene in a new Stage
   */
  public void openToAdminCanteen()
  {
    if (adminScene == null)
    {
      try
      {
        Parent root = loadFXML("../views/manageCanteen/AdminCanteen.fxml");
        stage.setTitle("Admin Canteen window");
        adminScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    stage.setScene(adminScene);
    stage.show();
  }
  /**
   * Opens the login scene in a new Stage
   */
  public void openToAdminUserIdScene()
  {
    if (adminUserIdScene == null)
    {
      try
      {
        Parent root = loadFXML("../views/manageCanteen/AdminUserId.fxml");
        stage.setTitle("Admin Userid Window");
        adminUserIdScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    stage.setScene(adminUserIdScene);
    stage.show();
  }
  /**
   * Opens the Add Menu scene in a new Stage
   */
  public void openToAddMenu()
  {
    if (addMenuScene == null)
    {
      try
      {
        Parent root = loadFXML("../views/addMenu/AddMenu.fxml");

        stage.setTitle("Add Menu Window");
        addMenuScene = new Scene(root);
      }
      catch (IOException e)
      {

        e.printStackTrace();
      }
    }
    stage.setScene(addMenuScene);
    stage.show();
  }

  /**
   * a private function that will loadFXML file
   */
  private Parent loadFXML(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController ctrl = loader.getController();
    ctrl.init(this, vmf);
    return root;
  }

}
