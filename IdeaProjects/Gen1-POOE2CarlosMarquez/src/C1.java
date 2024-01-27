import java.util.ArrayList;
import java.util.List;

public class C1
{
    public static void main(String[] args)
    {
        Mantaraya m1 = new Mantaraya("Pez","Viviparo", "Carnivoro", "Oceano", "Vertebrado", 1600.00 );
        m1.setBranqueas(true);
        m1.setNumAletas(2);

        Erizo er1 = new Erizo("Mamifero","Viviparo", "Omnivoro", "Bosque", "Vertebrado", 1.5);
        er1.setNumPatas(4);
        er1.setOlfatear(false);

        Erizo r2 = new Erizo("Mamifero","Viviparo", "Omnivoro", "Bosque", "Vertebrado", 0.5);
        r2.setOlfatear(true);
        r2.setNumPatas(4);

        Zorro z1 = new Zorro("Mamifero","Viviparo", "Carnivoro", "Bosque", "Vertebrado", 14.00);
        z1.setNumPatas(4);


        List<ElementoBase> elementos = new ArrayList<>();
        elementos.add(m1);
        elementos.add(er1);
        elementos.add(r2);
        elementos.add(z1);

        for (int i = 0; i < elementos.size(); i++)
        {
            System.out.println(elementos.get(i).obtenerAli());
        }

    }
}
