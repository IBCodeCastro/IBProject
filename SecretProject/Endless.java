import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * The components of the endless loop that is the gimmick of FifthHell
 * Everything is called in FifthHell, but the loops and stuff are here to de-clutter the primary area
 * 
 */
public class Endless
{
    Scanner scan = new Scanner(System.in);
    Hero hero;
    Text text;
    /**
     * Constructor for objects of class Endless
     */
    public Endless(Hero h, Text t)
    {
        hero = h;
        text = t;
    }
    
    int eat = 0;
    /**
     * Start of EE
     */
    public void endlessStart()
    {
        System.out.println("You and the group went to the pool for a while, then got hungry");
        System.out.println("As the penalty for being late, you must pay for everyone's lunch");
        System.out.println("You must decide on what to order");
        int ordered = -1;
        while(ordered == -1)
        {
            try
            {
                printMenu();
                int action = scan.nextInt();
                switch(action)
                {
                    case 1:
                    System.out.println("You decided to order the Sandwich");
                    eat++;
                    ordered++;
                    break;
                    case 2:
                    System.out.println("You decided to order the lunch special");
                    eat++;
                    ordered++;
                    break;
                    case 3:
                    System.out.println("You decided to order the Omlet");
                    eat++;
                    ordered++;
                    break;
                    default:
                    System.out.println("You decided not to order in order to save money. You had a nice breakfast anyway");
                    ordered++;
                    break;
                }
            }
            catch(InputMismatchException youDoneGoofed)
            {
                System.out.println("Unless specified, please input numbers only");
                scan.next();
            }
        }
        text.lunchIncident();
    }
    
    public void printMenu()
    {
        System.out.println("1. Sandwich");
        System.out.println("2. Today's special");
        System.out.println("3. Omlet");
    }
}
