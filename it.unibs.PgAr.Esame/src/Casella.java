public class Casella {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private boolean occupabile = true;


    public Casella(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
