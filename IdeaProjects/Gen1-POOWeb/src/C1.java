import java.util.ArrayList;
import java.util.List;

public class C1
{
    public static void main(String[] args)
    {
        InputElement input1 = new InputElement("Javier", "nombre","nombre");
        input1.setTipo("text");

        InputElement input2 = new InputElement("12345","contraseña", "contraseña");
        input2.setTipo("email");

        TextAreaElement texto = new TextAreaElement("Soy Javier y me gusta la musica", "about", "about");
        texto.setFilas(10);
        texto.setColumnas(20);

        OptionElement opcion1 = new OptionElement("1", "Java");
        OptionElement opcion2 = new OptionElement("2", "NET");

        SelectElement select = new SelectElement("", "tecnologia","tecnologia");
        //select.setOpciones(new ArrayList<>());
        select.addOpcion(opcion1);
        select.addOpcion(opcion2);

        List<ElementoBase> elementos = new ArrayList<>();
        elementos.add(input1);
        elementos.add(input2);
        elementos.add(texto);
        elementos.add(select);

        for (int i = 0; i < elementos.size(); i++)
        {
            System.out.println(elementos.get(i).pintar());
        }
    }
}
