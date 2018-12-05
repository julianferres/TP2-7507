package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorCrearAldeano implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;

	public ControladorCrearAldeano(ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {
    	System.out.println("Crea aldeano");   
    	Celda celda = PosicionActual.obtenerInstancia().celda();  
    	Edificio edificioActual = EdificioActual.obtenerInstancia().edificio();
        try{
            if(edificioActual instanceof PlazaCentral){
                PlazaCentral plaza = (PlazaCentral)EdificioActual.obtenerInstancia().edificio();
                plaza.crearAldeano(celda);          
            }
            else{
                throw new NoEsPosibleCrearException();
            }
        }    	       
        catch(NoEsPosibleCrearException e){
            new Alerta().noSePuedeCrearAhi();
        }
        catch(OroInsuficienteException e){
            new Alerta().oroInsuficiente();
        }  
        catch(PoblacionExcedidaException e){
            new Alerta().poblacionExcedida();
        }         
        
    	this.contenedor.actualizar();
	}
}