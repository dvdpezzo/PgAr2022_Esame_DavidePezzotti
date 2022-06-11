import it.unibs.fp.mylib.MyMenu;

public class Main {
    public static void main(String[] args) {
        Giocatore giocatore = new Giocatore();
        String[] voci_menuPrincipale = {"Muoviti", "Utilizza Oggetto", "Apri Menu di pausa"};
        MyMenu menuPrincipale = new MyMenu("Come Prosegui?", voci_menuPrincipale);

        //genera mappa

        do {
            int scelta;
            do {
                scelta = menuPrincipale.scegli();
                switch (scelta){
                    case 1:
                        //muovi il giocatore
                        /*se incontra un mostro inizia la fase di attacco
                        * se trova una chest chiede se vuole aprirla*/
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
