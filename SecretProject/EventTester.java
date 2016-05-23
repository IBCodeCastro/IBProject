
public class EventTester
{
    public static void main(String[] args)
    {
        {
            int searchOrBattle = (int)(Math.random()*3) + 1;
            if(searchOrBattle <= 2)
            {
                System.out.println("BATTLE HAPPENED");
            }
            else
            {
                int eventType = (int)(Math.random()*6) + 1;
                switch(eventType)
                {
                    case 1:
                    System.out.println("You wandered around the temple gates and got a feel for the area");
                    System.out.println("EXP GAINED");
                    break;
                    case 2:
                    System.out.println("While meandering around the area, you found some money on the ground");
                    System.out.println("GOT MONEY");
                    break;
                    case 3:
                    System.out.println("You decided to nap in the empty field");
                    System.out.println("You awoke, feeling fully rested");
                    System.out.println("HEALED");
                    break;
                    case 4:
                    System.out.println("While walking, you tripped and hurt yourself");
                    System.out.println("TOOK DAMAGE YOU FOOLISH FOOL WHO IS FOOLISH");
                    break;
                    case 5:
                    System.out.println("You decided to explore the area a little, but didn't discover anything new");
                    System.out.println("NOTHING HAPPENED");
                    break;
                    default:
                    System.out.println("You sat down and remembered your time together with DEFAULT_NAME, and reaffirmed your determination");
                    System.out.println("NOTHING HAPPENED");
                    break;
                }
            }
        }
    }
}
