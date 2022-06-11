import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

import javax.xml.stream.XMLStreamException;

public class Main {
    public static void main(String[] args) throws XMLStreamException {
        Giocatore giocatore = new Giocatore();

        String[] voci_menuPrincipale = {"Muoviti", "Utilizza Oggetto", "Apri Menu di pausa"};
        MyMenu menuPrincipale = new MyMenu("Come Prosegui?", voci_menuPrincipale);
        System.out.println("Benvenuto Giocatore, attualmente ti trovi al primo piano di una torre. Qui sotto puoi vedere la mappa");
        //genera mappa
        GestisciMappa gestisciMappa = new GestisciMappa();
        gestisciMappa.creaMappa("Livelli/livello1.xml");

        do {
            int scelta;
            //mostra la mappa dopo ogni turno
            gestisciMappa.stampaMappa();
            gestisciMappa.setacciaPiano();
            do {
                scelta = menuPrincipale.scegli();
                switch (scelta){
                    case 1:
                        //muovi il giocatore
                        char direzione = InputDati.leggiChar("Inserire direzione in cui muoversi (W , A, S, D)");
                        giocatore.muoviPersonaggio(direzione, gestisciMappa.getMappa());
                        gestisciMappa.stampaMappa();
                        /*se incontra un mostro inizia la fase di attacco
                        * se trova una chest chiede se vuole aprirla*/
                        System.out.println("scelta 1");
                        break;
                    case 2:
                        //utilizza oggetto
                        /* Menu della tipologia di oggetti:
                        * - pozioni
                        * - armi
                        * - scudi
                        * il giocatore seleziona che tipo di oggetto vuole equipaggiare, se non ha nemmeno uno di quella categoria, lo rimando alla selezione*/
                        break;
                    case 3:
                        //apri Menu di pausa
                        /*altro menu con selezione dell'inventario (e controlla effetto oggetti), mostra le statistiche, abbandona partita*/
                        break;
                }
            }while(scelta != 0);


        }while(giocatore.getVita() != 0 /*|| raggiunta principessa*/);
    }
}
