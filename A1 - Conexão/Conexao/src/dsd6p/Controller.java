package dsd6p;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Luiggi\
 */
public class Controller extends UnicastRemoteObject implements Chat{
    private static final long serialVersionUID = 1L;
     
    protected Controller() throws RemoteException{
        super();
    }
    
    @Override
    public String multiplicar(Integer x, Integer y) {
       return x + " multiplicado por " + y +" = "+ x*y;
    }
    
}
