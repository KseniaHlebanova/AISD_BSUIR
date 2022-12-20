package by.it.group151001.hlebanova.lesson09;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {
    private class Node{
        Object info;
        Node next;
        Node(Object info, Node next){
            this.info = info;
            this.next = next;
        }
    }
    private Node Head = new Node(null, null);
    @Override
    public boolean add(T info){
        Node temp = new Node(info, null);
        if(Head== null){
            Head= temp;
            return true;
        }
        if(!contains(info)){
            Node t = Head;
            while(t.next != null){
                t = t.next;
            }
            t.next = temp;
            return true;
        } else return false;

    }

    public boolean remove(Object item){
        Node t = Head;
        while (t.next != null && t.next.info != item)
            t = t.next;
        if (t.next == null)
            return false;
        t.next = t.next.next;
        return true;

    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('[');

        Node t = Head;
        while (t != null){
            result.append(t.info);
            if (t.next != null)
                result.append(", ");
            t = t.next;
        }
        result.append(']');
        return result.toString();
    }

    public int size() {
        int count = 0;
        Node t = Head;
        if(t == null) return count;
        else{
            while (t.next != null){
                count++;
                t = t.next;
            }
            return count;
        }

    }


    public boolean contains(Object item) {
        Node temp = Head;
        while (temp.next != null) {
            if (item != null && temp.next.info != null) {
                if (temp.next.info.equals(item)){
                    return true;
                }
            }
            if (temp.next.info == item) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if(Head.next != null){
            return false;
        } else return true;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }



    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean result = true;
        for(T item : c) {
            result = add(item);
        }
        return result;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        boolean result = true;
        for(Object item : c) {
            result = contains(item);
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = true;
        for(Object item : c) {
            result = remove(item);
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        Head = null;
    }

}
