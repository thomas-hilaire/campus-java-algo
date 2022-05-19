package campus.valence.demineur;

public class Case {

    static class BombCase extends Case {

        public BombCase(int x, int y) {
            super(x, y);
        }
    }
    static class ClearCase extends Case {

        public ClearCase(int x, int y) {
            super(x, y);
        }
    }

    private int x;
    private int y;

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
