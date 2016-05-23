import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * FirstForest is the first area with a menu introduced into the game
 * The menu is very simple, as to introduce the concept of having a menu
 * Only the basic functions are in this area, more functions will be added to later areas
 * 
 * Tyler Castro
 * Verson 1.0
 */
public class FirstForest
{
    Scanner scan = new Scanner(System.in);
    Hero hero;
    Lover lover;
    Text text;
    /**
     * Constructor, gets passed the Hero, Lover, and Text classes from the previous area
     */
    public FirstForest(Hero h, Lover l, Text t)
    {
        hero = h;
        lover = l;
        text = t;
    }

    /**
     * Prints the area menu
     * Menu changes depending on area
     */
    public static void printStartArea()
    {
        System.out.println("\nYou are in The Forest");
        System.out.println("Your options are as follows:");
        System.out.println("1. Shop");
        System.out.println("2. Stay at Inn for 15L (Heal HP and MP)");
        System.out.println("3. Hunt (Initiate battle)");
        System.out.println("4. Boss Battle (Recommended level 5)");
        System.out.println("5. Move on to next area (Requires Gate Key)");
        System.out.println("6. Show Stats");
        System.out.println("7. Speak to Marie");
    }

    /**
     * Runs the area menu, takes in the selection
     */
    public void startArea()
    {
        int haveKey = -1;
        while(haveKey == -1)
        {
            try
            {
                printStartArea();
                int action = scan.nextInt();
                switch(action)
                {
                    case 1:
                    this.shop();
                    break;
                    case 2:
                    if(hero.getMoney() >= 15)
                    {
                        System.out.println("Welcome to the Inn! You must be tired. Please, lay down and rest");
                        hero.inn(15);
                    }	
                    else
                    {
                        System.out.println("Not enough Laz!");
                    }
                    break;
                    case 3:
                    this.battle();
                    break;
                    case 4:
                    this.battle(1);
                    break;
                    case 5:
                    if(hero.keyCheck("Gate Key"))
                    {
                        System.out.println("Are you sure? There's no coming back. y or n");
                        String yorn = scan.next();
                        if(yorn.equalsIgnoreCase("y"))
                        {
                            haveKey = 1;
                        }
                    }
                    break;
                    case 6:
                    hero.showStats();
                    break;
                    case 7:
                    this.talkToMarie();
                    break;
                    default:

                    break;
                }
            }
            catch(InputMismatchException youDoneGoofed)
            {
                System.out.println("Unless specified, please input numbers only");
                scan.next();
            }
        }
        text.forestToCastle();
        SecondCastle second = new SecondCastle(hero, lover, text);
        second.startArea();
    }

    public void battle()
    {
        Enemy enemy = new Enemy();
        while(!(hero.dead()) && !(enemy.dead()))
        {
            try
            {
                enemy.display();
                hero.display();
                printMenu();
                int action = scan.nextInt();
                int damage = 0;
                switch(action)
                {
                    case 1:
                    damage = hero.attack();
                    enemy.damage(damage);
                    System.out.println("Dealt " + damage + " damage!");
                    break;
                    case 2:
                    System.out.println("Healed for " + hero.heal() + " hp");
                    break;
                    default:
                    System.out.println(hero.getName() + " doesn't act because that is not an action");
                    break;
                }
                int enemyAct = (int)(Math.random()*2) + 1;
                switch(enemyAct)
                {
                    case 1:
                    damage = enemy.attack();
                    hero.damage(damage);
                    System.out.println(enemy.name + " attacks!");
                    System.out.println(hero.getName() + " took " + damage + " damage!");
                    break;
                    default:
                    System.out.println(enemy.name + " twiddles its thumbs");
                    break;
                }
            }
            catch(InputMismatchException youDoneGoofed)
            {
                System.out.println("Unless specified, please input numbers only");
                scan.next();
            }
        }
        enemy.display();
        hero.display();
        if(enemy.dead())
        {
            hero.victory(enemy.money, enemy.exp, enemy.getItem());
            hero.levelUp();
        }
        else
        {
            int lost = (int)(hero.getMoney()*.1);
            System.out.println("The last thing you can see before blacking out is Marie dragging you somewhere");
            System.out.println("Lost " + lost + "L");
            hero.inn(lost);
        }
    }

    public void battle(int boss)
    {
        Enemy enemy = new Enemy(boss);
        while(!(hero.dead()) && !(enemy.dead()))
        {
            try
            {
                enemy.display();
                hero.display();
                printMenu();
                int action = scan.nextInt();
                int damage = 0;
                switch(action)
                {
                    case 1:
                    damage = hero.attack();
                    enemy.damage(damage);
                    System.out.println("Dealt " + damage + " damage!");
                    break;
                    case 2:
                    System.out.println("Healed for " + hero.heal() + " hp");
                    break;
                    default:
                    System.out.println(hero.getName() + " doesn't act because that is not an action");
                    break;
                }
                int enemyAct = (int)(Math.random()*3) + 1;
                switch(enemyAct)
                {
                    case 1:
                    damage = enemy.attack();
                    hero.damage(damage);
                    System.out.println(enemy.name + " attacks!");
                    System.out.println(hero.getName() + " took " + damage + " damage!");
                    break;
                    case 2:
                    System.out.println(enemy.name + " absorbs the energy of nature. Healed for " + enemy.heal());
                    break;
                    default:
                    System.out.println(enemy.name + " shakes its branches");
                    break;
                }
            }
            catch(InputMismatchException youDoneGoofed)
            {
                System.out.println("Unless specified, please input numbers only");
                scan.next();
            }
        }
        enemy.display();
        hero.display();
        if(enemy.dead())
        {
            hero.victory(enemy.money, enemy.exp);
            hero.keyPickUp("Gate Key");
            hero.levelUp();
        }
        else
        {
            int lost = (int)(hero.getMoney()*.1);
            System.out.println("The last thing you can see before blacking out is Marie dragging you somewhere");
            System.out.println("Lost " + lost + "L");
            hero.inn(lost);
        }
    }

