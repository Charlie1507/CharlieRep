import java.util.Scanner;

public class C2
{
    public static void main(String[] args)
    {
        double articulo = 0;
        double iva;

        Scanner s = new Scanner(System.in);

        System.out.println("Ingresa el precio de los 5 articulos:");

        for(int i = 0; i < 5; i++)
        {
            System.out.println("Precio del articulo " + (i+1));
            articulo += s.nextInt();
        }
        iva = articulo*0.16;
        System.out.println("Tu Subtotal es: $" + (articulo*1.00));
        System.out.println("Tu IVA es: $" + iva);
        System.out.println("Tu Total es: $" + ((articulo*1.00)+iva));
    }
}
