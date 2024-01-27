import java.util.Scanner;

public class C1
{
    public static void main(String[] args)
    {
        int [] numeros = new int[20];
        int i=0;
        int numMin = 0;
        int numMax = 0;
        double suma = 0;
        Scanner s = new Scanner(System.in);

        while(i<20)
        {
            System.out.println("Ingresa un numero: ");
            numeros[i] = s.nextInt();
            if(i==0)
            {
                numMin = numeros[i];
                numMax = numeros[i];

            }
            if (numeros[i]<0)
            {
                System.out.println("Debes de ingresar un numero positivo");

            }else
            {
                suma += numeros[i];


                if (numMin>numeros[i])
                {
                    numMin = numeros[i];
                }
                if(numMax<numeros[i])
                {
                    numMax = numeros[i];
                }

                i++;
            }
        }
        System.out.println("El numero mas grande es:" + numMax);
        System.out.println("El numero mas chico es:" + numMin);
        System.out.println("El promedio es:" + (suma/5.0));
        System.out.println("La suma de los numeros es:" + suma);
    }
}
