import com.silva.app.generics.enums.DiaSemana;
import com.silva.app.generics.enums.Evento;
import com.silva.app.generics.habitaciones.*;
import com.silva.app.generics.hoteles.HotelEmporio;
import com.silva.app.generics.hoteles.HotelGrandOasis;
import com.silva.app.generics.hoteles.HotelPyramid;

public class C1
{
    public static void main(String[] args)
    {
        HotelPyramid can = new HotelPyramid();
        can.setDiaReserva(DiaSemana.LUNES);
        can.setAlberca(true);
        can.setDireccion("Blvd. Kukulcan 5-Km 16, Zona Hotelera, 77500 Cancún, Q.R.");
        can.setEvento(Evento.BODAS);
        can.setKidClub(true);
        can.setSalon(false);
        can.setNumeroHabitaciones(12562);

        HotelEmporio ver = new HotelEmporio();
        ver.setDiaReserva(DiaSemana.JUEVES);
        ver.setAlberca(true);
        ver.setDireccion("Paseo Insurgentes Veracruzanos del Malecón 244, Centro, 91709 Veracruz");
        ver.setEvento(Evento.DESPEDIDAS);
        ver.setKidClub(true);
        ver.setSalon(true);
        ver.setNumeroHabitaciones(47695);

        HotelGrandOasis can1 = new HotelGrandOasis();
        can1.setDiaReserva(DiaSemana.LUNES);
        can1.setAlberca(false);
        can1.setDireccion("Blvd. Kukulcan Km 16.5-Lt45-47, Zona Hotelera, 77500 Cancún, Q.R");
        can1.setEvento(Evento.COMRPOMISOS);
        can1.setKidClub(false);
        can1.setSalon(false);
        can1.setNumeroHabitaciones(35487);

        IHabitacion hBSlP = new HabitacionSuitePyramid();
        IHabitacion hBDGO = new HabitacionDobleGO();
        IHabitacion hBSlE = new HabitacionSimpleEmporio();
        IHabitacion hBSE = new HabitacionSuiteEmporio();

        hBSE.reservar(ver);
        hBDGO.reservar(can1);
        hBSlE.reservar(ver);
        hBSlP.reservar(can);
    }
}
