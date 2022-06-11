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
                        * se trova una chest la apre in automatico*/
                        break;
                    case 2:
                        //utilizza oggetto
                        giocatore.apriInventario();
                        int i = InputDati.leggiIntero("Quale oggetto ti interessa utilizzare?\n(Premere 0 per annullare) ");
                        if (i > 0) {
                            Oggetto oggetto_selezionato = giocatore.selezionaOggetto(i);
                            switch(oggetto_selezionato.getNome()){
                                case "Spada":
                                    Arma arma = (Arma) oggetto_selezionato;
                                    arma.equipaggiaArma(giocatore);
                                    break;
                                case "Pozione curatrice":
                                    Pozione pozione = (Pozione) oggetto_selezionato;
                                    pozione.ripristinaVita(giocatore);
                                    break;
                                case "Scudo":
                                    Scudo scudo = (Scudo) oggetto_selezionato;
                                    scudo.proteggi(giocatore);
                                    break;
                            }
                            gestisciMappa.stampaMappa();
                        }
                        else if (i == 0){
                            gestisciMappa.stampaMappa();
                            break;
                        }
                        break;
                    case 3:
                        String[] voci_menuSecondario = {"Seleziona Inventario", "Mostra le statistiche", "Abbandona Partita"};
                        MyMenu menuSecondario = new MyMenu("Menu di Pausa", voci_menuSecondario);
                        //apri Menu di pausa
                        /*altro menu con selezione dell'inventario (e controlla effetto oggetti), mostra le statistiche, abbandona partita*/
                        int secondaScelta;
                        do {
                            secondaScelta = menuSecondario.scegli();
                            switch (secondaScelta){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                    case
                            }
                        }while(secondaScelta != 0);
                        break;
                }
            }while(scelta != 0);


        }while(giocatore.getVita() != 0);
    }
}
