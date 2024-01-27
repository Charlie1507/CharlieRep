import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C1
{
    public static void main(String[] args)
    {
        int eleccion = 0;
        List<Integer> numeros = new ArrayList<>();
        Scanner s = new Scanner(System.in);


        do
        {

            System.out.println("Menu");
            System.out.println("1)  Visualizar elementos de la lista");
            System.out.println("2)  Agregar elemento a la lista");
            System.out.println("3)  Eliminar elemento a la lista");
            System.out.println("4)  Sumar");
            System.out.println("5)  Promedio");
            System.out.println("6)  Maximo");
            System.out.println("7)  Minimo");
            System.out.println("8)  Contar");
            System.out.println("9)  Concatenar");
            System.out.println("10) Salir");
            System.out.print("Digite la opcion deseada: ");
            eleccion=s.nextInt();

            switch (eleccion)
            {

                case 1:
                    if(numeros.size()==0)
                    {
                        System.out.println("No tienes numeros en tu lista");
                    }
                    else
                    {
                        System.out.println(numeros);
                    }

                    break;

                case 2:

                    int num;
                    System.out.print("Ingresa el numero que deseas agregar: ");
                    num=s.nextInt();
                    agreguenum(numeros,num);

                    break;

                case 3:
                    int numd;

                    if(numeros.size()==0)
                    {
                        System.out.println("No tienes numeros en tu lista para eliminar");
                    }
                    else
                    {

                        System.out.print("Ingresa el numero que deseas eliminar: ");
                        numd=s.nextInt();
                        eliminarnum(numeros,numd);
                    }

                    break;

                case 4:

                    if(numeros.size()<0)
                    {
                        System.out.println("No tienes numeros suficientes en tu lista para sumar");
                    }
                    else
                    {
                        System.out.println(suma(numeros));
                    }

                    break;

                case 5:

                    if(numeros.size()<2)
                    {
                        System.out.println("No tienes numeros suficientes en tu lista para promediar");
                    }
                    else
                    {
                        System.out.println(promedio(numeros));
                    }

                    break;

                case 6:

                    if(numeros.size()==0)
                    {
                        System.out.println("No tienes numeros suficientes en tu lista para obtener este dato");
                    }
                    else
                    {
                        System.out.println(mayor(numeros));
                    }

                    break;

                case 7:

                    if(numeros.size()==0)
                    {
                        System.out.println("No tienes numeros suficientes en tu lista para obtener este dato");
                    }
                    else
                    {
                        System.out.println(menor(numeros));
                    }

                    break;

                case 8:
                    int rep;
                    int repr;
                    if(numeros.size()==0)
                    {
                        System.out.println("No tienes numeros suficientes en tu lista para obtener este dato");
                    }
                    else
                    {
                        System.out.print("Digite el numero del que desea saber su repeticion: ");
                        rep=s.nextInt();
                        repr = repeticion(numeros,rep);

                        if(repr==0)
                        {
                            System.out.println("El numero que ingreso no se encuentra en la lista");
                        }
                        else
                        {
                            System.out.println("Ese numero se repite " + repr + " veces en la lista");
                        }
                    }

                    break;

                case 9:
                    String parar = "stop";
                    String palabra;
                    boolean validar = true;
                    List<String> letras = new ArrayList<>();
                    System.out.println("Para dejar de escribir escriba 'stop'");

                    while(validar==true)
                    {

                        System.out.print("Digite la palabra que desea concatenar: ");
                        palabra=s.next();
                        if(palabra.equals(parar))
                        {
                            validar=false;
                        }
                        else
                        {
                            letras.add(palabra);
                        }
                    }

                    System.out.println("La frase concatenada es:");
                    System.out.println(conca(letras));

                    break;

                case 10:
                    break;

                default:
                    System.out.println("Selecciona una opcion valida");
                    break;
            }

        }while (eleccion!=10);
    }

    static List<Integer> agreguenum (List<Integer> a, int b)
    {
        a.add(b);
        return a;
    }

    static List<Integer> eliminarnum (List<Integer> a, int b)
    {
        for (int i = 0; i < a.size(); i++)
        {
            if (a.get(i)==b)
            {
                a.remove(i);
            }
        }
        return a;
    }

    static int suma (List<Integer> a)
    {
        int suma = 0;
        for (int i = 0; i < a.size(); i++)
        {
            suma+=a.get(i);
        }

        return suma;
    }

    static double promedio (List<Integer> a)
    {
        int suma = 0;
        double promedio = 0;

        for (int i = 0; i < a.size(); i++)
        {
            suma+=a.get(i);
        }
        promedio = (suma/a.size())*1.0;

        return promedio;
    }

    static int mayor (List<Integer> a)
    {
        int suma = 0;

        for (int i = 0; i < a.size(); i++)
        {
            if(i==0)
            {
                suma=a.get(i);
            }
            else if (suma<a.get(i))
            {
                suma=a.get(i);
            }

        }

        return suma;
    }

    static int menor (List<Integer> a)
    {
        int suma = 0;

        for (int i = 0; i < a.size(); i++)
        {
            if(i==0)
            {
                suma=a.get(i);
            }
            else if (suma>a.get(i))
            {
                suma=a.get(i);
            }

        }

        return suma;
    }

    static int repeticion (List<Integer> a, int b)
    {
        int repeat = 0;

        for (int i = 0; i < a.size(); i++)
        {
            if (a.get(i)==b)
            {
                repeat ++;
            }
        }

        return repeat;
    }

    static String conca (List<String> a)
    {
        String frase = null;

        for (int i = 0; i < a.size(); i++)
        {
            if (i==0)
            {
                frase = a.get(i);
            }
            else
            {
                frase += (" " + a.get(i));
            }
        }
        return frase;
    }
}
