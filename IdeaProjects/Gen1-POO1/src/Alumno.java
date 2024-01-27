import java.util.ArrayList;
import java.util.List;

public class Alumno
{
    //atributos (variables)-> caracteristicas
    String nombre;
    String matricula;
    Integer edad;
    List<Integer> calificaciones;
    String generacion;

    //Metodos (funciones)-> acciones
    void tomarNotas(String texto)
    {
        System.out.println("soy el alumno" + nombre + "Y estoy tomando nota del texto" + texto);
    }

    void entregarTareas()
    {
        System.out.println("Estoy entrgando una tarea");
    }

    void realizarPregunta(String pregunta)
    {
        System.out.println("Mi pregunta es: " + pregunta);
    }

    String contestarPregunta()
    {
        return "mi respuesta a tu pregunta es....";
    }

    //constructor
    Alumno()
    {
        nombre = "";
        edad = 0;
        matricula = "";
        generacion = "";
        calificaciones = new ArrayList<>();
    }
}
