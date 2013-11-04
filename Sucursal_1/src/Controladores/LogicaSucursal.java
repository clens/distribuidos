package Controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LogicaSucursal extends UnicastRemoteObject implements Interfaz_Sucursal
{
    public LogicaSucursal() throws RemoteException {                   
    }

    @Override
    public String sayHello() throws RemoteException {
        String retorno = "Hola Mundo";
        
        return retorno;
    } 
}
