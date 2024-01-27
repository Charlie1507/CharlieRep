import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.*;

public class C1
{
    void consumidor (String cadena)
    {
        //consumer como funcion
        System.out.println(cadena.toUpperCase());
    }

    void consumidor3 (String nombre, int anio)
    {
        //Biconsumer como funcion
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Integer edad = Integer.parseInt((sdf.format(new Date()))) -anio;
        System.out.println(nombre + "tiene " + edad + " años!");
    }

    String crearSaludo  ()
    {
        return "Hola Javier como estas?,que tal tu dia?";
    }


    public static void main(String[] args)
    {
        List<String> listaAlum = new ArrayList<>();
        listaAlum.add("Javier");
        listaAlum.add("Mony");
        listaAlum.add("Fer");
        listaAlum.add("Juan");



        //Definicion de una expresion lambda de tipo : CONSUMER
        //EL CONSUMER no regresa ningun valor de retorno y solo recive un argumento
        Consumer<String> consumidor = (cadena) ->
        {
            System.out.println(cadena.toUpperCase());
        };
        //consumidor.accept("Javier");
        //Ejemplo consumer aplicado

        listaAlum.forEach(consumidor);

        //Definicion de una expresion lambda de tipo: BICONSUMER
        //EL BICONSUMER no regresa ningun valor de retorno
        BiConsumer<String, Integer> consumidor3 = (nombre,anio) ->
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Integer edad = Integer.parseInt((sdf.format(new Date()))) -anio;
            System.out.println(nombre + "tiene " + edad + " años!");
        };
        consumidor3.accept("Javier", 1964);


        //Definicion de una expresion lambda de tipo: Supplier
        //El SUPPLIER es capaz de  retornar un valor de retorno
        Supplier<String> crearSaludo = () ->
        {
            return "Hola Javier como estas?,que tal tu dia?";
        };
        System.out.println(crearSaludo.get());


        //Definicion de una expresion lambda de tipo: Function
        //Function es capaz de retornar un valor y aceptar parametros
        Function<String,Integer> cuentaCaracteres = (nombre) ->
        {
          return nombre.length();
        };
        System.out.println(cuentaCaracteres.apply("Hola"));


        //Definicion de una expresion lambda de tipo: BiFunction
        BiFunction<String,Integer,String> saludar3 = (nombre,anio) ->
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Integer edad = Integer.parseInt((sdf.format(new Date()))) - anio;
            return nombre + " tiene " + edad + " años ";
        };
        System.out.println(saludar3.apply("Javier Torres Timal", 1964));

        //Definicion de una expresion lambda de tipo: Predicate
        //Predicate recibe un argumento y retorna un boolean
        Predicate<Integer> pureba = (numero) ->
        {
            return numero==0;
        };
        System.out.println(pureba.test(0));

        Predicate<String> logicaBorrado = (nombreAlum) ->
        {
            char primeraL = nombreAlum.charAt(0);
            return (primeraL=='M' || primeraL=='m');
        };
        System.out.println(listaAlum);
        listaAlum.removeIf(logicaBorrado);
        System.out.println(listaAlum);

    }
}
