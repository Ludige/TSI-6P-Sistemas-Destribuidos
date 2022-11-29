package corba;

import RemotoApp.Remoto;
import RemotoApp.RemotoHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            poa.the_POAManager().activate();
            
            Operacao op = new Operacao();
            op.setOrb(orb);
            
            org.omg.CORBA.Object ref = poa.servant_to_reference(op);
            Remoto msgRemoto = RemotoHelper.narrow(ref);
            
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            NameComponent path[] = ncRef.to_name("IF");
            ncRef.rebind(path, msgRemoto);
            
            System.out.println("Servidor Ok!!!");
            
            while(true){
                orb.run();
            }
            
        } catch (Exception e) {
            System.err.println("Aqui está o erro:"+ e);
        }
    }
    
}
