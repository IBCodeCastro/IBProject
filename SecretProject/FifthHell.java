import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * FifthHell is the fifth area with a navigational menu
 * Gimmick is a repetition of a certain series of events 8 times with slight changes each time
 * Lampshaded by Marie for comedy (Comedy is a good thing)
 * Setting is a rebel village in hell that wishes to be free from the Demon King's rule
 * More and more "Pop Culture" references are being added
 * The repetition is a reference to the "Endless Eight"
 * 
 * Tyler Castro
 * Verson 1.0
 */
public class FifthHell
{
    Hero hero;
    Lover lover;
    Text text;
    StackADT stack = new LinkedStack();
    Scanner scan = new Scanner(System.in);
    /**
     * Constructor, gets passed the Hero, Lover, and Text classes from the previous area
     */
    public FifthHell(Hero h, Lover l, Text t)
    {
        hero = h;
        lover = l;
        text = t;
        int x = 15532;
        while(x > 15411)
        {
            stack.push(x);
            x -= 15;
        }
    }

    /**
     * Prints the area menu
     * Menu changes depending on area
     */
    public static void printStartArea()
    {
        System.out.println("\nWelcome to Hell");
        System.out.println("Your options are as follows:");
        System.out.println("1. Shop");
        System.out.println("2. Stay at Inn for 50L (Heal HP and MP)");
        System.out.println("3. Explore (Battle or find item)");
        System.out.println("4. Boss Battle (Recommended level 25) (Requires Infinity Pendant)");
        System.out.println("5. Move on to next area (Requires Blood Key)");
        System.out.println("6. Search for the Infinity Cave");
        System.out.println("7. Show Stats");
        System.out.println("8. Speak to Marie");
    }

    /**
     * Runs the area menu, takes in the selection
     */
    public void startArea()
    {
        int haveBoulderFragment = -1;
        while(haveBoulderFragment == -1)
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
                    if(hero.getMoney() >= 50)
                    {
                        System.out.println("Welcome to the Deminn! Please, rest up here.");
                        hero.inn(50);
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
                    if(hero.keyCheck("Infinity Pendant"))
                    {
                        this.battle(1);
                    }
                    else
                    {
                        System.out.println("\"You probably should get that pendant first\", says the demonic guard,");
                        System.out.println("\"I hear that it's got some sort of special power\"");
                        System.out.println("\"I'll keep that in mind\", you reply");
                    }
                    break;
                    case 5:
                    if(hero.keyCheck("Boulder Fragment"))
                    {
                        System.out.println("Are you sure? There's no coming back. y or n");
                        String yorn = scan.next();
                        if(yorn.equalsIgnoreCase("y"))
                        {
                            haveBoulderFragment = 1;
                        }
                    }
                    break;
                    case 6:
                    this.endlessEight();
                    break;
                    case 7:
                    hero.showStats(1);
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
        SixthHellCastle nextOne = new SixthHellCastle(hero, lover, text);
        text.hellToHellCastle();
        nextOne.startArea();
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
            System.out.println("You wandered around the hellish village and got a feel for the area");
            hero.gainEXP((int)(Math.random()*24) + 10);
            break;
            case 2:
            System.out.println("While meandering around the area, you found some money on the ground");
            hero.pickUp((int)(Math.random()*41) + 10);
            break;
            case 3:
            System.out.println("You decided to nap in the field that looked like it was the least on-fire");
            System.out.println("You awoke, feeling fully rested");
            hero.inn(0);
            break;
            case 4:
            System.out.println("While walking, you tripped and hurt yourself");
            hero.damage(((int)(Math.random()*25) + 20), 1);
            break;
            case 5:
            System.out.println("You decided to explore the area a little, but didn't discover anything new");
            break;
            default:
            System.out.println("You sat down and remembered your time together with " + lover.name + ", and reaffirmed your determination");
            break;
        }
    }

    int visits = 0;
    int clearCondition = 1;
    /**
     * Have the looping bit end with a choice of 8 options, only one is correct. This allows the player to shortcut the 
     * The Eight refers to the maximum number of times one must attempt it to get it right
     * 15,532 times but skip all but 8 of them in an interval of a random number that starts at 15,412
     * Increases by 15
     * Loops through a story a certain number of times, unable to complete the action until last time?
     * Turns out the miniboss is responsible for the loop
     */
    public void endlessEight()
    {
        Endless endless = new Endless(hero, text);
        if(visits == 0)
        {
            text.endlessEight();
            System.out.println("Right after entering the cave, you are hit on the back of the head and lose consciousness");
            visits++;
        }
        else
        {
            if(hero.keyCheck("Infinity Pendant"))
            {
                System.out.println("You started to walk in the direction of the cave, but then remembered what the cave was and turned around");
                System.out.println("\"Yeah, I don't want to have to do THAT ever again. It was so infuriating\", you think to yourself");
                clearCondition = 100;
            }
        }
        while(clearCondition <= 8)
        {
            try
            {
                text.endlessIntro();
                endless.endlessStart();
                text.timeLoop(stack.pop());
                text.endlessFalseEnd(clearCondition);
                if(clearCondition == 8)
                {
                    this.battle("nub");
                }
                clearCondition++;
            }
            catch(InputMismatchException youDoneGoofed)
            {
                System.out.println("Unless specified, please input numbers only");
            }
        }
    }

