import java.util.ArrayList;
/**
 * Hero is the class that stores the information about the player
 * Contains many essential methods, such as attack methods and item pickup methods
 * Information includes name, stats, hp, max hp, mp, max mp, and the inventories
 * 
 * Tyler Castro
 * Verson 2.1
 */
public class Hero
{
    Hit hit = new Hit();
    ArrayList<Item> inventory = new ArrayList<Item>();
    ArrayList<String> keyItems = new ArrayList<String>();
    int maxhp, maxmp, hp, mp, exp, maxExp, level, money, str, def, skl;
    private String name;
    /**
     * Constructor, establishes name and base stats
     */
    public Hero(String n)
    {
        maxhp = 50;
        hp = maxhp;
        maxmp = 20;
        mp = maxmp;
        exp = 0;
        maxExp = 10;
        level = 1;
        money = 500;
        name = n;
        str = 5;
        def = 4;
        skl = 2;
    }

    public void setHP(int newHP)
    {
        maxhp = newHP;
        hp = maxhp;
    }

    public void overpower()
    {
        System.out.println("You feel an immense amount of power flow through you");
        maxhp = 999999999;
        hp = maxhp;
        maxmp = 999999999;
        mp = maxmp;
        str += 1000;
        def += 1000;
        skl += 20;
    }

    /**
     * Heals hp and mp to full
     */
    public void inn(int cost)
    {
        System.out.println("HP and MP healed to maximum");
        hp = maxhp;
        mp = maxmp;
        money -= cost;
        if(money < 0)
        {
            money = 0;
        }
    }

    /**
     * Displays the battle screen layout
     */
    public void display()
    {
        System.out.println(name + "\nHP: " + hp + "/" + maxhp + "\nMP: " + mp + "/" + maxmp);
    }

    /**
     * Basic attack, can't miss
     */
    public int attack()
    {
        return hit.crit(str, (7 + skl));
    }

    /**
     * Displays the player's stats
     */
    public void showStats()
    {
        System.out.println(name);
        System.out.println("Level: " + level);
        System.out.println("EXP: " + exp + "/" + maxExp);
        System.out.println("Funds: " + money + "L");
        System.out.println("Str: " + str);
        System.out.println("Def: " + def);
        System.out.println("Skl: " + skl);
    }

    /**
     * Displays the player's stat
     * Includes the new "charm" stat
     */
    public void showStats(int x)
    {
        System.out.println(name);
        System.out.println("Level: " + level);
        System.out.println("EXP: " + exp + "/" + maxExp);
        System.out.println("Funds: " + money + "L");
        System.out.println("Str: " + str);
        System.out.println("Def: " + def);
        System.out.println("Skl: " + skl);
        System.out.println("Charm: 2");
    }

