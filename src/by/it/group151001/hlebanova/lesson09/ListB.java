package by.it.group151001.hlebanova.lesson09;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListB<T> implements List<T>{
    private class Node{
        T info;
        Node next;
        Node(T info, Node next){
            this.info = info;
            this.next = next;
        }
    }
    private Node Head = new Node(null, null);
    @Override
    public boolean add(T info){
        Node temp = new Node(info, null);
        if(Head.info == null){
            Head= temp;
            return true;
        }
        Node t = Head;
        while(t.next != null){
            t = t.next;
        }
        t.next = temp;
        return true;
    }
    public Node getI(int index){
        int count = 0;
        Node t = Head;
        while(t != null){
            if(index == count){
                return t;
            }
            t = t.next;
            count++;
        }
        return null;
    }
    public T remove(int index){

        if(index == 0){
            Node del = Head;
            Head = Head.next;
            return del.info;
        }
        Node prevDel = getI(index-1);
        if (prevDel != null ){
            Node del = prevDel.next;
            if(del.next != null){
                prevDel.next = prevDel.next.next;
            }else prevDel.next = null;
            return del.info;
        }else return null;
    }
    @Override
    public T get(int index){
        Node t = getI(index);
        if(t!=null) return getI(index).info;
        else return null;
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
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Node t = Head;
        while (t.next != null)
            t = t.next;

        for(T e : c) {
            Node tmp = new Node(e,null);
            t.next = tmp;
            t = t.next;

        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() { }

    @Override
    public T set(int index, T element) {
        Node t = getI(index);
        if(t == null){
            return null;
        }
        T data = t.info;
        t.info = element;
        return data;
    }

    @Override
    public void add(int index, T element) {
        Node t = new Node(element, null);
        if(index!=0){
            Node prevEl = getI(index - 1);
            t.next = prevEl.next;
            prevEl.next = t;
        } else {
            t.next = Head;
            Head = t;
        }

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
