import java.util.Scanner;

public class C1
{
    public static void main(String[] args)
    {
        int alumnos;
        int alumnas;
        int totalalum;
        Scanner s  = new Scanner(System.in);

        System.out.println("Numero de alumnos en la escuela: ");
        alumnos = s.nextInt();

        System.out.println("Numero de alumnas en la escuela: ");
        alumnas = s.nextInt();

        totalalum = alumnas + alumnos;

        System.out.println("El porcentaje de alumnos es: " + ((100.0*alumnos)/totalalum) + "%");
        System.out.println("El porcentaje de alumnos es: " + ((100.0*alumnas)/totalalum) + "%");
    }
}
