import java.sql.SQLOutput;

public class Erizo extends ElementoBase
{
    private int numPatas;
    boolean olfatear;


    @Override
    public String obtenerAli()
    {
        if (olfatear==true)
        {
            return "Estoy buscando mi comida";
        }
        else
        {
            defender();
            return "Me escondo para que no me coman";
        }
    }

    public void rastrear (boolean olfatear)
    {
        if(olfatear=true)
        {
            System.out.println("Estoy rastreando comida");
        }
        else
        {
            System.out.println("No huelo nada");
        }
    }
    public void defender()
    {
        System.out.println("estoy en modo defensa");
    }
    public Erizo(String especie, String nacimiento, String alimentacion, String ecosistema, String esqueleto, double peso)
    {
        super(especie, nacimiento, alimentacion, ecosistema, esqueleto, peso);
        this.numPatas=0;
        this.olfatear=false;
    }

    public int getNumPatas() {
        return numPatas;
    }

    public void setNumPatas(int numPatas) {
        this.numPatas = numPatas;
    }

    public boolean isOlfatear() {
        return olfatear;
    }

    public void setOlfatear(boolean olfatear) {
        this.olfatear = olfatear;
    }
}
