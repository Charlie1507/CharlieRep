 public abstract class ElementoBase
{
    protected String especie;
    protected String nacimiento;
    protected String alimentacion;
    protected String ecosistema;
    protected String esqueleto;
    protected double peso;

    public abstract String obtenerAli();

    public ElementoBase(String especie, String nacimiento, String alimentacion, String ecosistema, String esqueleto, double peso)
    {
        this.especie = especie;
        this.nacimiento = nacimiento;
        this.alimentacion = alimentacion;
        this.ecosistema = ecosistema;
        this.esqueleto = esqueleto;
        this.peso = peso;
    }

}
