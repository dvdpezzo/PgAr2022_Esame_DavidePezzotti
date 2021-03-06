import it.unibs.fp.mylib.NumeriCasuali;

public class Chest {
    private Oggetto contenuto;

    public Oggetto getContenuto() {
        return contenuto;
    }

    private Casella casella;

    public Chest(Casella casella) {
        this.contenuto = generaContenutoCasuale();
        this.casella = casella;
    }

    private Oggetto generaContenutoCasuale(){
        Oggetto oggetto = null;
        int scelta = probabilita();
        switch (scelta) {
            case 1 -> oggetto = new Arma("Spada", "Spada affilata!");
            case 2 -> oggetto = new Pozione("Pozione curatrice", "Recupera il 50% della tua vita massima");
            case 3 -> oggetto = new Scudo("Scudo", "Ti protegge dagli attacchi dei nemici! (Max Protezione: 5)", 5);
        }
        return oggetto;
    }

    private int probabilita(){
        double numero = NumeriCasuali.estraiDouble(0, 1);
        if(numero >= 0 && numero < 0.4) return 1;
        else if (numero >= 0.4 && numero < 0.75) {
            return  2;
        } else if (numero >= 0.75 && numero <= 1) {
            return  3;
        }
        return 0;
    }

}
