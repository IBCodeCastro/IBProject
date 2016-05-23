import java.util.Scanner;
/**
 * Tests level ups and gauge the how difficult the enemies should be in each area
 * Uses the algorithm from the levelUp() method
 * Includes stats, maxHP, maxMP, and maxEXP
 * 
 * Tyler Castro
 * Verson 1.2
 */
public class LevelSim
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int maxhp, maxExp, hp, level, str, def, skl;
        maxhp = 50;
        maxExp = 10;
        hp = maxhp;
        level = 1;
        str = 5;
        def = 4;
        skl = 2;
        int answer = 1;
        while(answer > 0)
        {
            System.out.println("Level: " + level);
            System.out.println("HP: " + maxhp);
            System.out.println("Max EXP: " + maxExp);
            System.out.println("Str: " + str);
            System.out.println("Def: " + def);
            System.out.println("Skl: " + skl);
            System.out.println("What would you like to do? Do -1 to exit");
            System.out.println("1. Level up specified amount of times");
            System.out.println("2. Purchace the items (+2 to all stats)");
            answer = scan.nextInt();
            switch(answer)
            {
                case 1:
                System.out.println("How many levels would you like to level up?");
                int levelAmount = scan.nextInt();
                for(int x = 0; x < levelAmount; x++)
                {
                    int strUp = (int)(Math.random()*3)+1;
                    str += strUp;
                    int defUp = (int)(Math.random()*3)+1;
                    def += defUp;
                    int sklUp = (int)(Math.random()*2)+1;
                    skl += sklUp;
                    maxhp += 15;
                    maxExp += 10;
                    hp = maxhp;
                    level++;
                }
                break;
                case 2:
                str += 2;
                def += 2;
                skl += 2;
                break;
                default:
                
                break;
            }
        }
    }
}
