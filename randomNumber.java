/* randomnumber.java
 * 9/30/2019
 * Description: Random number guessing game
 */


import javax.swing.JOptionPane;
import java.util.Random;

public class randomNumber {
    public static void main(String[] args) {

        // Declare variables
        String menuInput;
        String numberInput;
        int menuChoice = 0;
        int numberChoice = 0;
        int accumulator = 0;
        Random rand = new Random(); // random number generator

        // Display intro using a dialog box
        JOptionPane.showMessageDialog(null, "RANDOM NUMBER GUESSING GAME!\n");

        do {
            // Display main menu and prompt user for the main menu choice
            menuInput = JOptionPane.showInputDialog("Please select an option:\n\n" +
                    "1) See Rules\n\n2) Play Game\n\n3) Exit\n\n");

            // Input validation & exception handling (for string entry instead of a number)
            try {
                menuChoice = Integer.parseInt(menuInput);
            } catch (Exception e) {}

            // decision structure for menu
            if (menuChoice == 1)

                // Display the rules of the game
                JOptionPane.showMessageDialog(null, "Rules of the Game:\n\n1) Pick a number " +
                        "between 1 and 100\n\n2) Keep trying until you find the correct " +
                        "number\n\n");

            else if (menuChoice == 2)
            {
                // define and initialize random number
                int randomNumber = rand.nextInt(101);

                do {

                    do {
                        // Prompt user for input for a number between 1 and 100
                        numberInput = JOptionPane.showInputDialog("Please enter a number between " +
                                "1 and 100.");

                        if (numberInput == null) // Close program if user clicks on cancel
                        {
                            JOptionPane.showMessageDialog(null, "Good Bye!\n\nThanks for playing!");
                            System.exit(0);
                        }

                        // Input validation & exception handling
                        try {
                            numberChoice = Integer.parseInt(numberInput);
                        } catch (Exception e) {}


                        if (numberChoice < 1 || numberChoice > 100)
                            JOptionPane.showMessageDialog(null, "Invalid input.\n\nPlease enter " +
                                    "a number between 1 and 100.");
                        //else if (numberInput == null)
                        // System.exit();

                    } while (numberChoice < 1 || numberChoice > 100);

                    accumulator ++;

                    if (randomNumber == numberChoice)
                        JOptionPane.showMessageDialog(null, "Correct Number");

                    else if (randomNumber > numberChoice)
                        JOptionPane.showMessageDialog(null, "The number you entered is too low." +
                                "\n\nTry again");

                    else if (randomNumber < numberChoice)
                        JOptionPane.showMessageDialog(null, "The number you entered is too high." +
                                "\n\nTry again");

                } while (randomNumber != numberChoice);

                // scoring
                if (accumulator <=3)
                    JOptionPane.showMessageDialog(null,
                            "You did Great!\n\nYou found the correct number in " + accumulator +
                                    " tries.");

                else if (accumulator <=6)
                    JOptionPane.showMessageDialog(null, "You did Good!\n\nYou found the correct " +
                            "number in " + accumulator + " tries.");

                else
                    JOptionPane.showMessageDialog(null, "Better luck next time, you found the " +
                            "correct number in " + accumulator + " tries.");

                accumulator = 0;
            }

            else if (menuChoice == 3 || menuInput == null)
                JOptionPane.showMessageDialog(null, "Good Bye!\n\nThanks for playing!");

            else
                JOptionPane.showMessageDialog(null, "Invalid Input.\n\nPlease select an option " +
                        "between 1-3");

        } while (menuChoice != 3 && menuInput != null);

        System.exit(0); // Needed when using dialog boxes

    }
}
