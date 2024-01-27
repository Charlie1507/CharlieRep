import java.util.ArrayList;
import java.util.List;

public class C6
{
    public static void main(String[] args)
    {
        List<Integer> listaEnteros = new ArrayList<>();

        listaEnteros.add(78);
        listaEnteros.add(45);
        listaEnteros.add(12);

        System.out.println(listaEnteros.get(0));
        System.out.println(listaEnteros.get(1));
        System.out.println(listaEnteros.get(2));
        //Remueve el elemento de la lista recorriendo los demas
        listaEnteros.remove(1);

        System.out.println(listaEnteros.get(0));
        System.out.println(listaEnteros.get(1));
        //agrega un elemento en la posicion pero recorriendo los demas
        listaEnteros.add(0,5);

        System.out.println(listaEnteros.get(0));
        System.out.println(listaEnteros.get(1));
        System.out.println(listaEnteros.get(2));
        //sustituye el valor en la posicion antes mencionada
        listaEnteros.set(1,15);

        System.out.println(listaEnteros.get(0));
        System.out.println(listaEnteros.get(1));
        System.out.println(listaEnteros.get(2));

        System.out.println(listaEnteros.size());

    }
}
