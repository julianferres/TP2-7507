package Controladores;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorMoverArriba implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;

	public ControladorMoverArriba(ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {
        Jugador jugadorActual = ControladorDeTurno.getInstance().jugadorEnTurno();
        Unidad unidadActual = UnidadActual.obtenerInstancia().unidad();
        try{
        	if(! unidadActual.esPiezaPropia(jugadorActual)){
        		new Alerta().NoEsTuPieza();
        	} else{
        		unidadActual.moverArriba();
        	}
        }
        catch(CeldaInvalidaException e){
            new Alerta().fueraDeRango();
        }
        catch(CeldaOcupadaException e){
            new Alerta().celdaOcupada();
        }
        catch(UnidadYaMovidaException e){
            new Alerta().unidadYaMovida();
        }
        this.contenedor.actualizar();
    	}
}