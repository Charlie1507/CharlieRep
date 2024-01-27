import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Prueba
{
    public static void main(String[] args)
    {
        /*
        String fechaString = "1999-07-07";


        LocalDate fecha = LocalDate.parse(fechaString);

        System.out.println(fecha);


        String fechaFormateada = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println(fechaFormateada);

        // Mostrar la fecha formateada
        System.out.println("Fecha formateada: " + fechaFormateada);

         */


        /*

        Calendar l = new GregorianCalendar();
        Integer[] annios = new Integer[22];
        String [] anniosS = new String[22];
        int c =0;
        for (int i = -20; i < 2; i++)
        {
            annios[c]= (l.get(Calendar.YEAR))+i;
            c++;
        }
        c=0;
        System.out.println("-----------------");
        for(Integer n : annios)
        {
            anniosS[c]= String.valueOf(n);
            c++;
        }
        for(String n : anniosS)
        {
            System.out.println(n);
        }*/
        Color[] colores= Color.values();
        for(Color n : colores) {
            System.out.println(n);
        }



    }
}
