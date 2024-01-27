import java.util.Scanner;
import java.util.SortedMap;

public class C3
{

    public static void main(String[] args)
    {
        String pass;
        String usuario;
        Scanner s = new Scanner(System.in);

        System.out.println("Bienvenido");
        System.out.println("Ingresa el usuario: ");
        usuario=s.next();
        System.out.println("Ingrsa la contraseña: ");
        pass = s.next();

        validarUsuario(usuario,pass);
    }

    private static void validarUsuario(String usuario, String pass)
    {
        String usuarior = "Charlie";
        String passr = "Eribeto";

        if(usuarior.equals(usuario)&&passr.equals(pass))
        {
            System.out.println(saludar(usuario));
        }
        else
        {
            System.out.println(error(usuario));
        }
    }

    private static String saludar(String usuario)
    {
        String saludo = "Bienvenido " + usuario;
        return saludo;
    }
    private static String error(String usuario)
    {
        String error = "No se puede verificar el usuario " + usuario + " favor de intentar de nuevo";
        return error;
    }
}
