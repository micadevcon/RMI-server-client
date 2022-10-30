import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class JavaClient {
    public static final String UNIC_BINDING_NAME = "server.reverse";
   public static void main (String [] args) throws RemoteException, NotBoundException {
    
   
final Registry registry = LocateRegistry.getRegistry(2001);


 Reverse service = (Reverse) registry.lookup(UNIC_BINDING_NAME);


 int result = service.reverse(121);
 System.out.println(result);
   }
}