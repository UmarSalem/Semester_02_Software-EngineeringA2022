package client.core;

import client.clientmodel.Admin;
import client.clientmodel.AdminManager;

/**
 * The class that creates and stores all models
 */
public class ModelFactory
{

  private final ClientFactory cf;


  private Admin admin;
  //  private ManageOrdering manageOrdering;
  /**
   * A constructor that will initialize client factory
   */
  public ModelFactory(ClientFactory cf)
  {
    this.cf = cf;
  }


  /**
   * A function that will return adminModel
   * @return admin
   */
  public Admin getAdmin()
  {
    if (admin == null)
      admin = new AdminManager(cf.getClient());
    return admin;
  }

}


