import java.util.Deque;
import java.util.LinkedList;

public class Game {
    LinkedList<Player> players = new LinkedList<>();
    Board board;
    Dice dice;

    Game(){
        initializeGame();
    }

    private void initializeGame() {
        //create a cell
        //create a board
        //add snake ladder to board
        //create a dice
        //create a player 
        Cell cell = new Cell();
        board = new Board(10,4,5); 
        dice = new Dice(1);
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        players.add(player2);
        players.add(player1);
    }

    public void startGame() {
        Player winner =null;

        while(winner==null){
            Player playerTurn = getPlayerTurn();
            System.out.println("Player "+playerTurn.id+"'s turn"+" Player's position is "+playerTurn.getPosition());
            int diceNumbers = dice.rollDice();
            System.out.println("Player "+playerTurn.id+" rolled the dice"+" and got "+diceNumbers);

            int playerNewPosition = playerTurn.position + diceNumbers;
            playerNewPosition = checkSnake(playerNewPosition);
            playerNewPosition = checkLadder(playerNewPosition);
            playerTurn.position = playerNewPosition;

        System.out.println("player turn is:" + playerTurn.id + " new Position is: " + playerNewPosition);
            if(playerNewPosition >= board.cells.length * board.cells.length-1){
                winner = playerTurn;
        }  
        }
    }

    private int checkLadder(int playerNewPosition) {
        if(playerNewPosition > board.cells.length * board.cells.length-1 ){
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.ladder!=null && cell.ladder.start!=cell.ladder.end){
            return cell.ladder.end;
        }
        return playerNewPosition;
    }

    private int checkSnake(int playerNewPosition) {
        if(playerNewPosition > board.cells.length * board.cells.length-1 ){
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.snake!=null && cell.snake.start!=cell.snake.end){
            return cell.snake.end;
        }
        return playerNewPosition;
    }

    private Player getPlayerTurn() {
        Player player = players.peek();
        players.removeFirst();
        players.addLast(player);
        return player;
    }
}
