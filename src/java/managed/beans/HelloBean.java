package managed.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.HelloService;

/**
 *
 * @author ndaley
 */
@Named("helloBean")
@SessionScoped
public class HelloBean implements Serializable{
    private HelloService helloService = new HelloService();
    private int randomNum;
    private int userGuess;
    private String winMessage = "";
    private boolean startGameButton = true;
    private boolean inputBox = false;
    private boolean inputButton = false;
    private boolean winMessageV = false;
    private boolean quitButton = false;
    private int maxGuess = 0;
    private int lastMaxGuess;
    private String maxGuesses = "Max Guesses: n/a";
    private String maxGuessesColor = "Red";
    private int minGuess = 0;
    private int lastMinGuess = 10000;
    private String minGuesses = "Min Guesses: n/a";
    private String minGuessesColor = "Blue";

    public int getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(int randomNum) {
        this.randomNum = randomNum;
    }

    public int getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(int userGuess) {
        this.userGuess = userGuess;
    }

    public String getWinMessage() {
        return winMessage;
    }

    public void setWinMessage(String winMessage) {
        this.winMessage = winMessage;
    }

    public boolean isStartGameButton() {
        return startGameButton;
    }

    public void setStartGameButton(boolean startGameButton) {
        this.startGameButton = startGameButton;
    }

    public boolean isInputBox() {
        return inputBox;
    }

    public void setInputBox(boolean inputBox) {
        this.inputBox = inputBox;
    }

    public boolean isInputButton() {
        return inputButton;
    }

    public void setInputButton(boolean inputButton) {
        this.inputButton = inputButton;
    }

    public boolean isWinMessageV() {
        return winMessageV;
    }

    public void setWinMessageV(boolean winMessageV) {
        this.winMessageV = winMessageV;
    }

    public boolean isQuitButton() {
        return quitButton;
    }

    public void setQuitButton(boolean quitButton) {
        this.quitButton = quitButton;
    }

    public int getMaxGuess() {
        return maxGuess;
    }

    public void setMaxGuess(int maxGuess) {
        this.maxGuess = maxGuess;
    }

    public String getMaxGuesses() {
        return maxGuesses;
    }

    public void setMaxGuesses(String maxGuesses) {
        this.maxGuesses = maxGuesses;
    }

    public int getMinGuess() {
        return minGuess;
    }

    public void setMinGuess(int minGuess) {
        this.minGuess = minGuess;
    }

    public String getMinGuesses() {
        return minGuesses;
    }

    public void setMinGuesses(String minGuesses) {
        this.minGuesses = minGuesses;
    }

    public int getLastMaxGuess() {
        return lastMaxGuess;
    }

    public void setLastMaxGuess(int lastMaxGuess) {
        this.lastMaxGuess = lastMaxGuess;
    }

    public int getLastMinGuess() {
        return lastMinGuess;
    }

    public void setLastMinGuess(int lastMinGuess) {
        this.lastMinGuess = lastMinGuess;
    }

    public String getMaxGuessesColor() {
        return maxGuessesColor;
    }

    public void setMaxGuessesColor(String maxGuessesColor) {
        this.maxGuessesColor = maxGuessesColor;
    }

    public String getMinGuessesColor() {
        return minGuessesColor;
    }

    public void setMinGuessesColor(String minGuessesColor) {
        this.minGuessesColor = minGuessesColor;
    }
    
    public String checkGuess(){
        maxGuess++;
        minGuess++;
        
        if(maxGuess > lastMaxGuess){
            lastMaxGuess = maxGuess;
            maxGuesses = "Max Guesses: " + maxGuess;
        }
        
        if(userGuess < randomNum){
            winMessage = "Too Low!";
            winMessageV = true;
        }else if(userGuess > randomNum){
            winMessage = "Too High!";
            winMessageV = true;
        }else{
            winMessage = "You Win!";
            winMessageV = true;
            if(minGuess < lastMinGuess){
                lastMinGuess = minGuess;
                minGuesses = "Min Guesses: " + minGuess;
            }
        }
        
        return null;
    }
    
    public String startGame(){
        randomNum = helloService.generateRandomInt();
        
        startGameButton = false;
        
        inputBox = true;
        inputButton = true;
        
        quitButton = true;
        
        maxGuess = 0;
        minGuess = 0;
        
        return null;
    }
    
    public String quit(){
        startGameButton = true;
        
        inputBox = false;
        inputButton = false;
        
        winMessageV = false;
        
        quitButton = false;
        
        return null;
    }
}
