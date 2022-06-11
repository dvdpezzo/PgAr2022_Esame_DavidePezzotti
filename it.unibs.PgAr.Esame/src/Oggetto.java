public abstract class Oggetto {
    private String nome;
    private String descrizione;

    public Oggetto(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }


    @Override
    public String toString() {
        return nome + ": " + "\n------\n" + descrizione;
    }
}
