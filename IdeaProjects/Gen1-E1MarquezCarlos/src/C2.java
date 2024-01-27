import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C2
{
    public static void main(String[] args)
    {
        List<Integer> num = new ArrayList<>();
        int numMin = 0;
        int numMax = 0;
        double suma = 0;
        int i=0;
        Scanner s = new Scanner(System.in);

        while(num.size()<5)
        {
            System.out.println("Ingresa un numero: ");
            num.add(s.nextInt()) ;
            if(i==0)
            {
                numMin = num.get(i);
                numMax = num.get(i);

            }
            if (num.get(i)<0)
            {
                System.out.println("Debes de ingresar un numero positivo");
                num.remove(i);

            }else
            {
                suma += num.get(i);


                if (numMin>num.get(i))
                {
                    numMin = num.get(i);
                }
                if(numMax<num.get(i))
                {
                    numMax = num.get(i);
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
