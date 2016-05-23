import java.util.Scanner;
/**
 * Tests to see if the labyringth method in the Laybrinth area works
 * 
 * Tyler Castro
 * Version 1.0
 */
public class LabyrithTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        //F F R R B B L L
        int exit = 0;
        int lefts = 0;
        int ups = 0;
        int downs = 0;
        int rights = 0;
        System.out.println("You enter the labyrinth and feel a cold wind blowing from the left");
        System.out.println("\"Let's hope I don't get lost\", you think out loud");
        System.out.println("\"Well, I guess I could help you out there. I'll make markings so you can find your way back\" Marie teases");
        while(exit != -1)
        {
            System.out.println("Which way do you go?\n");
            System.out.println("1. Forward");
            System.out.println("2. Left");
            System.out.println("3. Right");
            System.out.println("4. Backwards");
            System.out.println("5. Exit");
            int move = scan.nextInt();
            switch(move)
            {
                case 1:
                if((ups == 0) || (ups == 1))
                {
                    ups++;
                }
                else
                {
                    ups = 0;
                    lefts = 0;
                    downs = 0;
                    rights = 0;
                }
                break;
                case 2:
                if((downs == 2) && ((lefts == 0) || (lefts == 1)))
                {
                    lefts++;
                }
                else
                {
                    ups = 0;
                    lefts = 0;
                    downs = 0;
                    rights = 0;
                }
                break;
                case 3:
                if((ups == 2) && ((rights == 0) || (rights == 1)))
                {
                    rights++;
                }
                else
                {
                    ups = 0;
                    lefts = 0;
                    downs = 0;
                    rights = 0;
                }
                break;
                case 4:
                if((rights == 2) && ((downs == 0) || (downs == 1)))
                {
                    downs++;
                }
                else
                {
                    ups = 0;
                    lefts = 0;
                    downs = 0;
                    rights = 0;
                }
                break;
                default:
                exit = -1;
                break;
            }
            if(lefts == 2)
            {
                System.out.println("After reaching what appears to be a dead end, you spy a pedistal with something on it");
                System.out.println("After further investigation, you discover that the object is a rusted key");
                System.out.println("Recieved \"Old Key\"!");
                System.out.println("\"Oh hey, that key looks like it might fit into that locked door at the entrance\", chimes Marie");
                System.out.println("\"I heard that theres a tough beast behind that door though, so be careful\"");
                exit = -1;
            }
        }
    }
}
