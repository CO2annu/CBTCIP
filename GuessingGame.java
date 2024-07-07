import java.util.Random;       
import javax.swing.*; 

public class GuessingGame
{
    public static void main(String[] args)
    {
        int systemNumber;
        Random rand = new Random();
        systemNumber = rand.nextInt(100) + 1;
		String userNumber = JOptionPane.showInputDialog("Enter a whole number between 1 and 100.");
		try{
			int guess = Integer.parseInt(userNumber);
			int totalGuesses;
			totalGuesses = 0;                                                          

			while (guess != systemNumber)
			{                                   
				if (guess > systemNumber)
				{
					JOptionPane.showMessageDialog(null,"Too high, try again.");
				}            
				else
				{                         
					JOptionPane.showMessageDialog(null,"Too low, try again.");
				}
				userNumber = JOptionPane.showInputDialog("Enter your next guess");
				guess = Integer.parseInt(userNumber);
				totalGuesses++;
			}       
			if(guess == systemNumber)
			{                
				totalGuesses++;
				JOptionPane.showMessageDialog(null,"Congratulations! The correct number is = " + systemNumber +"\n" + "total number of Guesses = " +totalGuesses);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Invalid input");
		}
    System.exit(0);
    }  
}