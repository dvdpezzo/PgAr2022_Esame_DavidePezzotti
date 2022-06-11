import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;

public class GestisciMappa {

    private char[][] mappa;

    public char[][] getMappa() {
        return mappa;
    }

    public void stampaMappa() {
        for (char[] chars : this.mappa) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println("");
        }
    }
    private void setDimensioniMappa(int height, int width) {
        this.mappa = new char[height][width];
    }

    public Casella setacciaPiano(){
        Casella casella = new Casella(-1,-1);
        for (int i=0; i< this.mappa.length  ; i++){
            for(int j = 0; j<this.mappa[i].length; j++){
                switch (mappa[i][j]) {
                    case 'O' -> {
                        //giocatore
                        Giocatore giocatore = new Giocatore();
                        giocatore.setCoordinate(i, j);
                    }
                    case 'K' ->
                        //Principessa
                            casella = new Casella(i, j);
                }
            }
        }
        return casella;
    }

    public void creaMappa(String filename) throws XMLStreamException {
        XMLInputFactory xmlif;
        XMLStreamReader xmlr = null;
        FileInputStream fis;
        try {
            fis = new FileInputStream(filename);
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(fis);

        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }
        int width;
        int height;
        int i=-1;
        int j=0;
        //rimane nel while fino a che ha eventi a disposizione
        while(xmlr.hasNext()){
            //se l'evento che trova è uno start element...
            if(xmlr.getEventType() == XMLStreamConstants.START_ELEMENT){
                String nomeTag = xmlr.getLocalName();
                //...ne controlla il nome e controlla a quale tag corrisponde:
                switch (nomeTag){
                    //nel caso sia uguale a mappa (solo all'inizio) crea una mappa delle dimensioni date dagli attributi
                    case "mappa":
                        if(xmlr.getAttributeCount() != 0){
                            width = Integer.parseInt(xmlr.getAttributeValue(0));
                            height = Integer.parseInt(xmlr.getAttributeValue(1));
                            setDimensioniMappa(height, width);
                        }
                        break;
                    // nel caso sia uguale a row...
                    case "row":
                        i++;
                        j=0;
                        break;
                    case "cell":
                        while (xmlr.getEventType() != XMLStreamConstants.CHARACTERS){
                            xmlr.next();
                        }
                        if (xmlr.getEventType() == XMLStreamConstants.CHARACTERS) {
                            //...e inizia a inserire i valori nella tabella alla prima riga…
                            this.mappa[i][j] = xmlr.getText().charAt(0);
                            //...aumenta la colonna...
                            j++;
                        }
                        break;

                }
            }
            xmlr.next();
        }


    }
}