    static public void printMenu()
    {
        System.out.println("What do you do?");
        System.out.println("1. Attack");
        System.out.println("2. Heal - 5MP");
    }

    String sword = "Cobalt Blade(+2 Str) - 150L";
    String armor = "Leather Armor(+2 Def) - 150L";
    String book = "Book on Fighting Techniques(+2 skl) - 150L";
    public void shop()
    {
        int leave = -1;
        int action;
        System.out.println("You enter the shop and see a cat with a nametag that reads \"Anna\"");
        System.out.println("\"Welcome to my shop! It isn't much, but feel free to look around\", she says");
        while(leave == -1)
        {
            try
            {
                System.out.println("        SHOP");
                System.out.println("       ======");
                System.out.println("\nYou have " + hero.getMoney() + "L\n");
                System.out.println("1. " + sword);
                System.out.println("2. " + armor);
                System.out.println("3. " + book);
                System.out.println("4. Sell Inventory (Sells entire inventory)");
                System.out.println("5. Leave");
                action = scan.nextInt();
                switch(action)
                {
                    case 1:
                    if(hero.getMoney() >= 150)
                    {
                        if(!(sword.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(150, 1, 2);
                            System.out.println("You bought the Cobalt Blade! Str went up by 2");
                            sword = "SOLD";
                        }
                        else
                        {
                            System.out.println("You already own this");
                        }
                    }
                    else
                    {
                        System.out.println("Not enough money");
                    }
                    break;
                    case 2:
                    if(hero.getMoney() >= 150)
                    {
                        if(!(armor.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(150, 2, 2);
                            System.out.println("You bought the Leather Armor! Def went up by 2");
                            armor = "SOLD";
                        }
                        else
                        {
                            System.out.println("You already own this");
                        }
                    }
                    else
                    {
                        System.out.println("Not enough money");
                    }
                    break;
                    case 3:
                    if(hero.getMoney() >= 150)
                    {
                        if(!(book.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(150, 3, 2);
                            System.out.println("You bought the Book! Skl went up by 2");
                            book = "SOLD";
                        }
                        else
                        {
                            System.out.println("You already own this");
                        }
                    }
                    else
                    {
                        System.out.println("Not enough money");
                    }
                    break;
                    case 4:
                    System.out.println("Gained " + hero.sellAll() + "L");
                    break;
                    case 5:
                    leave = 1;
                    System.out.println("\"Thank you for your patronage!\"");
                    break;
                    default:
                    leave = 1;
                    System.out.println("\"Thank you for your patronage!\"");
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

    public void talkToMarie()
    {
        if(hero.getLevel() < 5)
        {
            System.out.println("Marie: \"If I were you, I'd go hunting to train up to beat up the boss. You look too weak to even scratch him\"");
        }
        else if(!(hero.keyCheck("Gate Key")))
        {
            System.out.println("Marie: \"You could probably go beat up that boss now. I wouldn't bet on you though. Just a personal opinion\"");
        }
        else
        {
            System.out.println("Marie: \"Well, look at that! That's the Gate Key we need! Go to the gate and move on to the next area\"");
        }
    }
}

class Enemy
{
    Hit hit = new Hit();
    int maxhp, hp, money, exp, maxmp, mp;
    Item item, fail;
    String name;
    public Enemy()
    {
        maxhp = (int)(Math.random()*15) + 20;
        hp = maxhp;
        exp = (int)(Math.random()*15) + 5;
        money = (int)(Math.random()*15) + 10;
        int named = (int)(Math.random()*5) + 0;
        fail = new Item("nothing", 0);
        switch(named)
        {
            case 1:
            name = "Wolfis";
            item = new Item("Wolfis Claw", 30);
            break;
            case 2:
            name = "Mothruh";
            item = new Item("Mothruh Scale", 35);
            break;
            case 3:
            name = "Slimeling";
            item = new Item("Wet Cloth", 40);
            break;
            case 4:
            name = "Lost Camel";
            item = new Item("Broken Compass", 45);
            break;
            default:
            name = "Treant";
            item = new Item("Branch", 25);
            break;
        }
    }

    public Enemy(int boss)
    {
        name = "Forest Guardian Bvak";
        money = 200;
        exp = 70;
        maxhp = 150;
        hp = maxhp;
        maxmp = 30;
        mp = maxmp;
    }

    public void display()
    {
        System.out.println(name + " \nHP: " + hp + "/" +maxhp);
    }

    public Item getItem()
    {
        int failure = (int)(Math.random()*2) + 1;
        if(failure == 1)
        {
            return item;
        }
        else
        {
            return fail;
        }
    }

    public int attack()
    {
        if(name.equalsIgnoreCase("Forest Guardian Bvak"))
        {
            return (int)(Math.random()*31) + 25;
        }
        else
        {
            return (int)(Math.random()*16) + 20;
        }
    }

    public int heal()
    {
        if(mp < 10)
        {
            return 0;
        }
        else
        {
            mp -= 10;
            hp += 15;
            if(hp > maxhp)
            {
                hp = maxhp;
            }
            return 15;
        }
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