package Controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interfaz_Sucursal extends Remote{
    
    String sayHello() throws RemoteException;
      
}
