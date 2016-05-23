import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Write a description of class SixthHellCastle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SixthHellCastle
{
    Hero hero;
    Lover lover;
    Text text;
    Scanner scan = new Scanner(System.in);
    int numOfBlades = 1;
    /**
     * Constructor, gets passed the Hero, Lover, and Text classes from the previous area
     */
    public SixthHellCastle(Hero h, Lover l, Text t)
    {
        hero = h;
        lover = l;
        text = t;
    }

    static String swordWall = "Strange wall with a lot of indentations";
    /**
     * Prints the area menu
     * Menu changes depending on area
     */
    public static void printStartArea()
    {
        System.out.println("\nWelcome to the Demon King's Castle");
        System.out.println("You need to find the 12 blades, but it looks like only 11 are here");
        System.out.println("Your options are as follows:");
        System.out.println("1. Shop");
        System.out.println("2. Stay at Inn for 60L (Heal HP and MP)");
        System.out.println("3. Explore (Battle or find item)");
        System.out.println("4. Boss Battle (Recommended level 30) (Requires Kanzashi)");
        System.out.println("5. Move on to next area (Requires Blood Key)");
        System.out.println("6. " + swordWall);
        System.out.println("7. Show Stats");
        System.out.println("8. Speak to Marie");
    }

    int haveHakari = 0;
    int innVisits = 0;
    /**
     * Runs the area menu, takes in the selection
     */
    public void startArea()
    {
        int haveSwordGem = -1;
        while(haveSwordGem == -1)
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
                    if(hero.getMoney() >= 60)
                    {
                        if(innVisits == 1)
                        {
                            System.out.println("Katherine welcomes you to the sick bay and dresses your wounds");
                        }
                        else
                        {
                            System.out.println("Castle sick bay, at your service. Please, rest up here.");
                        }
                        hero.inn(60);
                        if(innVisits == 0)
                        {
                            System.out.println("\"Oh hold up\", the nurse shouts");
                            System.out.println("\"Yeah?\", you ask, quizzically");
                            System.out.println("\"Hey, name's Katherine. Aren't you the hero who set out to defeat the Demon King?\"");
                            System.out.println("\"Umm...N-no?\", you stammer");
                            System.out.println("\"I knew it! Here, you're gonna need this\", she says as she hands you a sword");
                            System.out.println("\"Why are you giving this to me?\"");
                            System.out.println("\"I hate the Demon King. He massacred my entire village and took me as a slave. So, naturally, I'd want him dead\"");
                            System.out.println("\"This looks like an Aberrant Blade. Zantō Namakura, The Beheading sword, The Blunt\", interjects Marie");
                            System.out.println("\"This sword is the sharpest blade in existence. We used it for sugery, but you need it more than us\", says Katherine");
                            System.out.println("\"Thank you very much for this, Katherine. I promise you that I shall not fail in my mission to defeat the Demon King\"");
                            System.out.println("\"Well, in the meantime, I'll be here if you need to be pathced up. Still gotta pay though, it's the rules\"");
                            innVisits++;
                            numOfBlades++;
                            System.out.println("\"That's another Aberrant Blade. " + numOfBlades + " down, " + (12-numOfBlades) + " to go!\"");
                            System.out.println("Press any key + enter to continue");
                            String s = scan.next();
                        }
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
                    if(hero.keyCheck("Kanzashi"))
                    {
                        this.battle(1);
                    }
                    else
                    {
                        System.out.println("\"You probably should beat that doll first\", says Marie,");
                        System.out.println("\"I hear that it's guarding one of the blades\"");
                        System.out.println("\"I'll keep that in mind\", you reply");
                    }
                    break;
                    case 5:
                    if(haveHakari == 0)
                    {
                        System.out.println("You try to push open the door to the next area, but the large door appears to be locked");
                        System.out.println("However, when you try to pull on the handle, it comes right off");
                        System.out.println("\"Um... let's just hope that the Demon King won't be too angry about wrecking his doors\", you say worriedly");
                        System.out.println("\"Hold on, look at the handle. Doesn't look kind of... Hilt-like?\", Marie interjects");
                        System.out.println("\"Oh yeah, it kind of does. And all of these flowers all over it don't fit the aesthetic of the room at\"");
                        System.out.println("\"I think that what you have in your hands is Seitō Hakari, The True Sword, The Scales\"");
                        System.out.println("\"This thing? A sword? But it doesn't even have a blade!\"");
                        System.out.println("\"It's meant to weigh the wielder's heart, and to only cut the user\"");
                        System.out.println("\"And why would anyone make a sword like this?\"");
                        System.out.println("\"Not sure, really. Regardless of why, we should take it and move on\"");
                        haveHakari++;
                        numOfBlades++;
                        System.out.println("\"That's another Aberrant Blade. " + numOfBlades + " down, " + (12-numOfBlades) + " to go!\"");
                        System.out.println("Press any key + enter to continue");
                        String s = scan.next();
                    }
                    else
                    {
                        if(hero.keyCheck("Sword Gem"))
                        {
                            System.out.println("Are you sure? This is the final boss. If you lose here, it's probably over.");
                            String yorn = scan.next();
                            if(yorn.equalsIgnoreCase("y"))
                            {
                                FinalBattle finalBattle = new FinalBattle(hero, lover, text);
                                if(finalBattle.battle())
                                {
                                    haveSwordGem = 1;
                                }
                            }
                        }
                    }
                    break;
                    case 6:
                    this.swordWall();
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
    }

    int haveHari = 0;
    public void search()
    {
        if(haveHari == 0)
        {
            this.event();
        }
        else
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
    }

    public void event()
    {
        int eventType = (int)(Math.random()*6) + 1;
        if (haveHari == 0)
        {
            System.out.println("You wander around the castle a bit, and stumble across a cozy-looking room");
            System.out.println("\"This place seems strangely... soothing. What with the fireplace and comfy chairs\"");
            System.out.println("You scan the room and see something strange on the mantle");
            System.out.println("\"Hey , Marie, get a load of this.\", you call out as you pick up what was on the mantle");
            System.out.println("\"What is it?\", Marie answers");
            System.out.println("\"This sword. It's really thin and see-though. I think it's made of glass. Who would use this?\"");
            System.out.println("\"Someone who wants to use an Aberrant Blade. That's Hakutō Hari, The Thin sword, The Needle\"");
            System.out.println("\"Seriously? This super thin glass sword is a sword of legend? I guess we better take it then\"");
            System.out.println("\"Yes, and do be careful with it. It is very fragile\"");
            haveHari++;
            numOfBlades++;
            System.out.println("\"That's another Aberrant Blade. " + numOfBlades + " down, " + (12-numOfBlades) + " to go!\"");
            System.out.println("Press any key + enter to continue");
            String s = scan.next();
        }
        else
        {
            switch(eventType)
            {
                case 1:
                System.out.println("You wandered around the castle for a bit and got a feel for the area");
                hero.gainEXP((int)(Math.random()*24) + 10);
                break;
                case 2:
                System.out.println("While meandering around the area, you found some money on the ground");
                hero.pickUp((int)(Math.random()*41) + 10);
                break;
                case 3:
                System.out.println("You decided to nap an empty room in the far corner of the castle");
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
    }

    int visits = 0;
    int haveTsurugi = 0;
    String altar = "Investigate Altar";
    /**
     * The gimmick for this area is collecting 11 of the blades and placing them on the wall
     * The altar will place the blades for you, and also turn them into the Sword Gem
     * Have *Inspect Altar* be an option until selected, then switch to *Place swords*
     * Dont forget, Tsurugi is 1000 swords so that's why there's 1010 spaces (1000 swords + 10 other blades)
     * Sword Gem will grant the holder the abilities of all of the swords (Which is why you can still wear the armor)
     */
    public void swordWall()
    {
        swordWall = "The Swordwall";
        if(visits == 0)
        {
            text.swordWall();
            visits++;
        }
        System.out.println("Before you stands a sizable wall with what appears to be 1010 indentations");
        System.out.println("A structure that resembles an altar with strange writing is sitting in the middle of the room");
        if(haveTsurugi == 0)
        {
            System.out.println("In the corner of the room there appears to be a large bag full of red things");
        }
        int leave = -1;
        this.printSwordMenu();
        while(leave == -1)
        {
            try
            {
                int action = scan.nextInt();
                switch(action)
                {
                    case 1:
                    this.altar();
                    break;
                    case 2:
                    leave++;
                    break;
                    case 3:
                    if(haveTsurugi == 0)
                    {
                        haveTsurugi++;
                        numOfBlades++;
                        System.out.println("\"So, what's the deal with this big bag?\", you think out loud");
                        System.out.println("\"Well, you could go over to it and open it to find out\", responds Marie");
                        System.out.println("\"Fine, maybe I will\"");
                        System.out.println("You walk over to the bag and take a peek inside");
                        System.out.println("\"There's a lot of swords with red sheathes in here.\", you report");
                        System.out.println("\"Red sheathes? A lot of swords? That's one of the Aberrant Blades!\"");
                        System.out.println("\"Come on, is it in the bag and I have to guess to find it? Because that's lame\"");
                        System.out.println("\"No, all 1000 of those swords are one of the blades. Sentō Tsurugi, The Thousand Sword, The Sword\"");
                        System.out.println("\"Are you serious. That...doesn't even make sense\"");
                        System.out.println("\"Hey, I don't make the rules\"");
                        System.out.println("\"That's another Aberrant Blade. " + numOfBlades + " down, " + (12-numOfBlades) + " to go!\"");
                        System.out.println("Press any key + enter to continue");
                        String s = scan.next();
                    }
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
    }

    public void printSwordMenu()
    {
        System.out.println("1. " + altar);
        System.out.println("2. Leave");
        if(haveTsurugi == 0)
        {
            System.out.println("3. Investigate Bag");
        }
    }

    static int altarVisits = 0;
    static int oldNum = 1;
    public void altar()
    {
        if(altarVisits == 0)
        {
            text.altar();
        }
        else
        {
            if(numOfBlades == 11)
            {
                System.out.println("You place the remaining Blades on the altar");
                System.out.println("You quickly turn away from the imminent flash of light");
                System.out.println("\"I guess that's the last of them. I wonder what's gonna happen\", you say");
                System.out.println("\"Not sure, but this time it's taking way longer than before\", replies Marie");
                System.out.println("Eventually, the light stops and on the altar rests a small orb-like gem");
                System.out.println("\"What would this be?\", you ask");
                System.out.println("\"I thnk it's every sword crystalized into some sort of power gem\", answers Marie");
                System.out.println("\"Which means?\"");
                System.out.println("\"As lon as you hold that gem, you get the benefits and can manifest each blade, other than the 12th\"");
                System.out.println("\"That's pretty sweet. So now we move on to defeating ther Demon King?\"");
                System.out.println("\"Indeed\"");
                hero.keyPickUp("Sword Gem");
            }
            else if (!(oldNum == numOfBlades))
            {
                System.out.println("You place the Blades that you have on the altar");
                System.out.println("You quickly turn away from the imminent flash of light and wait for it to pass");
                System.out.println("You turn around to see the blades embedded in their respective places in the wall");
                System.out.println("\"There's only " + (11 - numOfBlades) + " blades left to place in the wall\"");
                oldNum = numOfBlades;
            }
            else
            {
                System.out.println("There's no reason to do that");
            }
        }
    }

    String sword = "Large, Blunt Stone Sword(+2 Str) - 520L";
    String armor = "Full Suit of Armor with an Ocean motif(+2 Def) - 520L";
    String book = "Goetia(+2 Skl) - 520L";
    int haveSaw = 0;
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
                    if(hero.getMoney() >= 520)
                    {
                        if(!(sword.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(520, 1, 2);
                            System.out.println("You bought the Large, Blunt Stone Sword! Str went up by 2");
                            System.out.println("You are barely able to carry the thing, when suddenly it starts glowing");
                            System.out.println("\"Sōtō Kanazuchi\", Marie says, \"The Double Sword, The Hammer\"");
                            numOfBlades++;
                            System.out.println("\"That's another Aberrant Blade. " + numOfBlades + " down, " + (12-numOfBlades) + " to go!\"");
                            sword = "SOLD";
                            System.out.println("Press any key + enter to continue");
                            String s = scan.next();
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
                    if(hero.getMoney() >= 520)
                    {
                        if(!(armor.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(520, 2, 2);
                            System.out.println("You bought the Full Suit of Armor with an Ocean motif! Def went up by 2");
                            System.out.println("You start to put the armor on, when suddenly it starts glowing");
                            System.out.println("\"Zokutō Yoroi\", Marie says, \"The Bandit Sword, The Armor\"");
                            numOfBlades++;
                            System.out.println("\"That's another Aberrant Blade. " + numOfBlades + " down, " + (12-numOfBlades) + " to go!\"");
                            armor = "SOLD";
                            System.out.println("Press any key + enter to continue");
                            String s = scan.next();
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
                    if(hero.getMoney() >= 520)
                    {
                        if(!(book.equalsIgnoreCase("SOLD")))
                        {
                            hero.buy(520, 3, 2);
                            System.out.println("You bought the Book! Skl went up by 2");
                            System.out.println("Suddenly, the book starts glowing!");
                            System.out.println("You start to think that it's another Aberrant Blade, but the book stops glowing");
                            System.out.println("\"That was strange\", you say out loud. You open the book and something falls out");
                            System.out.println("A lightning bolt shaped dagger-like weapon lays on the ground");
                            System.out.println("\"Akutō Bita\", marie says, \" The Evil Sword, The Worthless\"");
                            System.out.println("\"What was it doing inside of this book?\", you ask");
                            System.out.println("\"That book is used to summon demons, so I guess the sword is so evil it had to be sealed with demons");
                            System.out.println("You decide not to think too much about it and pick up the dagger");
                            numOfBlades++;
                            System.out.println("\"That's another Aberrant Blade. " + numOfBlades + " down, " + (12-numOfBlades) + " to go!\"");
                            book = "SOLD";
                            System.out.println("Press any key + enter to continue");
                            String s = scan.next();
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
                        hero.buy(170, 1, 0);
                        if(haveSaw == 0)
                        {
                            System.out.println("\"I heard that the Aberrant Blades are scattered all over this place. Quite a few in some weird places, too.\"");
                            System.out.println("\"What do you mean?\", you inquire");
                            System.out.println("\"What I mean is that you really want to look around a lot. Like perhaps here in this store, like maybe this blade here\"");
                            System.out.println("Anna hands you a wooden sword with a small floral mark and a yellowish streak");
                            System.out.println("\"Oh come on\", you start, \"There's no way-\"");
                            System.out.println("Suddenly, the sword begins to glow in your hands");
                            System.out.println("\"Seriously? This is just a regular wooden sword!\"");
                            System.out.println("\"No, that's Ōtō Nokogiri, The King Sword, The Saw. That one's on the house\"");
                            System.out.println("\"Wait, do you have the others?\"");
                            System.out.println("\"Maybe I do, maybe I don't. You'll have to buy them to find out\", Anna smiles mischeviously");
                            numOfBlades++;
                            haveSaw++;
                            System.out.println("\"That's another Aberrant Blade. " + numOfBlades + " down, " + (12-numOfBlades) + " to go!\"");
                            System.out.println("Press any key + enter to continue");
                            String s = scan.next();
                        }
                        else
                        {
                            System.out.println("\"I heard that the Aberrant Blades are scattered all over this place. Quite a few in some weird places, too.\"");
                            System.out.println("\"What do you mean?\", you inquire");
                            System.out.println("\"What I mean is that you really want to look around a lot for the blades.\"");
                        }
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
        Enemy6 enemy = new Enemy6();
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
        Enemy6 enemy = new Enemy6(boss);
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
                    System.out.println(enemy.name + " quickly eats its rations! Healed for " + enemy.heal());
                    break;
                    case 3:
                    damage = enemy.strongAttack();
                    System.out.println(enemy.name + " blasts " + hero.getName() + " with both guns");
                    System.out.println(hero.getName() + " took " + damage + " damage!");
                    break;
                    default:
                    System.out.println(enemy.name + " does some cool gun tricks");
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
            hero.keyPickUp2("Entō Jū");
            numOfBlades++;
            System.out.println("\"That's another Aberrant Blade. " + numOfBlades + " down, " + (12-numOfBlades) + " to go!\"");
            System.out.println("Press any key + enter to continue");
            String s = scan.next();
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
        Enemy6 enemy = new Enemy6(boss);
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
                    System.out.println(enemy.name + " repairs itself using some rubble from the surroundings. Healed for  " + enemy.heal());
                    break;
                    case 3:
                    damage = enemy.strongAttack();
                    System.out.println(enemy.name + " slashes " + hero.getName() + " with its many bladed limbs");
                    System.out.println(hero.getName() + " took " + damage + " damage!");
                    break;
                    default:
                    System.out.println(enemy.name + " taunts" + hero.getName() + " with weird, mechanical laughter");
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
            hero.keyPickUp("Kanzashi");
            numOfBlades++;
            System.out.println("\"That's another Aberrant Blade. " + numOfBlades + " down, " + (12-numOfBlades) + " to go!\"");
            System.out.println("Press any key + enter to continue");
            String s = scan.next();
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
        if(!(hero.keyCheck("Kanzashi")))
        {
            System.out.println("Marie: \"I think the toy room is a giant Dollhouse, but it's not pretend. There's a killer doll in there as well as a blade\"");
        }
        else if((hero.keyCheck("Kanzashi")) && !(hero.keyCheck("Entō Jū")))
        {
            System.out.println("Marie: \"Oh, you got The Hairpin. Good, now you can open that locked door.\"");
        }
        else if(hero.keyCheck("Entō Jū"))
        {
            System.out.println("\"We should probably go check out what is up with that altar thing\"");
        }
        else
        {
            System.out.println("Marie: \"What are we even doing here still?\"");
        }
    }
}

class Enemy6
{
    Hit hit = new Hit();
    int maxhp, hp, money, exp, maxmp, mp;
    Item item, fail;
    String name;
    public Enemy6()
    {
        maxhp = (int)(Math.random()*25) + 150;
        hp = maxhp;
        exp = (int)(Math.random()*20) + 70;
        money = (int)(Math.random()*25) + 110;
        int named = (int)(Math.random()*5) + 0;
        fail = new Item("nothing", 0);
        switch(named)
        {
            case 1:
            name = "Castle Redguard";
            item = new Item("Curved Sword", 120);
            break;
            case 2:
            name = "Risen Gaurd";
            item = new Item("Medium Bullion", 115);
            break;
            case 3:
            name = "Court Jester";
            item = new Item("Firey Fool's Hat", 140);
            break;
            case 4:
            name = "Duke Camel";
            item = new Item("Royal Spit", 120);
            break;
            default:
            name = "Rook Golem";
            item = new Item("Castle Bricks", 110);
            break;
        }
    }

    public Enemy6(int boss)
    {
        name = "Elite Ninja Marksman";
        money = 1600;
        exp = 600;
        maxhp = 900;
        hp = maxhp;
        maxmp = 160;
        mp = maxmp;
    }

    public Enemy6(String miniboss)
    {
        name = "Kanzashi";
        money = 1500;
        exp = 500;
        maxhp = 800;
        hp = maxhp;
        maxmp = 160;
        mp = maxmp;
    }

    public void display()
    {
        if((name.equalsIgnoreCase("")) || (name.equalsIgnoreCase("Kanzashi")))
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
        if(name.equalsIgnoreCase("Elite Marksman"))
        {
            return 118;
        }
        else if(name.equalsIgnoreCase("Kanzashi"))
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
