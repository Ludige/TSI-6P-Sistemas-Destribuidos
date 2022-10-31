package dsd6p;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiggi
 */
public class Client {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        /*
        Chat chat = (Chat) Naming.lookup("10.0.2.14");
        Integer x = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro numero"));
        Integer y = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo numero"));
        JOptionPane.showMessageDialog(null, chat.multiplicar(x,y);
        */
  
        Chat chat = (Chat) Naming.lookup("10.0.2.15/tsi6");
        Double x = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro numero"));
        Double y =  Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo numero"));
        JOptionPane.showMessageDialog(null, chat.restOfDivision(x, y));
    }
}
