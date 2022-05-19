package campus.valence.demineur;

public class Demineur {

    public static Demineur create(int bombCount, int boardSize) {
        Case[][] board = new Case[boardSize][boardSize];
        return null;
    }

    private Case[][] board;

    protected Demineur(Case[][] board) {
        this.board = board;
    }

    String boardAsString() {
        return "";
    }

    public Case[][] getBoard() {
        return board;
    }

    public int countBombsAround(int x, int y) {
        throw new RuntimeException("To be implemented");
    }
}
