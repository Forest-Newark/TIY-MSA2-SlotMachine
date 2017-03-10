/**
 * Created by JamesHartanto on 3/10/17.
 */
import java.util.Random;

public class Person {
    public String name;
    public int money;
    public int bet;
    private boolean broke;

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    // Slot Machine Numbers
    Random slotNumbers = new Random();
    int slotNumber1 = slotNumbers.nextInt(10);
    int slotNumber2 = slotNumbers.nextInt(10);
    int slotNumber3 = slotNumbers.nextInt(10);

    // Player place bet and shows how much money they have left
    public void setBet(Person person) {
        // Controller place bet
        int playerBet = 5; // THIS NEEDS TO CONNECT THE TO SLOT MACHINE INTERFACE
        // Slot machine numbers
        System.out.printf("%s, %s, %s", slotNumber1, slotNumber2, slotNumber3);
        // Winnings and amount of money left
        int winnings = slotResults(playerBet, slotNumber1, slotNumber2, slotNumber3);
        person.money = person.money + winnings - playerBet;
        // Message for user
        forceLeave(person);
        System.out.println("You have " + person.money + " dollars left. " + security(message));
    }

    public static int slotResults(int betAmount, int slotNumber1, int slotNumber2, int slotNumber3) {
        if (slotNumber1 == slotNumber2 && slotNumber2 == slotNumber3 && slotNumber3 == 7) {
            System.out.println("Congratulations! You won " + (betAmount * 2) + " dollars!");
            return betAmount * 2;
        } else if (slotNumber1 == slotNumber2 && slotNumber2 == slotNumber3) {
            System.out.println("Congratulations! You got " + (betAmount) + " dollars back!");
            return betAmount;
        } else {
            System.out.println("Better luck next time!");
            return 0;
        }
    }

    String message = " ";

    public String forceLeave(Person person) {
        if (person.money > 0) {
            String message = "Please keep playing ";
        } else if (person.money <= -0) {
            String message = "Please leave the slot machine ";
        }
        return security(message);
    }

    private String security(String message) {
        return message + this.name;
    }
}
