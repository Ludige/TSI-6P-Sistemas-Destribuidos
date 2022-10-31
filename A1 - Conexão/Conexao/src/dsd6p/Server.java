package dsd6p;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author Luiggi
 */
public class Server {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
       Controller ctr = new Controller();
       Naming.rebind("10.0.2.14", ctr);//10.0.2.14
    }
}
