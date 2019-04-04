import java.util.*;

public class LinkedList<E>{

    private int length;
    private Node start,end;

    public LinkedList(){
      length = 0;
    }

    public int size() {
      return length;
    }

    public void clear(){
      start = null;
      end = null;
      length = 0;
    }

    public boolean add(E value){
      if (start == null){
        start = new Node(value, null, null);
        end = start;
      }
      else if (end == start){
        end = new Node(value, null, start);
        start.setNext(end);
      }
      else{
        Node temp = new Node(value, null, end);
        end.setNext(temp);
        end = temp;
      }
      length++;
      return true;
    }


    public E removeFront(){
      if (size() == 0){
        throw new NoSuchElementException();
      }
      E temp = start.getData();
      if (size() == 1){
        clear();
        return temp;
      }
      start = start.next();
      start.setPrev(null);
      length--;
      return temp;
    }

     public void extend(LinkedList<E> other){
       if (size() == 0){
         start = other.start;
         end = other.end;
       }
       else if (other.size() > 0){

         end.setNext(other.start);
         other.start.setPrev(end);
         end = other.end;
       }
       length += other.length;
       other.clear();
     }
  class Node{
    private E data;
    private Node next,prev;
     public Node(E value, Node nexty, Node backy){
       data = value;
       next = nexty;
       prev = backy;
     }

    public Node next() {
      return next;
    }

    public Node prev() {
      return prev;
    }

    public void setNext(Node other) {
      next = other;
    }

    public void setPrev(Node other) {
      prev = other;
    }

    public E getData() {
      return data;
    }

    public E setData(E i){
      E temp = data;
      data = i;
      return temp;
    }


  }

}
