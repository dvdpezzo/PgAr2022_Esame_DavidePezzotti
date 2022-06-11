public class Pozione extends Oggetto{
    public double ripristinaVita(Giocatore giocatore){
        double vita = giocatore.getVita();
        vita += vita/2;
        return vita;
    }

    public Pozione(String nome, String descrizione) {
        super(nome, descrizione);
    }
}
