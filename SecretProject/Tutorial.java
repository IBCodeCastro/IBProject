import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Tutorial provides an easy boss fight that you shouldn't lose
 * Allows for player to learn how to fight without annoying stoppages in play
 * Essentially giving the player free reign right off the bat
 * 
 * Tyler Castro
 * Verson 1.0
 */
public class Tutorial
{
    Scanner scan = new Scanner(System.in);
    Hero hero;
    Text text;
    Lover lover;
    Goblin boss = new Goblin();
    public Tutorial(Hero h, Lover l, Text t)
    {
        hero = h;
        lover = l;
        text = t;
    }

    public void tutorial()
    {
        while(!(hero.dead()) && !(boss.dead()))
        {
            try
            {
                boss.display();
                hero.display();
                printMenu();
                int action = scan.nextInt();
                int damage = 0;
                switch(action)
                {
                    case 1:
                    damage = hero.attack();
                    boss.damage(damage);
                    System.out.println("Dealt " + damage + " damage!");
                    break;
                    default:
                    System.out.println(hero.getName() + " doesn't act because that is not an action");
                    break;
                }
                int enemyAct = (int)(Math.random()*2) + 1;
                switch(enemyAct)
                {
                    case 1:
                    damage = boss.attack();
                    hero.damage(damage);
                    System.out.println(boss.name + " attacks!");
                    System.out.println(hero.getName() + " took " + damage + " damage!");
                    break;
                    default:
                    System.out.println(boss.name + " twiddles his thumbs");
                    break;
                }    
            }
            catch(InputMismatchException youDoneGoofed)
            {
                System.out.println("Unless specified, plese only use integers");
                scan.next();
            }
        }
        boss.display();
        hero.display();
        hero.victory(boss.getMoney(), boss.getExp());
        hero.levelUp();

        text.forestEncounter();
        FirstForest forest = new FirstForest(hero, lover, text);
        forest.startArea();
    }

    static public void printMenu()
    {
        System.out.println("What do you do?");
        System.out.println("1. Attack");
    }
}

class Goblin
{
    Hit hit = new Hit();
    int maxhp, hp, money, exp;
    String name;
    public Goblin()
    {
        maxhp = 15;
        hp = maxhp;
        exp = 10;
        money = 10;
        name = "Goblin Lord Xdgaf";
    }

    public void display()
    {
        System.out.println(name + " \nHP: " + hp + "/" +maxhp);
    }

    public int attack()
    {
        return 15;
    }

    public int getMoney()
    {
        return money;
    }

    public int getExp()
    {
        return exp;
    }

    public void damage(int damage)
    {
        hp -= damage;
    }

    public boolean dead()
    {
        return hp <= 0;
    }
}