    String sword = "Bloodied Falchion(+2 Str) - 420L";
    String armor = "Hellstone Cuirass(+2 Def) - 420L";
    String book = "Forseti(+2 Skl) - 420L";
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
                    if(hero.getMoney() >= 420)
                    {
                        if(!(sword.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(420, 1, 2);
                            System.out.println("You bought the Bloodied Falchion! Str went up by 2");
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
                    if(hero.getMoney() >= 420)
                    {
                        if(!(armor.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(420, 2, 2);
                            System.out.println("You bought the Hellstone Cuirass! Def went up by 2");
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
                    if(hero.getMoney() >= 420)
                    {
                        if(!(book.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(420, 3, 2);
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
                    System.out.println("\"Depends. Would you like to make an unrelated donation of 170L to my shop?(y or n)\"");
                    String yorn = scan.nextLine();
                    if(yorn.equalsIgnoreCase("y"))
                    {
                        System.out.println("\"I heard that the key to escaping the cave is to satisfy the creature within\"");
                        System.out.println("\"And by that I mean that it want to do something but doesn't know what. Figure out what that is and you're home free\"");
                        hero.buy(170, 1, 0);
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
        Enemy5 enemy = new Enemy5();
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
                    System.out.println("Healed for " + hero.heal2() + " hp");
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
        Enemy5 enemy = new Enemy5(boss);
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
                    System.out.println("Healed for " + hero.heal2() + " hp");
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
                    System.out.println(enemy.name + " drinks some Unholy Water out of a nearby basin! Healed for " + enemy.heal());
                    break;
                    case 3:
                    damage = enemy.strongAttack();
                    System.out.println(enemy.name + " slashes " + hero.getName() + " with her giant scissors");
                    System.out.println(hero.getName() + " took " + damage + " damage!");
                    break;
                    default:
                    System.out.println(enemy.name + " taunts");
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
            hero.keyPickUp("Boulder Fragment");
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

    public void battle(String boss)
    {
        Enemy5 enemy = new Enemy5(boss);
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
                    System.out.println("Healed for " + hero.heal2() + " hp");
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
                    System.out.println(enemy.name + " dances furiously and starts to glow. Healed for  " + enemy.heal());
                    break;
                    case 3:
                    damage = enemy.strongAttack();
                    System.out.println(enemy.name + " strikes " + hero.getName() + " with its sweet dance moves");
                    System.out.println(hero.getName() + " took " + damage + " damage!");
                    break;
                    default:
                    System.out.println(enemy.name + " taunts" + hero.getName() + " with their dancing");
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
            hero.keyPickUp("Infinity Pendant");
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
        System.out.println("2. Heal - 10MP");
        System.out.println("3. Heavy Attack - 15MP");
        System.out.println("4. Swift Attack - 15MP");
    }

    public void talkToMarie()
    {
        if(!(hero.keyCheck("Infinity Pendant")))
        {
            System.out.println("Marie: \"I think that pendant can be obtained after doing something about 8 times repeatedly. Everyone hates it\"");
        }
        else if((hero.keyCheck("Infinity Pendant")) && !(hero.keyCheck("Boulder Fragment")))
        {
            System.out.println("Marie: \"Oh, you got the key. Good, now you can open that locked door.\"");
        }
        else
        {
            System.out.println("Marie: \"\"");
        }
    }
}

class Enemy5
{
    Hit hit = new Hit();
    int maxhp, hp, money, exp, maxmp, mp;
    Item item, fail;
    String name;
    public Enemy5()
    {
        maxhp = (int)(Math.random()*25) + 100;
        hp = maxhp;
        exp = (int)(Math.random()*20) + 45;
        money = (int)(Math.random()*25) + 90;
        int named = (int)(Math.random()*5) + 0;
        fail = new Item("nothing", 0);
        switch(named)
        {
            case 1:
            name = "Fire Imp";
            item = new Item("Burned Flesh", 100);
            break;
            case 2:
            name = "Voodoo Demon";
            item = new Item("Voodoo Doll", 95);
            break;
            case 3:
            name = "Demon Tree";
            item = new Item("Charcoal Bark", 120);
            break;
            case 4:
            name = "Demonic Camel";
            item = new Item("Evil Hooves", 100);
            break;
            default:
            name = "Demonic Loyalist";
            item = new Item("Draft Notice", 90);
            break;
        }
    }

    public Enemy5(int boss)
    {
        name = "Sisyphus";
        money = 1400;
        exp = 400;
        maxhp = 800;
        hp = maxhp;
        maxmp = 145;
        mp = maxmp;
    }

    public Enemy5(String miniboss)
    {
        name = "Boney N";
        money = 1320;
        exp = 370;
        maxhp = 740;
        hp = maxhp;
        maxmp = 145;
        mp = maxmp;
    }

    public void display()
    {
        if((name.equalsIgnoreCase("Sisyphus")) || (name.equalsIgnoreCase("Boney N")))
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
        if(name.equalsIgnoreCase("Sisyphus"))
        {
            return 118;
        }
        else if(name.equalsIgnoreCase("Boney N"))
        {
            return 107;
        }
        else
        {
            return 80;
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
            return 150;
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
            hp += 90;
            if(hp > maxhp)
            {
                hp = maxhp;
            }
            return 90;
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