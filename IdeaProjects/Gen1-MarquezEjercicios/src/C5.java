import java.util.Scanner;

public class C5
{
    public static void main(String[] args)
    {
        int valor;
        int menor = 0;
        int mayor = 0;
        double suma = 0;
        Scanner s = new Scanner(System.in);

        for (int i=0; i < 25; i++)
        {
            System.out.println("Valor del numero " + (i+1) + ":");
            valor = s.nextInt();
            suma += (valor*1.0);
            if (mayor < valor)
            {
                mayor=valor;
            }
            if (i==0)
            {
                menor=valor;
                mayor=valor;
            } else if (menor>valor)
            {
                menor = valor;
            }

        }
        System.out.println("El numero mas grande es:" + mayor);
        System.out.println("El numero mas chico es:" + menor);
        System.out.println("El promedio es: " + (suma/25));
    }
}
