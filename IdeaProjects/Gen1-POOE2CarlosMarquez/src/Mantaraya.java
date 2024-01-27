public class Mantaraya extends ElementoBase
{
    private int numAletas;
    private boolean branqueas;




    @Override
    public String obtenerAli()
    {
        nadar();
        return "Estoy absorviendo mi comida";
    }

    public void nadar()
    {
        System.out.println("Estoy nadando");
    }

    public Mantaraya(String especie, String nacimiento, String alimentacion, String ecosistema, String esqueleto, double peso)
    {
        super(especie, nacimiento, alimentacion, ecosistema, esqueleto, peso);
        this.branqueas=false;
        this.numAletas=0;

    }


    public int getNumAletas() {
        return numAletas;
    }

    public void setNumAletas(int numAletas) {
        this.numAletas = numAletas;
    }

    public boolean isBranqueas() {
        return branqueas;
    }

    public void setBranqueas(boolean branqueas) {
        this.branqueas = branqueas;
    }

}
