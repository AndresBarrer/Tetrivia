
package tetris;

import javax.swing.JOptionPane;

public class Tetris {
    
    //Instanciate all 3 form classes and store references to objects
    //in static variables, but not make them public
    //we will make public static methods to access the forms
    
    private static GameForm gf;
    //private static StartupForm sf;
    private static MainForm mf;
    private static LeaderboardForm lf;
    
    public static void start(){
        gf.setVisible(true);
        gf.startGame();
    }
    
    public static void showLeaderboard()
    {
        lf.setVisible(true);
    }
    
    //method to take user back to statup form when MainMenu button is
    //clicked on either GameForm or LeaderboardForm 
    public static void showStartup()
    {
        mf.setVisible(true);
    }
    
    //if game is over, ask the user for their name
    //to be able to display it in the leaderboard
    public static void gameOver(int score)
    {
        String playerName = JOptionPane.showInputDialog("Game Over!\nPor favor introducir nombre.");
        lf.setVisible(false);
        lf.addPlayer(playerName, score);
        
    }
    
    public static void main(String[] args)
    {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gf = new GameForm();
                mf = new MainForm();
                lf = new LeaderboardForm();

                mf.setVisible(true);
                
            }
        });
        
    }
    
}
