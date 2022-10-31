package corba;

import RemotoApp.Remoto;
import RemotoApp.RemotoHelper;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            Remoto addobj = RemotoHelper.narrow(ncRef.resolve_str("IF"));
            JOptionPane.showMessageDialog(null, "Conexão OK");
            
            
            int menor = addobj.menorNum(12, 23, 1);
            JOptionPane.showMessageDialog(null, "Menor Numero: " + menor);
        
            
            int raiz = addobj.raizQuadrada(25);
            JOptionPane.showMessageDialog(null, "Raiz: " + raiz);
            
            int fator = addobj.fatorial(5);
            JOptionPane.showMessageDialog(null, "Fatorial: " + fator);
        } catch (Exception e) {
            System.err.println("Aqui está o erro:"+ e);
        }
    }
    
}
