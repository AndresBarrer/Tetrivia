package tetris;

// aux class to wait (lags the block so as to move it downward)

import java.util.logging.Level;
import java.util.logging.Logger;


public class GameThread extends Thread{
    
    private GameArea ga;
    private GameForm gf;
    private int score;
    private int level = 1;
    private int scorePerLevel = 3;
    
    private int pause = 1000;
    private int speedupPerLevel = 100;
    
    public GameThread(GameArea ga, GameForm gf){
        this.ga = ga;
        this.gf = gf;
        
        gf.updateScore(score); //update score every time that a new Thread is created
        gf.updateLevel(level); //update level every time that a new Thread is created
    }
            
    @Override
    public void run(){
        while (true == true){
            ga.spawnBlock();
                while (ga.moveBlockDown() ){

                    try {
                        Thread.sleep(pause); //lags for 1000 ms
                    } catch (InterruptedException ex) {
                        return;
                    }
            }
            if (ga.isBlockOutOfBounds()){
                Tetris.gameOver(score);
                break;
            }
            
            ga.moveBlockToBackground();
            score += ga.clearLines();
            gf.updateScore(score);
            
            int lvl = score / scorePerLevel + 1;
            if(lvl > level){
                level = lvl;
                gf.updateLevel(level);
                pause -= speedupPerLevel;
            }

        }
        
    }
    
}
