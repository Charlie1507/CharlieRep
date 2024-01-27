import com.silva.app.proyecto1.enums.DiaSemana;
import com.silva.app.proyecto1.enums.Mes;
import com.silva.app.proyecto1.habitaciones.HabitacionDoble;
import com.silva.app.proyecto1.habitaciones.HabitacionSencilla;
import com.silva.app.proyecto1.habitaciones.HabitacionSuite;
import com.silva.app.proyecto1.reservaciones.*;

public class C1
{
    public static void main(String[] args)
    {
        HabitacionDoble h1 = new HabitacionDoble();
        h1.setDiareserva(15);
        h1.setMesReserva(Mes.FEBRERO);
        h1.setNumeroCamas(2);
        h1.setNumhab(4);
        h1.setDiaSemana(DiaSemana.LUNES);

        HabitacionSencilla h2 = new HabitacionSencilla();
        h2.setDiareserva(28);
        h2.setMesReserva(Mes.MAYO);
        h2.setNumeroCamas(1);
        h2.setNumhab(2);
        h2.setDiaSemana(DiaSemana.MIERCOLES);

        HabitacionSuite h3 = new HabitacionSuite();
        h3.setDiareserva(10);
        h3.setMesReserva(Mes.ENERO);
        h3.setNumeroCamas(2);
        h3.setNumhab(3);
        h3.setDiaSemana(DiaSemana.DOMINGO);

        IReservacion rds = new ReservacionDigitalSencilla();
        IReservacion rdst = new ReservacionDigitalSuite();
        IReservacion rfd = new ReservacionFisicoDoble();
        IReservacion rfs = new ReservacionFisicoSencilla();
        IReservacion rfst = new ReservacionFisicoSuite();
        IReservacion rtd = new ReservacionTelefonoDoble();
        IReservacion rts = new ReservacionTelefonoSencilla();

        rds.reservarHabitacion(h2);
        rdst.reservarHabitacion(h3);
        rfd.reservarHabitacion(h1);
        rfs.reservarHabitacion(h2);
        rfst.reservarHabitacion(h3);
        rtd.reservarHabitacion(h1);
        rts.reservarHabitacion(h2);
    }
}
