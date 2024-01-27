import java.util.Scanner;

public class C5
{
    public static void main(String[] args)
    {
        int suma = 0;

        int numeros[];
        numeros= new int [5];

        Scanner s = new Scanner(System.in);

        /*System.out.println("Ingresa el dato: ");
        numeros[0] = s.nextInt();

        System.out.println("Ingresa el dato: ");
        numeros[1] = s.nextInt();

        System.out.println("Ingresa el dato: ");
        numeros[2] = s.nextInt();

        System.out.println("Ingresa el dato: ");
        numeros[3] = s.nextInt();

        System.out.println("Ingresa el dato: ");
        numeros[4] = s.nextInt();

        suma  = numeros[0] + numeros[1] + numeros[2] + numeros[3] + numeros[4];
        System.out.println(suma);*/

        for( int i=0;i<5; i++)
        {
            System.out.println("Ingresa el dato: ");
            numeros[i] = s.nextInt();
            suma += numeros[i];
        }
        System.out.println(suma);

        for (int i = 0; i < 5; i++)
        {
            System.out.println(numeros[i]);
        }
        for (int f : numeros)
        {
            System.out.println(numeros[f]);
        }
    }
}
