import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;

    public Board(int size, int snakes, int ladders) {
        initializeCells(size);
        addSnakes(snakes);
        addLadders(ladders);
    }

    private void addLadders(int ladders) {
        while(ladders-->0){
           int ladderHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
           int ladderTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
           if(ladderHead>=ladderTail) continue;
           Ladder ladderObj = new Ladder();
           ladderObj.start = ladderHead;
           ladderObj.end = ladderTail;
           Cell cell = getCell(ladderHead);
           cell.ladder = ladderObj;
        }
    }

    private void addSnakes(int snakes) {
        while(snakes-->0){
           int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
           int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
           if(snakeHead<=snakeTail) continue;
           Ladder snakeObj = new Ladder();
           snakeObj.start = snakeHead;
           snakeObj.end = snakeTail;
           Cell cell = getCell(snakeHead);
           cell.  ladder = snakeObj;
        }
    }

    private void initializeCells(int size) {
        cells = new Cell[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
    }

    Cell getCell(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardColumn = (playerPosition % cells.length);
        return cells[boardRow][boardColumn];
    }



}
