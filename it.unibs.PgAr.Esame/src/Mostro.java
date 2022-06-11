import it.unibs.fp.mylib.NumeriCasuali;

public class Mostro extends Personaggio {
    private  Arma arma;

    public Mostro() {
        setNome("Mostro");
        setVita(NumeriCasuali.estraiDouble(15, 25));
        setAtk_base(5);
        setDef_base(5);
        this.arma = new Arma("Arma", "Spaventosa");

    }

    public double attacca(){
        double danno = ((2*getPotenza_base()*getAtk_base())/(25)*getDef_base())+2;
        double mod = 1;
        double i = NumeriCasuali.estraiDouble(0, 1);
        if (i>= 0 || i<0.075) mod = 1.5;
        danno = danno * mod;
        return  danno;
    }
}
