package client.core;

import client.views.addMenu.AddMenuViewModel;
import client.views.manageCanteen.AdminCanteenViewModel;
import client.views.manageCanteen.AdminUserIdViewModel;
import client.views.manageOrdering.ManageOrderingViewModel;

/**
 * @author umar saleem,nauman, saqlain,Digvijaya
 * Creates and stores all the view models
 */

public class ViewModelFactory
{

  //-----------Umar code--------------
  private final ModelFactory mf;
  private AdminUserIdViewModel adminUserIdViewModel;
  private AddMenuViewModel addMenuVM;
  private ManageOrderingViewModel manageOrderingViewModel;

  private AdminCanteenViewModel adminCanteenViewModel;
  //------------------------------------------------
  /**
   * A constructor that will initialize modelFactory
   */
  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }


  /**
   * A function that will return AdminUserIdViewModel
   * @return AdminUserIdViewModel
   */
  public AdminUserIdViewModel getUppercaseViewModel()
  {
    if (adminUserIdViewModel == null)
      adminUserIdViewModel = new AdminUserIdViewModel(mf.getAdmin());
    return adminUserIdViewModel;
  }
  /**
   * A function that will return AddMenuViewModel
   * @return AddMenuViewModel
   */

  public AddMenuViewModel getAddMenuViewModel()
  {
    if (addMenuVM == null)
      addMenuVM = new AddMenuViewModel(mf.getAdmin());
    return addMenuVM;
  }

  /**
   * A function that will return ManageOrderingViewModel
   * @return ManageOrderingViewModel
   */

  public ManageOrderingViewModel getManageOrderingViewModel()
  {
    if (manageOrderingViewModel == null)
      manageOrderingViewModel = new ManageOrderingViewModel(mf.getAdmin());
    return manageOrderingViewModel;
  }

  /**
   * A function that will return AdminCanteenViewModel
   * @return AdminCanteenViewModel
   */
  public AdminCanteenViewModel getAdminCanteenViewModel()
  {

    if (adminCanteenViewModel == null)
      adminCanteenViewModel = new AdminCanteenViewModel(mf.getAdmin());
    return adminCanteenViewModel;

  }


}
