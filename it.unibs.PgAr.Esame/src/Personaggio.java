public abstract class Personaggio {

    private String nome;
    private double vita;
    private int atk_base;
    private  int def_base;
    private int potenza_base;
    private Casella casella;

    public Casella getCoordinate() {
        return casella;
    }

    public void setCoordinate(Casella casella) {
        this.casella = casella;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVita() {
        return vita;
    }

    public void setVita(double vita) {
        this.vita = vita;
    }

    public int getAtk_base() {
        return atk_base;
    }

    public void setAtk_base(int atk_base) {
        this.atk_base = atk_base;
    }

    public int getDef_base() {
        return def_base;
    }

    public void setDef_base(int def_base) {
        this.def_base = def_base;
    }

    public int getPotenza_base() {
        return potenza_base;
    }

    public void setPotenza_base(int potenza_base) {
        this.potenza_base = potenza_base;
    }

}
