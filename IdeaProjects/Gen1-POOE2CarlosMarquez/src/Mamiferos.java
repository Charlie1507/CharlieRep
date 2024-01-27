public class Mamiferos extends ElementoBase
{
    int patas;
    boolean cola;

    @Override
    public String obtenerAli()
    {
        return null;
    }
    public Mamiferos(String especie, String nacimiento, String alimentacion, String ecosistema, String esqueleto, double peso)
    {
        super(especie, nacimiento, alimentacion, ecosistema, esqueleto, peso);
        patas=0;
        cola=false;
    }

}
