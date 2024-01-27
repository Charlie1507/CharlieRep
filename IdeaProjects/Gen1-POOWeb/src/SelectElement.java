import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SelectElement extends ElementoBase
{
    //atributos
    private List<OptionElement> opciones; //Error lista no estaba inicializada


    //metodos
    @Override
    public String pintar()
    {
        StringBuilder sb = new StringBuilder("<select ");
        sb.append("name='")
                .append(this.nombre)
                .append("'> ");
        for(OptionElement opcion: this.opciones)
        {
            sb.append("\n<option value=")
                    .append(opcion.getValor());

            sb.append(">")
                    .append(opcion.getValor())
                    .append("</option>");
        }
        sb.append("</select>");
        return sb.toString();
    }

    public void addOpcion(OptionElement opcion)
    {
        this.opciones.add(opcion);
    }


    //constructor
    public SelectElement(String valor, String nombre, String id)
    {
        super(valor, nombre, id);
        this.opciones = new ArrayList<>();
    }

    public List<OptionElement> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<OptionElement> opciones) {
        this.opciones = opciones;
    }
}
