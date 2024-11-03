package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Board functionality.
 */
public class BoardTest {

    /**
     * Tests if the board is valid with a single square.
     */
    @Test
    void testBoardWithValidSquare() {
        Square basicSquare = new BasicSquare();
        Square[][] basicGrid = new Square[1][1];
        basicGrid[0][0] = basicSquare;
        Board board = new Board(basicGrid);

        // Assert that the board's invariant is true
        assertThat(board.invariant()).isTrue();
    }

    /**
     * Tests if squareAt(0, 0) returns the correct square from the grid.
     */
    @Test
    void testBoardWithOneNullSquare() {
        Square basicSquare = new BasicSquare();
        Square[][] basicGrid = new Square[1][1];
        basicGrid[0][0] = basicSquare;
        Board board = new Board(basicGrid);

        // Assert that squareAt(0, 0) returns the correct square from grid
        assertThat(board.squareAt(0, 0))
            .isEqualTo(basicGrid[0][0]);
    }

    /**
     * Tests that the invariant method returns true for a grid with all valid squares.
     */
    @Test
    void testInvariantWithValidGrid() {
        // Create a grid with all valid squares
        Square[][] grid = {
            { new BasicSquare(), new BasicSquare() },
            { new BasicSquare(), new BasicSquare() }
        };
        Board board = new Board(grid);

        // Assert that the invariant returns true for a valid grid with no null squares
        assertThat(board.invariant()).isTrue();
    }

    /**
     * Tests that the invariant method handles an empty grid correctly.
     */
    @Test
    void testInvariantWithEmptyGrid() {
        // Create an empty grid (boundary case)
        Square[][] grid = new Square[0][0];
        Board board = new Board(grid);

        // Assert that the invariant returns true for an empty grid,
        // depending on the logic of the invariant method
        assertThat(board.invariant())
            .isTrue();  // Depending on the logic of invariant method
    }
}
