public class Instructor
{
    String nombre;
    String numTrabajador;
    Float salario;
    Integer edad;
    String tecnologia;

    void explicar(String tema)
    {
        System.out.println("Soy un instructor y estoy explicando el tema de " + tema);
    }

    void asignarTrabajo(Alumno a)
    {
        System.out.println("Asigne un trabajo al alumno " + a.nombre);
    }

    void calificar(Alumno a)
    {
        System.out.println("Estoy calificando los trabajos del alumno " + a.nombre);
    }

    Instructor()
    {
        nombre = "";
        numTrabajador = "";
        salario = 0F;
        edad = 0;
        tecnologia = "";
    }
}
