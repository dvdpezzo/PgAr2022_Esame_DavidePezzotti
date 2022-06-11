public class Scudo extends Oggetto{

    private int protezione;

    public Scudo(String nome, String descrizione, int protezione) {
        super(nome, descrizione);
        this.protezione = protezione;
    }
    public void proteggi(Giocatore giocatore){
        int difesa = giocatore.getDef_base();
        giocatore.setDef_base(difesa + protezione);
    }
}
