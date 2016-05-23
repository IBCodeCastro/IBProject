import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * FourthTemple is the fourth area with a navigational menu
 * The gimmick here is a shrine that you have to pay to fix
 * Requires a hefty sum that can be easily obtained using the money alrady obtained and through enemies
 * Enemies drop at a minimum 75L and at a maximum 100, and you can sell the items for about as much
 * Features a miniboss that you have to fight in order to fight the main area boss
 * Miniboss drops most of the money that was put into the shrine (Just to be nice)
 * 
 * Tyler Castro
 * Verson 1.2
 */
public class FourthTemple
{
    Hero hero;
    Lover lover;
    Text text;
    Scanner scan = new Scanner(System.in);

    /**
     * Constructor, gets passed the Hero, Lover, and Text classes from the previous area
     */
    public FourthTemple(Hero h, Lover l, Text t)
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
        System.out.println("\nWelcome to the Temple of the Divine");
        System.out.println("Your options are as follows:");
        System.out.println("1. Shop");
        System.out.println("2. Stay at Inn for 40L (Heal HP and MP)");
        System.out.println("3. Explore (Battle or Event)");
        System.out.println("4. Boss Battle (Recommended level 20) (Requires Corrupt Claw)");
        System.out.println("5. Move on to next area (Requires Divine Blessing)");
        System.out.println("6. Pray at Shrine");
        System.out.println("7. Show Stats");
        System.out.println("8. Speak to Marie");
    }

    /**
     * Runs the area menu, takes in the selection
     */
    public void startArea()
    {
        int haveBlessing = -1;
        while(haveBlessing == -1)
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
                    if(hero.getMoney() >= 40)
                    {
                        System.out.println("You can heal your wounds and your spirit here...for a price");
                        hero.inn(40);
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
                    if(hero.keyCheck("Corrupt Claw"))
                    {
                        this.battle(1);
                    }
                    else
                    {
                        System.out.println("\"You're not allowed in there right now, the corruption has spread and we have locked that door to protect Her Ladyship\", says the priestess");
                        System.out.println("\"Now if someone were to, I don't know, get rid of the corruption then maybe we'd let them in to recieve a blessing?\"");
                        System.out.println("\"Oh I really do need to stop thinking out loud\"");
                    }
                    break;
                    case 5:
                    if(hero.keyCheck("Divine Blessing"))
                    {
                        System.out.println("Are you sure? There's no coming back. y or n");
                        String yorn = scan.next();
                        if(yorn.equalsIgnoreCase("y"))
                        {
                            haveBlessing = 1;
                        }
                    }
                    break;
                    case 6:
                    this.pray();
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
            FifthHell hell = new FifthHell(hero, lover, text);
            text.templeToHell();
            hell.startArea();
        }
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
            System.out.println("You wandered around the temple gates and got a feel for the area");
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
            System.out.println("You sat down and remembered your time together with " + lover.name + ", and reaffirmed your determination");
            break;
        }
    }
    int firstVisit = 0;
    int donated = 0;
    int bossDeath = 0;
    public void pray()
    {
        if(firstVisit == 0)
        {
            System.out.println("\nAs you step towards the shrine, a priestess runs out to greet you");
            System.out.println("\"Hello, traveler! My name is Lina and I am a priestess at this shrine\"");
            System.out.println("You survey the shrine, but it looks like it hasn't had a caretaker for quite some time");
            System.out.println("\"It may not look like much, but it's a start. We just need some donations and it could be good as new!");
            System.out.println("\"How much do you need?\", you ask Lina");
            System.out.println("\"Oh, about 1450L should do\"");
            firstVisit++;
        }
        else if (donated < 1450)
        {
            System.out.println("Lina: \"Oh, welcome back to the shrine! Like the progress? I think it looks beautiful\"");
        }
        else
        {

        }
        int stay = 0;
        while(stay == 0)
        {
            try
            {
                System.out.println("Money Donated: " + donated + "/1450");
                if(bossDeath == 0)
                {
                    if(donated >= 1450)
                    {
                        System.out.println("\"Woah! You did it all by yourself! You're amazing! You're so cool, I'll probably name my firstborn after you!\", Lina excitedly exclaims");
                        System.out.println("\"That might be a bit weird, but at least it's fini-\"");
                        System.out.println("Suddenly, you are interrupted by a loud tremor and the ground shaking");
                        System.out.println("\"Lina! I figured out what that shrine was used for!\", a panicking woman screams");
                        System.out.println("\"It wasn't a praying shrine, it was a sealing shrine for the surrounding corruption!\"");
                        System.out.println("\"What does that have to do with this?!\", Lina shouts");
                        System.out.println("\"Your remodeling has broken the seal! I'll do what I can to stall the awakening but someone must defeat it!\"");
                    }
                    else if(donated >= 1160)
                    {
                        System.out.println("You don't have to do much looking around to see that the shrine is almost in its original, beautiful condition");
                    }
                    else if(donated >= 870)
                    {
                        System.out.println("You look at the shine to see how the repairs are comming along. The offering box appears to have been fixed, as have all the walls");
                    }
                    else if(donated >= 580)
                    {
                        System.out.println("You take a walk around the shrine and see how the foliage has been trimmed neatly, and the grounds cleaned");
                    }
                    else if(donated >= 290)
                    {
                        System.out.println("You glance around the shrine a bit and notice how the collapsed roof has been fixed");
                    }
                    else
                    {
                        System.out.println("The shrine still looks abandoned, but you can tell that Lina has spent some time cleaning up");
                    }
                }
                System.out.println("\"So, would you like to make a donation? Or are you Just here to chat?\", Lina teases\n");
                System.out.println("1. Donate");
                System.out.println("2. Chat");
                System.out.println("3. Leave");
                if(donated >= 1450)
                {
                    System.out.println("4. Fight Corruption");
                }
                int act = scan.nextInt();
                switch(act)
                {
                    case 1:
                    System.out.println("\"Oh good! So, how much are you gonna donate?\"");
                    int add = scan.nextInt();
                    donated += add;
                    System.out.println("\"May the Divine smile upon you! Also me. I am smiling at you. Not sure if that counts for anything\"");
                    break;
                    case 2:
                    //Random phrase generator (Like a generic NPC typ of phrase, make like one meta ("I always say the same things, I woder why")
                    int speak = (int)(Math.random()*6 + 1);
                    switch(speak)
                    {
                        case 1:
                        System.out.println("\"The weather is lovely today. It is everyday. This place has like a Sunny-All-The-Time-But-Not-Too-Hot Spell\"");
                        break;
                        case 2:
                        System.out.println("\"You know, I've always wondered why we always say the same things. Must be a part of the Demon King's curse or something\"");
                        break;
                        case 3:
                        System.out.println("\"Oh, " + hero.getName() + ", you look very nice... I think. I don't know what's in style these days, but I'm sure armor is the new \"it\" look\"");
                        break;
                        case 4:
                        System.out.println("\"Hey, if you ever see a knight with long blond hair, probably wearing blue armor, tell him that Lina thinks that we should go adventuring again.\"");
                        break;
                        case 5:
                        System.out.println("\"You know, sometimes I hear strange noises comming from inside her Ladyship's chamber. Somtimes growling, soemtimes scratching\"");
                        break;
                        default:
                        System.out.println("\"You know, back in my day, I was quite the sorceress. I even defeated a Dark Lord. At least, that's what I dreampt last night\"");
                        break;
                    }
                    System.out.println("\n");
                    break;
                    case 3:
                    stay = 1;
                    break;
                    case 4:
                    if((donated >= 1450)&&(bossDeath == 0))
                    {
                        this.battle(9);
                    }
                    else if(bossDeath == 1)
                    {
                        System.out.println("You've already beaten the boss");
                    }
                    else
                    {

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

    String sword = "Crusader's Blade(+2 Str) - 420L";
    String armor = "Manasteel Armor(+2 Def) - 420L";
    String book = "Book of the Divine Will(+2 Skl) - 420L";
    public void shop()
    {
        int leave = -1;
        int action;
        System.out.println("You enter the shop and see a priestess shopkeeper with a nametag that reads \"St. Anna\"");
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
                            System.out.println("You bought the Crusader's Blade! Str went up by 2");
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
                            System.out.println("You bought the Manasteel Armor! Def went up by 2");
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
                    System.out.println("\"Depends. Would you like to make an unrelated donation of 100L to my shop?(y or n)\"");
                    String yorn = scan.nextLine();
                    if(yorn.equalsIgnoreCase("y"))
                    {
                        System.out.println("\"Word on the street is that Lina's shrine is cursed, and the remodel will release it\"");
                        System.out.println("\"Although, if someone were to defeat the curse, I bet the corruption will disappear\"");
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
        Enemy4 enemy = new Enemy4();
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
        Enemy4 enemy = new Enemy4(boss);
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
            text.getBlessing();
            hero.keyPickUp("Divine Blessing");
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
        Enemy4 enemy = new Enemy4(boss);
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
                    System.out.println(enemy.name + " absorbs the surrounding darkness. Healed for  " + enemy.heal());
                    break;
                    case 3:
                    damage = enemy.strongAttack();
                    System.out.println(enemy.name + " strikes " + hero.getName() + " with its shadows");
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
            hero.keyPickUp("Corrupt Claw");
            hero.levelUp();
        }
        else
        {
            int lost = (int)(hero.getMoney()*.1);
            System.out.println("The last thing you can see before blacking out is Marie dragging you somewhere");
            System.out.println("Lost " + lost + "L");
            hero.inn(lost);
        }
        bossDeath++;
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
        if(!(hero.keyCheck("Corrupt Claw")))
        {
            System.out.println("Marie: \"Have you tried praying yet? I hear that they use the money for renovations\"");
        }
        else if((hero.keyCheck("Corrupt Claw")) && !(hero.keyCheck("Divine Blessing")))
        {
            System.out.println("Marie: \"Great! With proof that we've purified the land we should now be able to enter Her Ladyship's chamber\"");
        }
        else
        {
            System.out.println("Marie: \"Now that you've got the blessing we can move on to the next area. Or do that 'grinding' thing\"");
        }
    }
}

class Enemy4
{
    Hit hit = new Hit();
    int maxhp, hp, money, exp, maxmp, mp;
    Item item, fail;
    String name;
    public Enemy4()
    {
        maxhp = (int)(Math.random()*25) + 80;
        hp = maxhp;
        exp = (int)(Math.random()*20) + 25;
        money = (int)(Math.random()*25) + 70;
        int named = (int)(Math.random()*5) + 0;
        fail = new Item("nothing", 0);
        switch(named)
        {
            case 1:
            name = "Mega Worm";
            item = new Item("Hearts on a String", 80);
            break;
            case 2:
            name = "Bellowing Bird";
            item = new Item("Golden Seed", 75);
            break;
            case 3:
            name = "Evil Ent";
            item = new Item("Corrupted Bark", 100);
            break;
            case 4:
            name = "Corrupt Camel";
            item = new Item("Jar of Purple Spit", 80);
            break;
            default:
            name = "Bunnicula";
            item = new Item("Rabbit Fang", 70);
            break;
        }
    }

    public Enemy4(int boss)
    {
        //Name is a pun because she attacks with scissors
        name = "Her Ladysnip";
        money = 1200;
        exp = 320;
        maxhp = 600;
        hp = maxhp;
        maxmp = 125;
        mp = maxmp;
    }

    public Enemy4(String boss)
    {
        name = "Grand Corruption";
        money = 1020;
        exp = 320;
        maxhp = 520;
        hp = maxhp;
        maxmp = 125;
        mp = maxmp;
    }

    public void display()
    {
        if((name.equalsIgnoreCase("Her Ladysnip")) || (name.equalsIgnoreCase("Grand Corruption")))
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
        if(name.equalsIgnoreCase("Her Ladysnip"))
        {
            return 95;
        }
        else if(name.equalsIgnoreCase("Grand Corruption"))
        {
            return 87;
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
            return 130;
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
            hp += 80;
            if(hp > maxhp)
            {
                hp = maxhp;
            }
            return 80;
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
