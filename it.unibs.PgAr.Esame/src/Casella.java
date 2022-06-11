public class Casella {
    private int x;
    private int y;
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
