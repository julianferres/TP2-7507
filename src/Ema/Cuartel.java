public class Cuartel implements Construible{
    int vida = 250 ;
    int costo = 50 ;
    int turnosEnConstruirse=3;       

    public Unidad CrearUnidad(Unidad unidad){        
        Unidad unidadNueva = new unidad ;
        return unidadNueva ;
    }

    public void Reparar() throws Exception{
        if(siendoReparado){
            throw new Exception("El edificio ya esta siendo reparado");
        }
        if(vida == 250 ){
            throw new Exception("Salud del edificio al máximo");
            siendoReparado = false;
        }
        siendoReparado = true;
        vida += 50;
    }


}