    /**
     * low-accuracy high-damage attack
     * High risk high reward
     * Costs mp
     */
    public int heavyStrike()
    {
        if(hit.hit(75))
        {
            if(mp >= 15)
            {
                mp -= 15;
                return hit.crit(((int)(str*1.5)), (3 + skl));
            }
            else
                return 0;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Lower accuracy than regular attck, less damage than a regular attck, considerably higher crit rate
     * costs mp
     */
    public int swiftStrike()
    {
        if(hit.hit(90))
        {
            if(mp >= 15)
            {
                mp-= 15;
                return hit.crit(((int)(str * .7)), (30 + skl));
            }
            else
            {
                return 0;

            }
        }
        else
        {
            return 0;
        }
    }

    /**
     * Heals the player by a certain amount, maximum is full heal, minimum is 1/10 of max
     * Costs 5 mp
     */
    public int heal()
    {
        if(mp < 5)
        {
            return 0;
        }
        else
        {
            int amount = ((int)(Math.random()*maxhp) + (maxhp/10));
            hp += amount;
            if(hp > maxhp)
            {
                hp = maxhp;
            }
            mp -= 5;
            return amount;
        }
    }

    /**
     * Heals player by a certain amount. maximum is full, minimum is 1/6 of max
     * costs 10 mp
     * replaces heal() after a certain point
     */
    public int heal2()
    {
        if(mp < 10)
        {
            return 0;
        }
        else
        {
            int amount = ((int)(Math.random()*maxhp) + (maxhp/6));
            hp += amount;
            if(hp > maxhp)
            {
                hp = maxhp;
            }
            mp -= 10;
            return amount;
        }
    }

    /**
     * Adds value to specified stat
     * Mainly used in a level up and an equipment upgrade
     */
    public void str(int v)
    {
        str += v;
    }

    /**
     * Adds value to specified stat
     * Mainly used in a level up and an equipment upgrade
     */
    public void def(int v)
    {
        def += v;
    }

    /**
     * Adds value to specified stat
     * Mainly used in a level up and an equipment upgrade
     */
    public void skl(int v)
    {
        skl += v;
    }

    /**
     * Increases stats upon exp reaching a certain point
     * Increases hp by 15
     * Increases mp by 4
     * Increases maxmimum EXP by 10
     * Increases stats by a random specified value
     * Str + 1-3
     * Def + 1-3
     * Skl + 1-2
     */
    public void levelUp()
    {
        if(exp >= maxExp)
        {
            exp = exp%maxExp;
            maxExp += 10;
            int strUp = (int)(Math.random()*3)+1;
            str += strUp;
            int defUp = (int)(Math.random()*3)+1;
            def += defUp;
            int sklUp = (int)(Math.random()*2)+1;
            skl += sklUp;
            maxhp += 15;
            hp = maxhp;
            maxmp += 4;
            mp = maxmp;
            level++;
            System.out.println(name + " leveled up!");
            System.out.println("Str went up by " + strUp);
            System.out.println("Def went up by " + defUp);
            System.out.println("Skl went up by " + sklUp);
        }
        else
        {

        }
    }
    
    public void buyItems(int target)
    {
        for(int x = 1; x <= target; x++)
        {
            str += 2;
            def += 2;
            skl += 2;
        }
    }

    public void toLevel(int target)
    {
        for(int x = 1; x <= target; x++)
        {
            exp = exp%maxExp;
            maxExp += 10;
            int strUp = (int)(Math.random()*3)+1;
            str += strUp;
            int defUp = (int)(Math.random()*3)+1;
            def += defUp;
            int sklUp = (int)(Math.random()*2)+1;
            skl += sklUp;
            maxhp += 15;
            hp = maxhp;
            maxmp += 4;
            mp = maxmp;
            level++;
        }
    }

    /**
     * Picks up an item, stores in AraryList inventory
     */
    public void pickUp(Item item)
    {
        inventory.add(item);
    }

    /**
     * Picks up a key item, stores in AraryList keyItems
     * a key item is an item required to progress through a agme, or just an item that you cannot and should not sell
     */
    public void keyPickUp(String item)
    {
        keyItems.add(item);
        System.out.println(name + " picked up the " + item);
        if(item.equals("Divine Blessing"))
        {
            System.out.println("Your body feels stronger somehow. Must be that blessing");
        }
        else
        {
            System.out.println("The " + item + " feels heavy in your hand. It must have some sort of purpose");
        }	
    }

    /**
     * Picks up a key item, stores in AraryList keyItems
     * a key item is an item required to progress through a agme, or just an item that you cannot and should not sell
     * This variation of keyPickUp is used in HellCastle when you defeat the (mini)boss and pick up the Aberrant Blades
     */
    public void keyPickUp2(String item)
    {
        if(item.equalsIgnoreCase("Entō Jū"))
        {
            keyItems.add(item);
            System.out.println("\"So, what exactly are these anyway?\", you inquire as you walk over to the boss' corpse");
            System.out.println("\"The weapons it used? Those would be handcannons, except they can hold much more ammo\", answers Marie");
            System.out.println("\"Let me guess, these are some more Aberrant Blades?\"");
            System.out.println("\"Yeah, those are Entō Jū, The Flame sword, The Gun\"");
            System.out.println("\"I guess we should take them then\"");
        }
        else
        {
            keyItems.add(item);
            System.out.println("You start to move the doll out of your way to see what was behind it when it starts to glow");
            System.out.println("\"Are you kidding me? The entire doll is a blade?\", you cry out");
            System.out.println("\"Bitō Kanzashi\", Marie says, \"The Delicate Sword, The Hairpin\"");
            System.out.println("\"It wasn't really all that delicate. I mean it had blades on each limb, and one that came out of its mouth\"");
            System.out.println("\"Well, regardless of its delicacy, we've got it at least\"");
        }
    }

    /**
     * Checks the ArrayList keyItems for a specific key item
     * used to check if a player can progress to a point
     */
    public boolean keyCheck(String name)
    {
        int f = 0;
        for(int x = 0; x <keyItems.size(); x++)
        {
            if(name.equalsIgnoreCase((keyItems.get(x))))
            {
                f = 99;
                x = 99;
            }
        }
        if(f == 99)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Checks ArrayList inventory for a certain item
     */
    public boolean invCheck(String name)
    {
        int f = 0;
        for(int x = 0; x <inventory.size(); x++)
        {
            if(name.equalsIgnoreCase(((inventory.get(x)).getName())))
            {
                f = 99;
                x = 99;
            }
        }
        if(f == 99)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Checks ArrayList inventory for a certain item and removes it
     * Intended for fetch quests like "Get me a rabbit fang"
     */
    public void getItem(String name)
    {
        int f = 0;
        for(int x = 0; x <keyItems.size(); x++)
        {
            if(name.equalsIgnoreCase((keyItems.get(x))))
            {
                f = x;
                x = 99;
            }
        }
        inventory.remove(f);
    }

    /**
     * Adds money and exp to the current values
     * used whenever the hero defeats a boss
     */
    public void victory(int m, int e)
    {
        money += m;
        exp += e;
        System.out.println("You win! " + name + " receives " + m + "L and " + e + " EXP!");
    }

    /**
     * Adds money and exp to the current values
     * Picks up an item as well
     * Used when the player defeats a regular enemy
     */
    public void victory(int m, int e, Item item)
    {
        money += m;
        exp += e;
        inventory.add(item);
        System.out.println("You win! " + name + " receives " + m + "L and " + e + " EXP!");
        System.out.println(name + " picked up " + item.getName());
    }

    /**
     * Adds money to the current value
     * Adds an item to the inventory
     */
    public void pickUp(Item item, int v)
    {
        inventory.add(item);
        money += v;
    }

    /**
     * Adds money to the current value
     */
    public void pickUp(int v)
    {
        money += v;
        System.out.println("Received " + v + "L!");
    }

    /**
     * Adds exp to the current value
     */
    public void gainEXP(int e)
    {
        exp += e;
        System.out.println("Gained " + e + " EXP!");
    }

    /**
     * Sells entire inventory
     * Parses through the ArrayList inventory, grabbing the value of an item and removing it from the ArrayList
     * Clears ArrayList inventory
     * Adds the sum to the current money value
     */
    public int sellAll()
    {
        int additional = 0;
        for(int x = inventory.size()-1; x > -1; x--)
        {
            additional += (inventory.get(x)).getValue();
            inventory.remove(x);
        }
        money += additional;
        return additional;
    }

    /**
     * Returns the amount of money the player has
     */
    public int getMoney()
    {
        return money;
    }

    /**
     * Removes cost from the player's current balance
     * Doesn't check if the player has enough, the shop methods do this
     * Adds the item to the inventory
     */
    public void buy(int cost, Item item)
    {
        money -= cost;
        this.pickUp(item);
    }

    /**
     * Removes cost from the player's current balance
     * Doesn't check if the player has enough, the shop methods do this
     * Doesn't add item to inventory, "Equips it"
     * The item increases a specified stat by a specific amount
     * Ex: Iron Sword increases the player's Str by 2
     */
    public void buy(int cost, int stat, int amount)
    {
        money -= cost;
        if(stat == 1)
        {
            this.str(amount);
        }
        else if(stat == 2)
        {
            this.def(amount);
        }
        else if(stat == 3)
        {
            this.skl(amount);
        }
    }

    /**
     * Returns the amount of hp the player has
     */
    public int getHP()
    {
        return hp;
    }

    /**
     * Returns the maximum hp the player can have
     */
    public int getmaxhp()
    {
        return maxhp;
    }

    /**
     * Returns the amount of mp the player has
     */
    public int getMP()
    {
        return mp;
    }

    /**
     * Returns the maximum mp the player can have
     */
    public int getmaxmp()
    {
        return maxmp;
    }

    /**
     * Returns the player's current level
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * Forces the player to take a specified amount of damage
     * Doesn't reduce damage based on Def stat
     */
    public void damage(int damage, int environmental)
    {
        hp -= damage;
        System.out.println("Took " + damage + " damage");
    }

    /**
     * Forces the player to take a specified amount of damage
     * Reduces damage based on Def stat
     */
    public void damage(int damage)
    {
        if(skl > Math.random()*99)
        {

        }
        else
        {
            if((damage - def) < 0)
            {

            }
            else
            {
                hp -= (damage - def);
            }
        }
    }

    /**
     * Checks if the player's hp is less than zero, or dead
     */
    public boolean dead()
    {
        return hp <= 0;
    }

    /**
     * Fully heals the player
     * Doesn't have the message telling the player that they have been healed
     * Intended for the finale, where the player falls but is brought back by something
     */
    public void finale()
    {
        hp = maxhp;
        mp = maxmp;
    }

    /**
     * Returns the character's name
     */
    public String getName()
    {
        return name;
    }
}
