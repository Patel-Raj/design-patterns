package lld.chess;

import java.util.List;

public class Chess {
}

/*
1. Players take turn, white starts first
2. pieces : Rook, Bishop, knight, king, queen, pawn
3. Board
4. Rows of cells
 */

interface StraightBehaviour {
    public void moveStraight(Board board, int iX, int iY, int fX, int fY);
}
interface SlantBehaviour {
    public void moveSlant(Board board, int iX, int iY, int fX, int fY);
}

class StraightMultipleMove implements StraightBehaviour {

    @Override
    public void moveStraight(Board board, int iX, int iY, int fX, int fY) {

    }
}

class SlantMove implements SlantBehaviour {

    @Override
    public void moveSlant(Board board, int iX, int iY, int fX, int fY) {

    }
}

abstract class Piece {
    public abstract void move(Board board, Cell fromCell, Cell toCell);
}

class Rook extends Piece {
    private StraightBehaviour straightBehaviour;

    @Override
    public void move(Board board, Cell fromCell, Cell toCell) {
        straightBehaviour.moveStraight(board, fromCell.getX(), fromCell.getY(), toCell.getX(), toCell.getY());
    }
}

class Knight extends Piece {

    @Override
    public void move(Board board, Cell fromCell, Cell toCell) {

    }
}

class Bishop extends Piece {
    private SlantBehaviour slantBehaviour;

    @Override
    public void move(Board board, Cell fromCell, Cell toCell) {
        slantBehaviour.moveSlant(board, fromCell.getX(), fromCell.getY(), toCell.getX(), toCell.getY());
    }
}

class Pawn extends Piece {
    private StraightBehaviour straightBehaviour;

    @Override
    public void move(Board board, Cell fromCell, Cell toCell) {

    }
}

enum PlayerType {
    WHITE, BLACK;
}

class Player {
    private PlayerType playerType;
    private List<Piece> leftPieces;

    public Player(PlayerType playerType) {
        this.playerType = playerType;
        leftPieces.add(new Rook());
        leftPieces.add(new Rook());
    }
}

class Cell {
    private Piece currentPiece;
    private Player player;
    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isFree() {
        return currentPiece == null;
    }

    public Player getPlayer() {
        return player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class Board {
    private Cell[][] board;
    private static Board game;
    private Board() {}

    public static Board getBoard() {
        if(game == null) {
            game = new Board();
        }
        return game;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public Cell[][] getCells() {
        return this.board;
    }

    public void initCells() {
        board = new Cell[8][8];
        // Do init logic
    }

    public void move(Board board, Player player, Cell formCell, Cell toCell) {
        if(!formCell.isFree())  return;
        if(toCell.getPlayer() == player)    return;

    }

    public Cell getCell(int x, int y) {
        return null;
    }
}

enum Turn {
    PLAYER1, PLAYER2;
}

class GamePlay {
    private Board board;
    private Turn turn;
    private Player player1;
    private Player player2;

    public GamePlay() {
        board = Board.getBoard();
        board.initCells();
        turn = Turn.PLAYER1;
    }

    public void play() {
        while(true) {
            board.move(board, turn == Turn.PLAYER1 ? player1 : player2, board.getCell(1,2), board.getCell(3,4));
            changeTurn();
            board.move(board, turn == Turn.PLAYER1 ? player1 : player2, board.getCell(1,2), board.getCell(3,4));
        }
    }

    private void changeTurn() {
        turn = turn == Turn.PLAYER1 ? Turn.PLAYER2 : Turn.PLAYER1;
    }
}