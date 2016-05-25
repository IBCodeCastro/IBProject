import java.util.InputMismatchException;
public class TextTesting
{
    public static void main(String[]args)
    {
        Hero hero = new Hero("Tom");
        Text text = new Text();
        int clearCondition = 1;
        Endless endless = new Endless(hero, text);
        int visits = 0;
        StackADT stack = new LinkedStack();        
        int x = 15532;
        while(x > 15411)
        {
            stack.push(x);
            x -= 15;
        }
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
                System.out.println(clearCondition);
                text.endlessIntro();
                endless.endlessStart();
                text.timeLoop(stack.pop());
                text.endlessFalseEnd(clearCondition);
                if(clearCondition == 8)
                {
                    text.endlessFinale();
                    System.out.println("Pretend like a battle is happening");
                }
                clearCondition++;
            }
            catch(InputMismatchException youDoneGoofed)
            {
                System.out.println("Unless specified, please input numbers only");
            }
        }
    }
}
