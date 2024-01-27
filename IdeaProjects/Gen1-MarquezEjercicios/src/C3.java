import java.util.Scanner;

public class C3
{
    public static void main(String[] args)
    {
        int rc;
        int ri;
        int rb;

        Scanner s = new Scanner(System.in);

        System.out.println("Ingresa el numero de respuestas correctas");
        rc = s.nextInt()*4;
        System.out.println("Ingresa el numero de respuestas incorrectas");
        ri = s.nextInt()*(-1);
        System.out.println("Ingresa el numero de respuestas en blanco");
        rb = s.nextInt();

        System.out.println("El puntaje final es: " + (rc + ri) + (rb*0));

    }
}
