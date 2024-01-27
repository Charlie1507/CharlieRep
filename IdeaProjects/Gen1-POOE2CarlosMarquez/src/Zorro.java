public class Zorro extends ElementoBase

{
    private int numPatas;


    @Override
    public String obtenerAli()
    {
        cazar(true);

        return "Estoy cazando mi comida";
    }

    public boolean cazar(boolean hambre)
    {
        boolean cazar;

        if (hambre==true)
        {
            cazar=true;
            System.out.println("Estoy cazando");
        }
        else
        {
            cazar=false;
            System.out.println("No estoy cazando");
        }
        return cazar;
    }

    public Zorro(String especie, String nacimiento, String alimentacion, String ecosistema, String esqueleto, double peso)
    {
        super(especie, nacimiento, alimentacion, ecosistema, esqueleto, peso);
        this.numPatas=0;
    }

    public int getNumPatas() {
        return numPatas;
    }

    public void setNumPatas(int numPatas) {
        this.numPatas = numPatas;
    }
}
