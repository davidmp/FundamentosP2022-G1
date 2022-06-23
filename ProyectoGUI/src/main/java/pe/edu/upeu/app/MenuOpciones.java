package pe.edu.upeu.app;

import java.io.Console;

import pe.edu.upeu.modelo.UsuarioTO;
import pe.edu.upeu.util.LeerTeclado;

public class MenuOpciones {
    LeerTeclado leerT=new LeerTeclado();
    UsuarioTO user;

    public void login() {
        System.out.println("***********Validar sus Credenciales***********");
        user=new UsuarioTO();
        user.setUsuario(leerT.leer("", "Ingrese su Usuario"));
        Console cons=System.console();
        System.out.println("Ingrese su clave:");
        char[] clavex=cons.readPassword();
        user.setClave(String.valueOf(clavex));
        if (user.getUsuario().equals("davidmp") && 
        user.getClave().equals("123456")) {
            menuPrincial();
        }else{
            System.out.println("Intente Otra vez!");
            login();
        }
    }

    public void menuPrincial() {
        System.out.println("Ingreso!!!.....");
    }

}
