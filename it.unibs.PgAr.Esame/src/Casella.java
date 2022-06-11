public class Casella {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private boolean occupabile = true;

    public boolean isOccupabile() {
        return occupabile;
    }

    public void setOccupabile(boolean occupabile) {
        this.occupabile = occupabile;
    }

    public Casella(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
