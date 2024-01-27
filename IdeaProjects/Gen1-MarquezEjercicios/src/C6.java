import java.util.Scanner;

public class C6
{
    public static void main(String[] args)
    {
        int voltaje1;
        int voltaje2;
        int voltaje3;
        double promedio;

        Scanner s = new Scanner(System.in);

        System.out.println("Cual es el primer voltaje: ");
        voltaje1 = s.nextInt();
        System.out.println("Cual es el segundo voltaje: ");
        voltaje2 = s.nextInt();
        System.out.println("Cual es el tercer voltaje: ");
        voltaje3 = s.nextInt();
        promedio = (voltaje1+voltaje2+voltaje3)/3;

        if (promedio <= 115)
        {
            System.out.println("VOLTAJE VALIDO");
        } else if (promedio > 115 && promedio <= 220)
        {
            System.out.println("ALTO VOLTAJE");
        }else
        {
            System.out.println("PEIGRO");
        }
    }
}
