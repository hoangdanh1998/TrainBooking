package SinglyLinkedList;

public class IntSLLNode <T extends Comparable<T>>{

    public T info;
    public IntSLLNode next;

    public IntSLLNode() {}
    
    public IntSLLNode(T i) {
        this(i, null);
    }

    public IntSLLNode(T i, IntSLLNode n) {
        info = i;
        next = n;
    }
    
    
}
