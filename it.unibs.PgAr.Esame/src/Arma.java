public class Arma extends Oggetto{
    private int potenza;

    public Arma(String nome, String descrizione, int potenza) {
        super(nome, descrizione);
        this.potenza = potenza;
    }
}
