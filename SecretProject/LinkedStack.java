// ****************************************************************
//   LinkedStack.java
//   A linked implementation of an Object stack class with operations push, 
//   pop, and isEmpty and isFull.
// ****************************************************************
public class LinkedStack implements StackADT
{
    private Node top;             // reference to top of stack
    // --------------------------------------------------
    // Constructor -- initializes top 
    // --------------------------------------------------
    public LinkedStack()
    {
        top = null;
    }
    // --------------------------------------------------
    // Adds element to top of stack if it’s not full, else 
    // does nothing.
    // --------------------------------------------------
    public void push(Object val)
    {
        if(this.isEmpty())
        {
            Node temp = new Node(val);
            top = temp;
        }
        else
        {
            Node temp = new Node(val);
            temp.setNext(top);
            top = temp;
        }
    }
    // --------------------------------------------------
    // Removes and returns value at top of stack.  If stack
    // is empty returns null.
    // --------------------------------------------------
    public Object pop()
    {
        Node temp = top;
        top = top.getNext();
        return temp.getElement();
    }
    // --------------------------------------------------
    // Returns true if stack is empty, false otherwise.
    // --------------------------------------------------
    public boolean isEmpty()
    {
        return top == null;
    }
    // --------------------------------------------------
    // Returns true if stack is full, false otherwise.
    // --------------------------------------------------
    public boolean isFull()
    {
        return false;
    }
}