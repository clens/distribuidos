package Controladores;

import Vistas.MenuPrincipal;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Sucursal 
{
    private void IniciarServidor()
    {
        Properties objProperties = new Properties();
        String host = "";
        int puerto = 0;
        InputStream is = null;
        try 
        {
          is = new FileInputStream("app.config.properties");
          objProperties.load(is);
          host = objProperties.getProperty("ipSucursal");
          puerto = Integer.parseInt(objProperties.getProperty("puertoSucursal"));
        }
        catch(IOException ioe) 
        {
            ioe.printStackTrace();
        }         
        try
        {
            System.setProperty("java.rmi.server.hostname" , host);            
            Registry registro = LocateRegistry.createRegistry(puerto);            
            registro.rebind("Sucursal1", new LogicaSucursal());
        } 
        catch (Exception e) 
        {
              JOptionPane.showMessageDialog(null,"Servidor no puede iniciar "+e,"Información", JOptionPane.ERROR_MESSAGE);
        }      
    }    
    
    public static void main(String[] args) 
    {
        new Sucursal().IniciarServidor();
        new MenuPrincipal().setVisible(true);             
    }
}
