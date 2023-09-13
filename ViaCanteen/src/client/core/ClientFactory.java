package client.core;

import client.networking.Client;
import client.networking.RMIClient;

/**
 * The class that creates and store all the client
 */
public class ClientFactory
{

  private Client client;

  /**
   * A function that will return Client
   * @return Client
   */
  public Client getClient()
  {
    if (client == null)
    {
      client = new RMIClient();
    }
    return client;
  }
}
