import com.silva.app.generics.cargadores.IAppleCargador;
import com.silva.app.generics.celulares.CelularApple;

public class UsuarioApple
{
    private String nombre;
    private int edad;

    public void cargarCel(IAppleCargador cargador, CelularApple cel)
    {
        System.out.println("Soy un usuario Apple y pondre a cargar mi celular");
        cargador.cargar(cel);
    }

    public UsuarioApple(String nombre, int edad)
    {
        this.nombre=nombre;
        this.edad=edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
