import java.util.ArrayList;

public class Giocatore extends Personaggio implements Movimento {

    private  ArrayList<Oggetto> inventario;


    public double getVita() {
        return getVita();
    }

    public void setVita(double vita) {
        setVita(vita);
    }

    @Override
    public void muoviPersonaggio(char direzione) {

    }

    public double attacca(Mostro mostro){

        return 0.0;
    }

    public void apriChest(Chest cassa){

    }

    public double beviPozione(Pozione pozione){
        return 0.0;
    }

    public Oggetto selezionaOggetto(Oggetto oggetto){

        return  oggetto;
    }

    private  int impugnaArma(Arma arma){
        return 0;
    }
}
