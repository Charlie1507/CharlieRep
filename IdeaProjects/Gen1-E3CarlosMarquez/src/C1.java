import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C1
{
    public static void main(String[] args)
    {

        String mail;
        Scanner s = new Scanner(System.in);

        System.out.println(numerosal());

        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            numeros.add(i);
        }
        System.out.println(numerosPeI(numeros));

        System.out.print("Ingresa tu email: ");
        mail=s.next();
        System.out.println(validarCorreo(mail));

        String[] saludo = new String[5];
        saludo[0]="Hola";
        saludo[1]="Mundo";
        saludo[2]="Soy";
        saludo[3]="Carlos";
        saludo[4]="(Charlie)";
        guardartxt(saludo);

    }
    static List<Integer> numerosal ()
    {
        List<Integer> numerosaleatorios = new ArrayList<>();

        Random a = new Random();
        for (int i = 0; i < 10; i++)
        {
            int al = a.nextInt();
            numerosaleatorios.add(al);
        }

        return numerosaleatorios;
    }

    static List<List<Integer>> numerosPeI(List<Integer>a)
    {
        List<List<Integer>> listas =new ArrayList<>();
        List<Integer> par = new ArrayList<>();
        List<Integer> impar = new ArrayList<>();
        listas.add(par);
        listas.add(impar);
        int lon = a.size();
        for (int i = 0; i < lon; i++)
        {
            if (a.get(i)%2 ==0)
            {
                par.add(a.get(i));
            }
            else
            {
                impar.add(a.get(i));
            }
        }

        return listas;
    }
    static String validarCorreo(String correo)
    {
        String validacion = null;
        String regex ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern= Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        if (matcher.find())
        {
            validacion="OK";
        }
        else
        {
            validacion="ERROR";
        }

        return validacion;
    }

    static void guardartxt (String[] a)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Public\\Downloads\\cadena.txt"))) {
            for (String cadena : a) {
                writer.write(cadena);
                writer.newLine();
            }
            System.out.println("Archivo creado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}
