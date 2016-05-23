import java.util.Scanner;
public class AreaLoader
{
    Hero hero;
    Lover lover;
    Text text;
    Scanner scan = new Scanner(System.in);
    public AreaLoader()
    {

    }

    public void load()
    {
        System.out.println("Are you a returning Player? (y/n)");
        String answer = scan.next();
        if(answer.equalsIgnoreCase("y"))
        {

            System.out.println("*---------------------------------------------------*");
            System.out.println("So I see you've returned. Remind me, what is your name?");
            System.out.println("*---------------------------------------------------*");
            String name = scan.nextLine();
            hero = new Hero(name);
            System.out.println("*--------------------------*");
            System.out.println("What was your gender? m or f.");
            System.out.println("*--------------------------*");
            String playerGender = scan.next();
            lover = new Lover(playerGender);
            scan.nextLine();
            System.out.println("*---------------------------------------------*");
            System.out.println("You had a childhood friend. What was " + lover.hisHer + " name?");
            System.out.println("*---------------------------------------------*");
            String loverName = scan.nextLine();
            lover.setName(loverName);
            System.out.println("*----------------------------------------------------*");
            System.out.println("Well then, " + name + ", your quest is about to resume!");
            System.out.println("*----------------------------------------------------*");
            text = new Text(name, lover);
        }
        else
        {
            hero = new Hero("Test");
            lover = new Lover("m");
            text = new Text("Test", lover);
        }
        System.out.println("What is the name of the area you want to return to? The options are:");
        System.out.println("Forest\nCastle\nLabyrinth\nTemple\nHell\nHell Castle\nFinal Battle");
        scan.nextLine();
        String area = scan.nextLine();
        if(area.equalsIgnoreCase("Forest"))
        {
            FirstForest f = new FirstForest(hero, lover, text);
            f.startArea();
        }
        else if(area.equalsIgnoreCase("Castle"))
        {
            SecondCastle f = new SecondCastle(hero, lover, text);
            hero.buyItems(1);
            hero.toLevel(5);
            f.startArea();
        }
        else if(area.equalsIgnoreCase("Labyrinth"))
        {
            ThirdLabyrinth f = new ThirdLabyrinth(hero, lover, text);
            hero.buyItems(2);
            hero.toLevel(10);
            f.startArea();
        }
        else if(area.equalsIgnoreCase("Temple"))
        {
            FourthTemple f = new FourthTemple(hero, lover, text);
            hero.buyItems(3);
            hero.toLevel(15);
            f.startArea();
        }
        else if(area.equalsIgnoreCase("Hell"))
        {
            FifthHell f = new FifthHell(hero, lover, text);
            hero.buyItems(4);
            hero.toLevel(20);
            f.startArea();
        }
        else if(area.equalsIgnoreCase("Hell Castle"))
        {
            SixthHellCastle f = new SixthHellCastle(hero, lover, text);
            hero.buyItems(5);
            hero.toLevel(25);
            f.startArea();
        }
        else
        {
            FinalBattle f = new FinalBattle(hero, lover, text);
            hero.buyItems(6);
            hero.toLevel(30);
            f.battle();
        }
    }
}
