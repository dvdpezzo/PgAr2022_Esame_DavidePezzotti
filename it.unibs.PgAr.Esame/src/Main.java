import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

import javax.xml.stream.XMLStreamException;

public class Main {

    public static final String MUOVITI = "Muoviti";
    public static final String UTILIZZA_OGGETTO = "Utilizza Oggetto";
    public static final String APRI_MENU_DI_PAUSA = "Apri Menu di pausa";
    public static final String COME_PROSEGUI = "Come Prosegui?";
    public static final String BENVENUTO_GIOCATORE = "Benvenuto Giocatore, attualmente ti trovi al primo piano di una torre. Qui sotto puoi vedere la mappa";
    public static final String XML = "Livelli/livello1.xml";
    public static final String DIREZIONE = "Inserire direzione in cui muoversi (W , A, S, D)";
    public static final String OGGETTO_INTERESSE = "Quale oggetto ti interessa utilizzare?\n(Premere 0 per annullare) ";
    public static final String SPADA = "Spada";
    public static final String POZIONE_CURATRICE = "Pozione curatrice";
    public static final String SCUDO = "Scudo";
    public static final String SELEZIONA_INVENTARIO = "Seleziona Inventario";
    public static final String MOSTRA_LE_STATISTICHE = "Mostra le statistiche";
    public static final String ABBANDONA_PARTITA = "Abbandona Partita";
    public static final String MENU_DI_PAUSA = "Menu di Pausa";

    public static void main(String[] args) throws XMLStreamException {
        Giocatore giocatore = new Giocatore();

        String[] voci_menuPrincipale = {MUOVITI, UTILIZZA_OGGETTO, APRI_MENU_DI_PAUSA};
        MyMenu menuPrincipale = new MyMenu(COME_PROSEGUI, voci_menuPrincipale);
        System.out.println(BENVENUTO_GIOCATORE);
        //genera mappa
        GestisciMappa gestisciMappa = new GestisciMappa();
        gestisciMappa.creaMappa(XML);
        boolean abbandonaPartita = false;
        do {
            int scelta;
            //mostra la mappa dopo ogni turno
            gestisciMappa.stampaMappa();
            gestisciMappa.setacciaPiano();
            do {
                scelta = menuPrincipale.scegli();
                switch (scelta) {
                    case 1 -> {
                        //muovi il giocatore
                        char direzione = InputDati.leggiChar(DIREZIONE);
                        giocatore.muoviPersonaggio(direzione, gestisciMappa.getMappa());
                        gestisciMappa.stampaMappa();
                    }
                    /*se incontra un mostro inizia la fase di attacco
                     * se trova una chest la apre in automatico*/
                    case 2 -> {
                        //utilizza oggetto
                        giocatore.apriInventario();
                        int i = InputDati.leggiIntero(OGGETTO_INTERESSE);
                        if (i > 0) {
                            Oggetto oggetto_selezionato = giocatore.selezionaOggetto(i);
                            switch (oggetto_selezionato.getNome()) {
                                case SPADA -> {
                                    Arma arma = (Arma) oggetto_selezionato;
                                    arma.equipaggiaArma(giocatore);
                                }
                                case POZIONE_CURATRICE -> {
                                    Pozione pozione = (Pozione) oggetto_selezionato;
                                    pozione.ripristinaVita(giocatore);
                                }
                                case SCUDO -> {
                                    Scudo scudo = (Scudo) oggetto_selezionato;
                                    scudo.proteggi(giocatore);
                                }
                            }
                            gestisciMappa.stampaMappa();
                        } else if (i == 0) {
                            gestisciMappa.stampaMappa();
                        }
                    }
                    case 3 -> {
                        String[] voci_menuSecondario = {SELEZIONA_INVENTARIO, MOSTRA_LE_STATISTICHE, ABBANDONA_PARTITA};
                        MyMenu menuSecondario = new MyMenu(MENU_DI_PAUSA, voci_menuSecondario);
                        //apri Menu di pausa
                        /*altro menu con selezione dell'inventario (e controlla effetto oggetti), mostra le statistiche, abbandona partita*/
                        int secondaScelta;
                        do {
                            secondaScelta = menuSecondario.scegli();
                            switch (secondaScelta) {
                                case 1 -> giocatore.apriInventario();
                                case 2 -> System.out.println(giocatore);
                                case 3 -> abbandonaPartita = true;
                            }
                        } while (secondaScelta != 0);
                    }
                }
            }while(scelta != 0);

        }while(giocatore.getVita() != 0 && !abbandonaPartita && vittoria(giocatore, gestisciMappa.setacciaPiano()));
    }

    private static boolean vittoria(Giocatore giocatore, Casella casellaPrincipessa) {
        if(giocatore.getCoordinate().equals(casellaPrincipessa))return true;
        else return  false;
    }


}
