import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * ThirdLabyrinth is the third area with a navigational menu
 * This area differs from the previous areas because it has a gimmick associated with it
 * The labyrinth is the first gimmick in an area, and every area after this will have a gimmick to it
 * This area is also the first area that can have events prompted by the "Explore" option
 * 
 * Tyler Castro
 * Verson 1.3
 */
public class ThirdLabyrinth
{
    Hero hero;
    Lover lover;
    Text text;
    Scanner scan = new Scanner(System.in);
    /**
     * Constructor, gets passed the Hero, Lover, and Text classes from the previous area
     */
    public ThirdLabyrinth(Hero h, Lover l, Text t)
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
        System.out.println("\nYou are at the entrance of the Labyrinth");
        System.out.println("Your options are as follows:");
        System.out.println("1. Shop");
        System.out.println("2. Stay at Inn for 35L (Heal HP and MP)");
        System.out.println("3. Explore (Battle or Events)");
        System.out.println("4. Boss Battle (Recommended level 15) (Requires Old Key)");
        System.out.println("5. Move on to next area (Requires Minotaur Horn)");
        System.out.println("6. Explore the Labyrinth");
        System.out.println("7. Show Stats");
        System.out.println("8. Speak to Marie");
    }

    /**
     * Runs the area menu, takes in the selection
     */
    public void startArea()
    {
        int haveHorn = -1;
        while(haveHorn == -1)
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
                    if(hero.getMoney() >= 35)
                    {
                        System.out.println("Welcome to the LabyrInn! Clever name, I know. You must be tired. Please, lay down and rest");
                        hero.inn(35);
                    }	
                    else
                    {
                        System.out.println("Not enough Laz!");
                    }
                    break;
                    case 3:
                    this.search();
                    break;
                    case 4:
                    if(hero.keyCheck("Old Key"))
                    {
                        this.battle(1);
                    }
                    else
                    {
                        System.out.println("The door is locked. Maybe you'll find the key in the Labyrinth...");
                    }
                    break;
                    case 5:
                    if(hero.keyCheck("Minotaur Horn"))
                    {
                        System.out.println("Are you sure? There's no coming back. y or n");
                        String yorn = scan.next();
                        if(yorn.equalsIgnoreCase("y"))
                        {
                            haveHorn = 1;
                        }
                    }
                    break;
                    case 6:
                    this.labyrinth();
                    break;
                    case 7:
                    hero.showStats();
                    break;
                    case 8:
                    this.talkToMarie();
                    break;
                    default:

                    break;
                }
            }
            catch(InputMismatchException youDoneGoofed)
            {
                System.out.println("Unless specified, please input numbers only");
            }
        }
        FourthTemple temple = new FourthTemple(hero, lover, text);
        text.labyrinthToTemple();
        temple.startArea();
    }

    public void search()
    {
        int searchOrBattle = (int)(Math.random()*3) + 1;
        if(searchOrBattle <= 2)
        {
            this.battle();
        }
        else
        {
            this.event();
        }
    }

    public void event()
    {
        int eventType = (int)(Math.random()*6) + 1;
        switch(eventType)
        {
            case 1:
            System.out.println("You wandered around the entrance to the labyrinth and got a feel for the area");
            hero.gainEXP((int)(Math.random()*16) + 10);
            break;
            case 2:
            System.out.println("While meandering around the area, you found some money on the ground");
            hero.pickUp((int)(Math.random()*31) + 10);
            break;
            case 3:
            System.out.println("You decided to nap in the empty field");
            System.out.println("You awoke, feeling fully rested");
            hero.inn(0);
            break;
            case 4:
            System.out.println("While walking, you tripped and hurt yourself");
            hero.damage(((int)(Math.random()*11) + 10), 1);
            break;
            case 5:
            System.out.println("You decided to explore the area a little, but didn't discover anything new");
            break;
            default:
            System.out.println("You sat down and stared at the locked door, wondering how to open it");
            break;
        }
    }

    public void labyrinth()
    {
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
                hero.keyPickUp("Old Key");
                System.out.println("\"Oh hey, that key looks like it might fit into that locked door at the entrance\", chimes Marie");
                System.out.println("\"I heard that theres a tough beast behind that door though, so be careful\"");
                exit = -1;
            }
        }
    }

    String sword = "Orichalcum Sword(+2 Str) - 350L";
    String armor = "Steel Armor(+2 Def) - 350L";
    String book = "Book of Maps(+2 Skl) - 350L";
    public void shop()
    {
        int leave = -1;
        int action;
        System.out.println("You enter the shop and see a shopkeeper with a nametag that reads \"Anna\"");
        System.out.println("\"I've got goods and info, as long as you've got the Laz.\", she says");
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
                System.out.println("5. Heard any rumors lately?");
                System.out.println("6. Leave");
                action = scan.nextInt();
                switch(action)
                {
                    case 1:
                    if(hero.getMoney() >= 350)
                    {
                        if(!(sword.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(350, 1, 2);
                            System.out.println("You bought the Orichalcum Sword! Str went up by 2");
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
                    if(hero.getMoney() >= 350)
                    {
                        if(!(armor.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(350, 2, 2);
                            System.out.println("You bought the Steel Armor! Def went up by 2");
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
                    if(hero.getMoney() >= 350)
                    {
                        if(!(book.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(350, 3, 2);
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
                    System.out.println("\"Depends. Would you like to make an unrelated donation of 100L to my shop?(y or n)\"");
                    String yorn = scan.nextLine();
                    if(yorn.equalsIgnoreCase("y"))
                    {
                        System.out.println("\"Well, I've heard that the path through the labyrinth is FFRRBBLL\"");
                        hero.buy(100, 1, 0);
                    }
                    else
                    {
                        System.out.println("\"Then I've heard nothing\"");
                    }
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
        Enemy3 enemy = new Enemy3();
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
                    case 4:
                    damage = hero.swiftStrike();
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
        Enemy3 enemy = new Enemy3(boss);
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
                    case 4:
                    damage = hero.swiftStrike();
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
                    System.out.println(enemy.name + " eats a nearby corpse. Healed for " + enemy.heal());
                    break;
                    case 3:
                    damage = enemy.strongAttack();
                    System.out.println(enemy.name + " charges " + hero.getName());
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
            hero.keyPickUp("Minotaur Horn");
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
        System.out.println("4. Swift Attack - 15MP");
    }

    public void talkToMarie()
    {
        if(!(hero.keyCheck("Old Key")))
        {
            System.out.println("Marie: \"Oh, the Labyrinth. I've heard that there's a key hidden within it, but it's a maze\"");
        }
        else if((hero.keyCheck("Old Key")) && !(hero.keyCheck("Minotaur Horn")))
        {
            System.out.println("Marie: \"Oh, you got the key. Good, now you can open that locked door.\"");
        }
        else
        {
            System.out.println("Marie: \"Well, lets move on to the Temple to get something else we'll need\"");
        }
    }
}

class Enemy3
{
    Hit hit = new Hit();
    int maxhp, hp, money, exp, maxmp, mp;
    Item item, fail;
    String name;
    public Enemy3()
    {
        maxhp = (int)(Math.random()*25) + 60;
        hp = maxhp;
        exp = (int)(Math.random()*20) + 20;
        money = (int)(Math.random()*25) + 50;
        int named = (int)(Math.random()*5) + 0;
        fail = new Item("nothing", 0);
        switch(named)
        {
            case 1:
            name = "Arcane Turret";
            item = new Item("Magic Bullet", 70);
            break;
            case 2:
            name = "Rugged Thief";
            item = new Item("Bandana", 75);
            break;
            case 3:
            name = "Opulent Hand";
            item = new Item("Golden Chip", 80);
            break;
            case 4:
            name = "Maze Camel";
            item = new Item("Tears of the Forgotten", 70);
            break;
            default:
            name = "Haunted Torch";
            item = new Item("Charcoal", 60);
            break;
        }
    }

    public Enemy3(int boss)
    {
        name = "Minotaur";
        money = 970;
        exp = 230;
        maxhp = 400;
        hp = maxhp;
        maxmp = 105;
        mp = maxmp;
    }

    public void display()
    {
        if(name.equalsIgnoreCase("Minotaur"))
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
        if(name.equalsIgnoreCase("Minotaur"))
        {
            return 84;
        }
        else
        {
            return 76;
        }
    }

    public int strongAttack()
    {
        if(mp < 10)
        {
            return 0;
        }
        else
        {
            mp -= 10;
            return 100;
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
            hp += 70;
            if(hp > maxhp)
            {
                hp = maxhp;
            }
            return 70;
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
