package SinglyLinkedList;

import java.util.Comparator;

public class IntSLList<T extends Comparable<T>> {

    protected IntSLLNode<T> head, tail;

    public IntSLList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addLast(T el) {
        IntSLLNode<T> q = new IntSLLNode(el);
        if (!isEmpty()) {
            tail.next = q;
            tail = q;
        } else {
            head = tail = q;
        }
    }

    //Add vao vi tri dau tien cua danh sach lien ket
    public void addFirst(T el) {
        IntSLLNode<T> q = new IntSLLNode(el);
        if (!isEmpty()) {
            q.next = head;
            head = q;
        } else {
            head = tail = q;
        }
    }

    public void printAll() {
        IntSLLNode<T> p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
    }

    //Add gia tri el vao vi tri pos
    public void addPos(int pos, T el) {
        int i = 0;
        IntSLLNode<T> tmp = head;
        if (pos < 0 || pos >= size()) {
            System.out.println("Can't add in the SLL");
        } else {
            IntSLLNode<T> p = new IntSLLNode(el);
            if (pos == 0) {
                addFirst(el);
            } else {
                //Den vi tri pos-1
                while (i < pos - 1) {
                    i++;
                    tmp = tmp.next;
                }
                //Chen node p vao vi tri pos        
                p.next = tmp.next;
                tmp.next = p;
            }
        }

    }

    //Tra ve gia tri o vi tri pos
    public T get(int pos) {
        IntSLLNode<T> p = head;
        int count = 0;
        if ((pos < 0) || (pos > size())) {

        } else {
            while (count != pos) {
                p = p.next;
                count++;
            }
        }

        return p.info;

    }

    //Tra ve vi tri cua gia tri el trong danh sach lien ket
    public int indexOf(T el) {
        IntSLLNode<T> p = head;
        int pos = 0;
        while (p != null) {
            if (p.info == el) {
                return pos;
            }
            p = p.next;
            pos++;

        }

        return -1;
    }

    //Kich co cua danh sach lien ket
    public int size() {
        int count = 0;
        IntSLLNode<T> p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        return count;
    }

    //Xoa phan tu o dau danh sach
    public T removeFirst() { // delete the head and return its info;
        T el = head.info;
        if (head == tail) // if only one node on the list;
        {
            head = tail = null;
        } else {
            head = head.next;
        }
        return el;
    }

    //Xoa phan tu o cuoi danh sach    
    public T removeLast() { // delete the tail and return its info;
        T el = tail.info;
        if (head == tail) // if only one node on the list;
        {
            head = tail = null;
        } else { // if more than one node on the list,
            IntSLLNode<T> tmp; // find the predecessor of tail;
            for (tmp = head; tmp.next != tail; tmp = tmp.next);
            tail = tmp; // the predecessor of tail becomes tail;
            tail.next = null;
        }
        return el;
    }

    //Xoa phan tu o vi tri pos
    public T remove(int pos) {
        T infor = null;
        if (pos > (size() - 1) || pos < 0) {
            return infor;
        } else {
            int count = 0;
            IntSLLNode<T> tmp = head;
            while (count != (pos - 1)) {
                count++;
                tmp = tmp.next;
            }
            infor = (T) tmp.next.info;
            tmp.next = tmp.next.next;
            return infor;
        }
    }

    //Xoa het danh sach lien ket
    public void removeAll() {
        head = tail = null;
    }

    public void sort(Comparator myComperator) {
        for (IntSLLNode<T> thatNode = head; thatNode != null; thatNode = thatNode.next) {
            for (IntSLLNode<T> thisNode = thatNode; thisNode != null; thisNode = thisNode.next) {
                if (myComperator.compare(thisNode.info, thatNode.info) < 0) {
                    //if (thisNode.info.compareTo(thatNode.info) < 0) {
                    T data = thisNode.info;
                    thisNode.info = thatNode.info;
                    thatNode.info = data;
                }
            }
        }
    }

}
