public abstract class ElementoBase
{
    protected String valor;
    protected String nombre;
    protected String id;

    public abstract String pintar();

    public ElementoBase()
    {

    }

    public ElementoBase(String valor, String nombre, String id)
    {
        this.valor = valor;
        this.nombre = nombre;
        this.id = id;
    }
}
