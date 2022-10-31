package dsd6p;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Luiggi
 */
public interface Chat extends Remote{
    public String multiplicar(Integer x, Integer y) throws RemoteException;
}
