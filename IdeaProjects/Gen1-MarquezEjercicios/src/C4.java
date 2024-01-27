import java.util.Scanner;

public class C4
{
    public static void main(String[] args)
    {
        double altura;
        double diagonalMenor;
        double diagonalMayor;
        double arear;
        double areac;

        Scanner s = new Scanner(System.in);

        System.out.println("Cual es la altura del prisma: ");
        altura = s.nextDouble();
        System.out.println("Cual es la diagonal menor del prisma: ");
        diagonalMenor = s.nextDouble();
        System.out.println("Cual es la diagonal mayor del prisma: ");
        diagonalMayor = s.nextDouble();

        arear = ((diagonalMayor * diagonalMenor)/2);
        areac = (Math.sqrt(((diagonalMayor/2)*(diagonalMayor/2)) + ((diagonalMenor/2)*(diagonalMenor/2))))*altura;

        System.out.println("El area del prisma es: " + ((areac*4) + (arear*2)));
    }
}
