import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class GestisciMappa {

    private char[][] mappa;

    public void mostraMappa() {
        for (int i=0; i< this.mappa.length  ; i++){
            for(int j = 0; j<this.mappa[i].length; j++){
                System.out.println(mappa[i][j]);
            }
        }
    }

    private void setMappa(int width, int height) {
        this.mappa = new char[width][height];
    }

    public void creaMappa(String filename) throws XMLStreamException {
        XMLInputFactory xmlif;
        XMLStreamReader xmlr = null;
        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }
        int width = 0;
        int height = 0;
        //rimane nel while fino a che ha eventi a disposizione
        while(xmlr.hasNext()){
            //se l'evento che trova è uno start element...
            if(xmlr.getEventType() == XMLStreamConstants.START_ELEMENT){
                String nomeTag = xmlr.getLocalName();
                int i=0;
                int j=0;
                //...ne controlla il nome e controlla a quale tag corrisponde:
                switch (nomeTag){
                    //nel caso sia uguale a mappa (solo all'inizio) crea una mappa delle dimensioni date dagli attributi
                    case "mappa":
                        if(xmlr.getAttributeCount() != 0){
                            width = Integer.parseInt(xmlr.getAttributeValue(0));
                            height = Integer.parseInt(xmlr.getAttributeValue(1));
                            setMappa(width, height);
                        }
                    break;
                    // nel caso sia uguale a row...
                    case "row":
                        //...passa al tag successivo (cell)...
                        xmlr.next();
                        do {
                            //...e inizia ad inserire i valori nella tabella alla prima riga..
                            this.mappa[i][j] = xmlr.getText().charAt(0);
                            //...aumenta la colonna...
                            j++;
                            xmlr.next();
                        }while(xmlr.getLocalName().equals("cell"));
                        //...continua a farlo fino a quando il tag è uguale a cell...
                        //...infine aumenta il valore della riga e riparte da capo
                        i++;
                        break;

                }
            }
        }
        //infine restituisce la tabella di caratteri riempita dai valori dell'xml.

      }
}
