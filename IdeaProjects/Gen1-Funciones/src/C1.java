public class C1
{
    public static void main(String[] args)
    {

        System.out.println(suma(5,2));
        System.out.println(resta(5,2));
        System.out.println(multiplicacion(5,2));
        System.out.println(division(5,2));

    }

    static int suma (int a, int b)
    {
        return a+b;
    }
     static int resta (int a, int b)
    {
        return a-b;
    }
    static int multiplicacion (int a, int b)
    {
        return a*b;
    }
    static double division (double a, double b)
    {
        return a/b*1.0;
    }
}
