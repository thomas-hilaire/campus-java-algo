package campus.valence.demineur;

import campus.valence.demineur.cases.BombCase;
import campus.valence.demineur.cases.Case;
import campus.valence.demineur.cases.ClearCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DemineurTest {

    @Test
    public void shouldHaveNoBombWhenGeneratedWithZero() {
        // Given
        int bombCount = 0;
        int boardSize = 10;

        // When
        Demineur demineur = Demineur.create(bombCount, boardSize);

        // Then
        int count = countBombCases(demineur);
        assertEquals(0, count);
    }

    @Test
    public void shouldHaveFewBombWhenGenerated() {
        // Given
        int bombCount = 12;
        int boardSize = 10;

        // When
        Demineur demineur = Demineur.create(bombCount, boardSize);

        // Then
        int count = countBombCases(demineur);
        assertEquals(12, count);
    }

    @Test
    public void shouldHaveAllBombsWhenFull() {
        // Given
        int bombCount = 100;
        int boardSize = 10;

        // When
        Demineur demineur = Demineur.create(bombCount, boardSize);

        // Then
        int count = countBombCases(demineur);
        assertEquals(100, count);
    }

    @Test
    public void shouldCountAllBombsAroundWhenNone() {
        // Given
        Demineur demineur = new Demineur(new Case[][]{
            new Case[]{new ClearCase(0, 0), new ClearCase(1, 0), new ClearCase(2, 0),},
            new Case[]{new ClearCase(0, 1), new ClearCase(1, 1), new ClearCase(2, 1),},
            new Case[]{new ClearCase(0, 2), new ClearCase(1, 2), new ClearCase(2, 2),}
        });

        // When
        int count = demineur.countBombsAround(1, 1);

        // Then
        assertEquals(0, count);
    }

    @Test
    public void shouldCountAllBombsAroundWhenSome() {
        // Given
        Demineur demineur = new Demineur(new Case[][]{
            new Case[]{new ClearCase(0, 0), new ClearCase(1, 0), new ClearCase(2, 0),},
            new Case[]{new BombCase(0, 1), new ClearCase(1, 1), new ClearCase(2, 1),},
            new Case[]{new ClearCase(0, 2), new ClearCase(1, 2), new BombCase(2, 2),}
        });

        // When
        int count = demineur.countBombsAround(1, 1);

        // Then
        assertEquals(2, count);
    }

    @Test
    public void shouldDisplayTheBoardWithBombsAndCount() {
        // Given
        Demineur demineur = new Demineur(new Case[][]{
                new Case[]{new ClearCase(0, 0), new ClearCase(1, 0), new ClearCase(2, 0),},
                new Case[]{new BombCase(0, 1), new ClearCase(1, 1), new ClearCase(2, 1),},
                new Case[]{new ClearCase(0, 2), new ClearCase(1, 2), new BombCase(2, 2),}
        });

        // When
        String boardAsString = demineur.boardAsString();

        // Then
        assertEquals(boardAsString,
        "|110|\n" +
            "|X21|\n" +
            "|12X|"
        );
    }

    private int countBombCases(Demineur demineur) {
        int count= 0;
        for (Case[] row: demineur.getBoard()) {
            for (Case oneCase: row) {
                if (oneCase instanceof BombCase) {
                    count++;
                }
            }
        }
        return count;
    }

}