import java.util.ArrayList;

public class Giocatore implements Movimento{
    private String nome;
    private  double vita;
    private int atk_base;
    private  int def_base;
    private  ArrayList<Oggetto> inventario;
    private int potenza_base;

    public double getVita() {
        return vita;
    }

    public void setVita(double vita) {
        this.vita = vita;
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
