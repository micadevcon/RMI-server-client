import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

interface Reverse extends Remote
{
 public int reverse(int num) throws RemoteException;
}

class ReverseImpl implements Reverse
{
 public int reverse(int num) throws RemoteException
 {
  return (int) Math.sqrt(num) ;
 }
}

public class JavaServer { 
    
    public static final String UNIC_BINDING_NAME = "server.reverse";
   public static void main (String [] args) throws RemoteException, AlreadyBoundException, InterruptedException{
 final ReverseImpl service = new ReverseImpl();
 
 System.out.println("Запуск Server успешно!...");
 final Registry registry = LocateRegistry.createRegistry(2001);
 
 Remote stub;
      stub = UnicastRemoteObject.exportObject(service, 0);
 
 registry.bind(UNIC_BINDING_NAME, stub);


 Thread.sleep(Integer.MAX_VALUE);
   }
}