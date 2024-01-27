import java.util.Scanner;

public class C3
{
    public static void main(String[] args)
    {
        double peso;
        double altura;
        double imc;

        Scanner s = new Scanner(System.in);

        System.out.println("Ingresa tu peso en kg:");
        peso = s.nextDouble();

        System.out.println("Ingresa tu altura en mts:");
        altura = s.nextDouble();

        imc = peso / (altura * altura);
        System.out.println("Tu imc es de:" + imc + " puntos");

        if(imc < 18.5)
        {
            System.out.println("Estas bajo de peso");
        } else if (imc >= 18.5 && imc <= 24.9)
        {
            System.out.println("Estas en tu peso normal");
        } else if (imc >= 25.0 && imc <= 29.9)
        {
            System.out.println("Tienes sobrepeso");
        }else
        {
            System.out.println("Tienes obesidad");
        }
    }
}
