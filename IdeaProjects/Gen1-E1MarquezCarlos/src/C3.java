import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C3
{
    public static void main(String[] args)
    {
        int alum;
        int j =0;
        double suma = 0;
        int opt=0;
        double promt=0;
        int rep = 0;
        int apr = 0;
        String busqueda;
        List<Double> promp = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        System.out.println("Ingresa el numero de alumnos");
        alum = s.nextInt();

        List<String> nom = new ArrayList<>();

        double[][] cal = new double[alum][10];

        for (int i=0; i<alum;i++)
        {
            System.out.println("Nombre del alumno:");
            nom.add (s.next());
            while( j <10) {
                System.out.println("Ingresa la calificacion " + (j + 1));
                cal[i][j] = s.nextInt();

                if (cal[i][j] < 0 && cal[i][j] > 10) {
                    System.out.println("Debes de ingresar un numero positivo valido");

                } else {
                    suma += cal[i][j];

                    j++;
                }
            }
            j=0;
            suma = (suma/10);

            promp.add(suma);
            suma = 0;
            if (promp.get(i)<6)
            {
                rep++;
            }else
            {
                apr++;
            }
        }
        for (int i = 0; i < alum; i++)
        {
            promt += promp.get(i);
        }
        promt=(promt/alum);

        System.out.println("El promedio del grupo es: " + promt);
        System.out.println("El numero de alumnos reprobados es: " + rep);
        System.out.println("El numero de alumnos aprobados es: " + apr);

        while(opt!=2)
        {
            System.out.println("¿Deseas buscar a algun alumno? Si(1) No(2)");
            opt = s.nextInt();
            if (opt>2 || opt<1)
            {
                System.out.println("Seleccione una opcion valida");
                opt=0;
            }
            else if (opt==1)
            {
                System.out.println("Ingrese el nombre del alumno que desea buscar: ");
                busqueda = s.next();
                int indice = nom.indexOf(busqueda);

                if (indice != -1) {
                    System.out.println("Las calificaciones del alumno " + busqueda + " son:");
                    for (int i = 0; i < 10; i++)
                    {
                        System.out.println(cal[indice][i]);
                    }
                    System.out.println("Y su promedio es: " + promp.get(indice));
                } else {
                    System.out.println("El alumno no esta registrado");
                }
            }else
            {
                System.out.println("Hasta luego");
            }
        }


    }
}
