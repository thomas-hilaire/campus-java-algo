package campus.valence.demineur;

public class Main {

    public static void main(String[] args) {
        Demineur demineur = Demineur.create(15, 10);
        System.out.println(demineur.boardAsString());
    }
}
