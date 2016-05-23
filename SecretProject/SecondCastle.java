import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * SecondCastle is the second area with a navigational menu in the game.
 * It is as simplistic as FirstForest to display the generic changes between areas
 * Such as price of things, items in shops, enemies, boss, and Key Items
 * 
 * Tyler Castro
 * Verson 1.0
 */
public class SecondCastle
{
    Scanner scan = new Scanner(System.in);
    Hero hero;
    Lover lover;
    Text text;

    /**
     * Constructor, gets passed the Hero, Lover, and Text classes from the previous area
     */
    public SecondCastle(Hero h, Lover l, Text t)
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
        System.out.println("\nYou are in The Castle");
        System.out.println("Your options are as follows:");
        System.out.println("1. Shop");
        System.out.println("2. Stay at Inn for 25L (Heal HP and MP)");
        System.out.println("3. Search (Initiate battle)");
        System.out.println("4. Boss Battle (Recommended level 10)");
        System.out.println("5. Move on to next area (Requires Royal Gem)");
        System.out.println("6. Show Stats");
        System.out.println("7. Speak to Marie");
    }

    /**
     * Runs the area menu, takes in the selection
     */
    public void startArea()
    {
        int haveGem = -1;
        while(haveGem == -1)
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
                    if(hero.getMoney() >= 25)
                    {
                        System.out.println("Welcome to the Inn! You must be tired. Please, lay down and rest");
                        hero.inn(25);
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
                    if(hero.keyCheck("Royal Gem"))
                    {
                        System.out.println("Are you sure? There's no coming back. y or n");
                        String yorn = scan.next();
                        if(yorn.equalsIgnoreCase("y"))
                        {
                            haveGem = 1;
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
        ThirdLabyrinth labyrinth = new ThirdLabyrinth(hero, lover, text);
        text.castleToLabyrinth();
        labyrinth.startArea();
    }

    String sword = "Mithril Blade(+2 Str) - 250L";
    String armor = "Iron Armor(+2 Def) - 250L";
    String book = "Book on Monster Weaknesses(+2 Skl) - 250L";
    public void shop()
    {
        int leave = -1;
        int action;
        System.out.println("You enter the shop and see a shopkeeper with a nametag that reads \"Anna\"");
        System.out.println("\"I've got some stuff, as long as you've got the Laz\", she says");
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
                    if(hero.getMoney() >= 250)
                    {
                        if(!(sword.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(250, 1, 2);
                            System.out.println("You bought the Mithril Blade! Str went up by 2");
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
                    if(hero.getMoney() >= 250)
                    {
                        if(!(armor.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(250, 2, 2);
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
                    if(hero.getMoney() >= 250)
                    {
                        if(!(book.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(250, 3, 2);
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

    public void battle()
    {
        Enemy2 enemy = new Enemy2();
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
                    case 3:
                    damage = hero.heavyStrike();
                    enemy.damage(damage);
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
        Enemy2 enemy = new Enemy2(boss);
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
                    case 3:
                    damage = hero.heavyStrike();
                    enemy.damage(damage);
                    System.out.println("Dealt " + damage + " damage!");
                    break;
                    default:
                    System.out.println(hero.getName() + " doesn't act because that is not an action");
                    break;
                }
                int enemyAct = (int)(Math.random()*4) + 1;
                switch(enemyAct)
                {
                    case 1:
                    damage = enemy.attack();
                    hero.damage(damage);
                    System.out.println(enemy.name + " attacks!");
                    System.out.println(hero.getName() + " took " + damage + " damage!");
                    break;
                    case 2:
                    System.out.println(enemy.name + " drinks the blood of a servant. Healed for " + enemy.heal());
                    break;
                    case 3:
                    System.out.println(enemy.name + " strikes " + hero.getName() + " with his scepter");
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
            hero.victory(enemy.money, enemy.exp);
            hero.keyPickUp("Royal Gem");
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
        System.out.println("3. Heavy Attack - 15MP");
    }

    public void talkToMarie()
    {
        if(hero.getLevel() < 10)
        {
            System.out.println("Marie: \"You've certainly gotten stronger since last time, but this is THE Mad King we're facing here. Get a little stronger.\"");
        }
        else if(!(hero.keyCheck("Royal Gem")))
        {
            System.out.println("Marie: \"You could probably go beat up the Mad King now. Go and get that gem! Oh, and I guess free these people from a tyrant while you're at it\"");
        }
        else
        {
            System.out.println("Marie: \"Didn't think you could get that Royal Gem. Now you can progress, and hopefully turn your soul over to me\"");
        }
    }
}

class Enemy2
{
    Hit hit = new Hit();
    int maxhp, hp, money, exp, maxmp, mp;
    Item item, fail;
    String name;
    public Enemy2()
    {
        maxhp = (int)(Math.random()*25) + 70;
        hp = maxhp;
        exp = (int)(Math.random()*20) + 15;
        money = (int)(Math.random()*25) + 30;
        int named = (int)(Math.random()*5) + 0;
        fail = new Item("nothing", 0);
        switch(named)
        {
            case 1:
            name = "Posessed Soldier";
            item = new Item("Legion Emblem", 60);
            break;
            case 2:
            name = "Rugged Thief";
            item = new Item("Bandana", 55);
            break;
            case 3:
            name = "Witch";
            item = new Item("Eye of Newt", 50);
            break;
            case 4:
            name = "Tourist Camel";
            item = new Item("Map", 60);
            break;
            default:
            name = "Rubble Golem";
            item = new Item("Bricks", 50);
            break;
        }
    }

    public Enemy2(int boss)
    {
        name = "The Mad King, Plagaius";
        money = 500;
        exp = 140;
        maxhp = 270;
        hp = maxhp;
        maxmp = 55;
        mp = maxmp;
    }

    public void display()
    {
        if(name.equalsIgnoreCase("The Mad King, Plagaius"))
        {
            System.out.println(name + " \nHP: " + hp + "/" +maxhp + "\nMP: " + mp + "/" + maxmp);
        }
        else
        {
            System.out.println(name + " \nHP: " + hp + "/" +maxhp);
        }
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
        if(name.equalsIgnoreCase("The Mad King, Plagaius"))
        {
            return (int)(Math.random()*31) + 40;
        }
        else
        {
            return (int)(Math.random()*21) + 30;
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
            hp += 25;
            if(hp > maxhp)
            {
                hp = maxhp;
            }
            return 25;
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
        if(hp < 0)
        {
            hp = 0;
        }
    }

    public boolean dead()
    {
        return hp <= 0;
    }
}