package server;

import server.networking.RMIServerImpl;
import server.servermodel.serverModel.ServerModelProxy;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
/**
 * The class that have a main method and create a object of RMI server, and start the server
 */
public class RunServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {

    RMIServerImpl ss = new RMIServerImpl(new ServerModelProxy());
    ss.startServer();
    System.out.println("server starting");
  }
}
