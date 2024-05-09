
public class Dice {
    int numberOfDice;
    int min = 1;
    int max = 6;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int rollDice(){
        int result=0;
        int dicerolls=this.numberOfDice;
        while(dicerolls-->0){
            result = result+ (int)(Math.random()*(max-min));
        }
        return result;
    }

}
