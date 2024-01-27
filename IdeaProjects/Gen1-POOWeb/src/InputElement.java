public class InputElement extends ElementoBase
{
    //Aunque sea una clase que recibe herencia no deja de ser una clase
    //atributos
    private String tipo;


    //metodos
    @Override
    public String pintar()
    {
        return "<input type" + this.tipo + " name=" + nombre
                + " value=" + valor + ">";
    }

    //constructores
    public InputElement(String valor, String nombre, String id)
    {
        super(valor, nombre, id);

        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
