import com.silva.app.generics.cargadores.*;
import com.silva.app.generics.celulares.CelularApple;
import com.silva.app.generics.celulares.CelularSamsung;
import com.silva.app.generics.celulares.CelularXiaomi;
import com.silva.app.generics.enums.Color;

public class C1
{
    public static void main(String[] args)
    {
        CelularApple i10 = new CelularApple();
        i10.setModelo("iPhone 10");
        i10.setMemoriaRam(4F);
        i10.setMemoriaRom(64F);
        i10.setImei("12838T374S");
        i10.setCapacidadBateria(12F);
        i10.setBotonSilencioEstado(true);
        i10.setColor(Color.DORADO);

        CelularSamsung m1 = new CelularSamsung();
        m1.setModelo("S22");
        m1.setMemoriaRam(6F);
        m1.setMemoriaRom(128F);
        m1.setImei("63512838T374S");
        m1.setCapacidadBateria(19F);
        m1.setColor(Color.AZUL);

        CelularXiaomi poco = new CelularXiaomi();
        poco.setModelo("Xiaomi POCO X1");
        poco.setMemoriaRam(6F);
        poco.setMemoriaRom(128F);
        poco.setImei("63512838T374S");
        poco.setCapacidadBateria(30F);
        poco.setColor(Color.GRIS);

        ICargador cargadorAL = new CargadorNormalApple();
        ICargador cargadorAC = new CargadorCompactoApple();

        ICargador cargadorSL = new CargadorNormalSamsung();
        ICargador cargadorSR = new CargadorRapidoSamsung();
        ICargador cargaorSI = new CargadorInduccionSamsung();

        ICargador cargadorXL = new CargadorNormalXiaomi();
        ICargador cargadorXR = new CargadorRapidoXiaomi();

        //hoy
        cargadorAL.cargar(i10);
        cargadorSL.cargar(m1);
        //cargadorXR.cargar(poco);

        //mañana
        cargadorAC.cargar(i10);
        cargaorSI.cargar(m1);
        //cargadorXR.cargar(poco);


       /* CelularApple iPhone13 = new CelularApple();
        iPhone13.setCapacidadBateria(98.9F);
        IAppleCargador cargador = new CargadorNormalApple();
        //cargador.cargar(iPhone13);

        UsuarioApple javi = new UsuarioApple("Javier", 20);

        javi.cargarCel(cargador,iPhone13);*/

    }
}
