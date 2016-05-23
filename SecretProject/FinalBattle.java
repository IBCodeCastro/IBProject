import java.util.Scanner;
import java.util.InputMismatchException;
public class FinalBattle
{
    Hero hero;
    Lover lover;
    FinalBoss boss = new FinalBoss();
    Scanner scan = new Scanner(System.in);
    Text text;
    public FinalBattle(Hero h, Lover l, Text t)
    {
        hero = h;
        lover = l;
        text = t;
    }

    static int timesDied = 0;
    /**
     * This method is run by initiating the final battle in the previous area
     * If you fail to defeat the Demon King, it displays the bad ending, credits, then allows you to go back to the previous area
     * use this opportunity to train and try again
     */
    public boolean battle()
    {
        while(!(hero.dead()) && !(boss.dead()))
        {
            try
            {
                System.out.println("Demon King \nHP: " + boss.hp + "/" + boss.maxhp);
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
                    case 2:
                    System.out.println("Healed for " + hero.heal2() + " hp");
                    break;
                    case 3:
                    damage = hero.heavyStrike();
                    boss.damage(damage);
                    System.out.println("Dealt " + damage + " damage!");
                    break;
                    case 4:
                    damage = hero.swiftStrike();
                    boss.damage(damage);
                    System.out.println("Dealt " + damage + " damage!");
                    break;
                    case 99:
                    boss.damage(9999999);
                    break;
                    case 666:
                    hero.damage(99999999);
                    break;
                    default:
                    System.out.println(hero.getName() + " doesn't act because that is not an action");
                    break;
                }
                int enemyAct = (int)(Math.random()*6) + 1;
                switch(enemyAct)
                {
                    case 1:
                    damage = boss.attack();
                    hero.damage(damage);
                    System.out.println(hero.getName() + " took " + damage + " damage!");
                    break;
                    case 2:
                    damage = boss.magic();
                    System.out.println(hero.getName() + " took " + damage + " damage!");
                    hero.damage(damage);
                    default:
                    System.out.println("Demon King twiddles his thumbs");
                    break;
                }
            }
            catch(InputMismatchException youDoneGoofed)
            {
                System.out.println("Unless specified, please input numbers only");
                scan.next();
            }
        }
        System.out.println("Demon King \nHP: " + boss.hp + "/" + boss.maxhp);
        hero.display();
        if((boss.hp <= 0))
        {
            text.finalInterrupt();
            hero.overpower();
            boss.resurrect();
            text.finisher();
            this.finishHim();
            text.goodEnd();
            text.credits();
            return true;
        }
        else 
        {
            text.badEnd();
            text.credits();
            return false;
        }
    }

    static public void printMenu()
    {
        System.out.println("What do you do?");
        System.out.println("1. Attack");
        System.out.println("2. Heal (10 mp)");
        System.out.println("3. Heavy Attack (15 mp)");
        System.out.println("4. Swift Attack (15 mp)");
    }
    
    public void finishHim()
    {
        while(!(hero.dead()) && !(boss.dead()))
        {
            try
            {
                System.out.println("Demon King \nHP: " + boss.hp + "/" + boss.maxhp);
                hero.display();
                printMenu();
                int action = scan.nextInt();
                int damage = 0;
                switch(action)
                {
                    case 1:
                    damage = hero.attack();
                    boss.damage(damage);
                    System.out.println("\"You'll pay for your insolence!\", the Demon King shouts");
                    System.out.println("Dealt " + damage + " damage!");
                    break;
                    case 2:
                    System.out.println("\"Your gods can't help you now!\", the Demon King shouts");
                    System.out.println("Healed for " + hero.heal2() + " hp");
                    break;
                    case 3:
                    damage = hero.heavyStrike();
                    boss.damage(damage);
                    System.out.println("\"You'll pay for your insolence!\", the Demon King shouts");
                    System.out.println("Dealt " + damage + " damage!");
                    break;
                    case 4:
                    damage = hero.swiftStrike();
                    boss.damage(damage);
                    System.out.println("\"You'll pay for your insolence!\", the Demon King shouts");
                    System.out.println("Dealt " + damage + " damage!");
                    break;
                    case 99:
                    System.out.println("\"How....could you....cheat....like this...\"");
                    boss.damage(9999999);
                    break;
                    case 666:
                    System.out.println("\"Now why would you go and spoil all my fun like that?\"");
                    hero.damage(99999999);
                    break;
                    default:
                    System.out.println(hero.getName() + " doesn't act because that is not an action");
                    break;
                }
                int enemyAct = (int)(Math.random()*6) + 1;
                switch(enemyAct)
                {
                    case 1:
                    damage = boss.attack();
                    hero.damage(damage);
                    System.out.println(hero.getName() + " took " + damage + " damage!");
                    break;
                    case 2:
                    damage = boss.magic();
                    System.out.println(hero.getName() + " took " + damage + " damage!");
                    hero.damage(damage);
                    default:
                    System.out.println("\"There's simply no way you can defeat me!\", the Demon King boasts");
                    break;
                }
            }
            catch(InputMismatchException youDoneGoofed)
            {
                System.out.println("Unless specified, please input numbers only");
                scan.next();
            }
        }
    }
}

class FinalBoss
{
    Hit hit = new Hit();
    int hp, maxhp;
    public FinalBoss()
    {
        maxhp = 7000;
        hp = maxhp;
    }

    public int laugh()
    {
        return 0;
    }
    
    public void resurrect()
    {
        maxhp = 7000;
        hp = maxhp;
    }

    public int attack()
    {
        return hit.crit(((int)(Math.random()*101) + 100), 7);
    }

    public int heavyStrike()
    {
        if(hit.hit(90))
        {
            return hit.crit(((int)(Math.random()*201) + 210), 3);
        }
        else
        {
            return 0;
        }
    }

    public int swiftStrike()
    {
        if(hit.hit(97))
        {
            return hit.crit(((int)(Math.random()*101) + 80), 40);
        }
        else
        {
            return 0;
        }
    }

    public int magic()
    {
        if(hit.hit(70))
        {
            return hit.crit(((int)(Math.random()*301) + 100), 2);
        }
        else
        {
            return 0;
        }
    }

    public int finisher()
    {
        return 999999999;
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
