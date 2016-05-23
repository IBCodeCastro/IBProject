
/**
 * Write a description of class StackTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackTest
{
    public static void main(String[] args)
    {
        StackADT stack = new LinkedStack();
        Text text = new Text();
        int x = 15532;
        while(x > 15411)
        {
            stack.push(x);
            x -= 15;
        }
        while (!stack.isEmpty()) 
            text.timeLoop(stack.pop()); 
    }
}
