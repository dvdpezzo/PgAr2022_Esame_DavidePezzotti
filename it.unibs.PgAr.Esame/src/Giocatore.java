import java.util.ArrayList;

public class Giocatore extends Personaggio implements Movimento {

    public static final String RAGGIUNTO_LIMITE_MAPPA = "Raggiunto limite mappa";
    public static final String AGGIUNTO_ALL_INVENTARIO = "Oggetto aggiunto all'inventario!";
    public static final String NON_PUOI_PASSARE_DI_QUA = "muro, non puoi passare di qua!";
    private  ArrayList<Oggetto> inventario;

    public Giocatore() {
        setNome("Giocatore");
        setVita(20);
        setAtk_base(5);
        setDef_base(5);
        setPotenza_base(1);
    }

    public double getVita() {
        return super.getVita();
    }

    public void setVita(double vita) {
        super.setVita(vita);
    }

    @Override
    public void muoviPersonaggio(char direzione, char[][] mappa) {
        Casella casellaAttuale = getCoordinate();
        int x = casellaAttuale.getX();
        int y = casellaAttuale.getY();
        switch (direzione) {
            case 'w' -> {
                x = x - 1;
                if (x > 0 && !(casellaInCuiMiTrovo(mappa))) {
                    setCoordinate((x), y);
                    mappa[x][y] = 'O';
                    mappa[x + 1][y] = '.';
                } else System.out.println(RAGGIUNTO_LIMITE_MAPPA);
                casellaInCuiMiTrovo(mappa);
            }
            case 'a' -> {
                y = y - 1;
                if (y > 0) {
                    setCoordinate(x, y);
                    mappa[x][y] = 'O';
                    mappa[x][y + 1] = '.';
                } else System.out.println(RAGGIUNTO_LIMITE_MAPPA);
                casellaInCuiMiTrovo(mappa);
            }
            case 's' -> {
                x = x + 1;
                if (x < mappa.length) {
                    setCoordinate(x, y);
                    mappa[x][y] = 'O';
                    mappa[x - 1][y] = '.';
                } else System.out.println(RAGGIUNTO_LIMITE_MAPPA);
                casellaInCuiMiTrovo(mappa);
            }
            case 'd' -> {
                y = y + 1;
                if (y < mappa[x].length) {
                    setCoordinate(x, y);
                    mappa[x][y] = 'O';
                    mappa[x][y - 1] = '.';
                } else System.out.println(RAGGIUNTO_LIMITE_MAPPA);
                casellaInCuiMiTrovo(mappa);
            }
        }
    }

    private boolean casellaInCuiMiTrovo(char[][] mappa){
        Casella casellaAttuale = getCoordinate();
        int x = casellaAttuale.getX();
        int y = casellaAttuale.getY();
        if (mappa[x][y] == 'M'){
            Mostro mostro = new Mostro();
            do{
                mostro.setVita(mostro.getVita() - attacca(mostro));
                setVita(getVita() - mostro.attacca());
            }while(mostro.getVita() > 0 && getVita() > 0);
        } else if (mappa[x][y]== 'C') {
            Casella casellaChest = new Casella(x, y);
            Chest cassa = new Chest(casellaChest);
            inventario.add(apriChest(cassa));
            System.out.println(AGGIUNTO_ALL_INVENTARIO);
        }else if (mappa[x][y]== 'K') {
            System.out.println("Gioco terminato!");
        }/*else if (mappa[x][y]== 'T') {

        }else if (mappa[x][y]== 't') {

        }else if (mappa[x][y]== 'B') {

        }*/else if (mappa[x][y]== '#') {
            System.out.println(NON_PUOI_PASSARE_DI_QUA);
            return false;
        }
        return true;
    }

    public double attacca(Mostro mostro){
        return getAtk_base();
    }

    private Oggetto apriChest(Chest cassa){
        return cassa.getContenuto();
    }

    public void apriInventario(){
        for(int i = 0; i <inventario.size(); i++){
            System.out.println( (i+1) + ". " + inventario.get(i).toString());
        }
    }


    public Oggetto selezionaOggetto(int i){
        return inventario.get(i);
    }

    @Override
    public String toString() {
        return "Giocatore:" + "\n- vita attuale: " + getVita() + "\n- attacco base attuale: " + getAtk_base() +"\n- potenza aggiuntiva attuale: " + getPotenza_base() + "\n- difesa attuale: " + getDef_base() + "\n- posizione attuale: " + getCoordinate();
    }
}
