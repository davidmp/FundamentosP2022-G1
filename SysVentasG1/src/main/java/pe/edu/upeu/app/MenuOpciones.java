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
        System.out.println("********************Bienvenidos al Sistema de Ventas******************");
        String valorX="1=Registrar Producto\n"+"2=Registrar cliente\n"+
                "3=Registrar Venta\n";
        int opciones=1;
        do {
            switch (opciones) {
                case 1: System.out.println("Registrando producto"); break;
                case 2: System.out.println("clientes"); break;
                default: System.out.println("Opcion erronea!"); break;
            }
            char continuar=leerT.leer("", "Desea continuar? S=si/N=no")
                            .toLowerCase()
                            .charAt(0)=='s'?'s':'n';
            if (continuar=='s') {
                opciones=leerT.leer(0, "Eliga la siguiente operacion:\n"+valorX);
            }else{opciones=0;}

        } while (opciones!=0);
        
    }

}
