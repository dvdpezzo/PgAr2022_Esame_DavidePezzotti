import it.unibs.fp.mylib.NumeriCasuali;

public class Arma extends Oggetto{
    private int potenza;

    public Arma(String nome, String descrizione) {
        super(nome, descrizione);
        this.potenza = NumeriCasuali.estraiIntero(35, 55);
    }
    public void equipaggiaArma(Giocatore giocatore){
        int potenza = giocatore.getPotenza_base();
        potenza += this.potenza;
        giocatore.setPotenza_base(potenza);
    }
}
