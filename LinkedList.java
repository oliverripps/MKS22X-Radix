public class MyLinkedList{
private int length;
private Node start,end;

public MyLinkedList(){
  start= null;
  end= null;
  length=0;
}

public boolean add(int value){
  if(length!=0){//if there is a list
    Node newend = new Node(end,value,0,null);//setting a new end
    end.setNext(newend);//setting the old end to direct to the new end
    end=newend;
    length++;//increasing the length by one
    return true;
}
  else{//if there is no list
    end=new Node(null,value,0,null);//create one node as end
    start=end;//node is also the start
    length++;
    return true;
  }
}

public int size(){
  return length;
}
public String toString(){
  if (length == 0){//looping through and adding values to a string with commas
      return "[]";
    }
  String str = "[";
  Node current = start;
  while (current.next() != null){
      str += current.getData() + ", ";
      current = current.next();
    }
    return str + end.getData() + "]";
  }

private Node getNthNode(int N){
  Node current=start;
  for(int i=0;i<N;i++){//loop through list untill you reach N
    current=current.next();
  }
  return current;//return Nth Node
}

public Integer get(int index){
  if(index>length || index<0){//if the index is out of bounds, through exception
    throw new IndexOutOfBoundsException();
  }
  return getNthNode(index).getData();//if not, return the value of the node from get nth node

}
public Integer set(int index, Integer value){
  if(index>=0 && index<=length-1){//if the index is in range
    Integer valuebefore;
    Node spot = getNthNode(index);//old node you are replacing value of
    valuebefore=spot.getData();//value of old node
    spot.setData(value);//set the new value
    return valuebefore;//return old value
}
  else{//if the index is out of bounds, through exception
    throw new IndexOutOfBoundsException();}
}

public boolean contains(Integer value){
  for(int i =0;i<size();i++){//while there is still a next node
    if (getNthNode(i).getData()==value){//if the value of any node is the value you are checking for return true
      return true;
    }
  }
  return false;
}


public int indexOf(Integer value){
  Node current=start;
  int indof=-1;//default in case it never triggers
  for(int i =0;current!=null;i++){//looping through all nodes
    if (current.getData()==value){//if its equal, mark value as what node it is
      indof=i;
      }
    current=current.next();
    }
  return indof;//return marked value or -1
  }
public void add(int index, Integer value){
  if(index<0 || index> size()){//if indeces out of range throw exception
    throw new IndexOutOfBoundsException();
  }
  else if(index==size()){//if index is equal to size, use regular added
    add(value);
  }
  else if(index==0){
    Node newstart= new Node(null,value,this.start);
    start.setPrev(newstart);
    start=newstart;
    length++;
  }
  else{
    Node previous= getNthNode(index-1);//before
    Node current= getNthNode(index);//current
    Node temporary= new Node(getNthNode(index-1),value,getNthNode(index));//creative inserting current
    getNthNode(index).setPrev(temporary);//setting the next one to have the new addition as its previous
    getNthNode(index-1).setNext(temporary);//setting the one before to have next reference as current
    length++;
  }
}


  public Integer remove(int index){
    if(index<0 || index>=length){//if the index is out of bounds, through exception
      throw new IndexOutOfBoundsException();
    }
    Node current = getNthNode(index);//creating a temporary current for the node at index
    Node after = current.next();
    Node before = current.prev();
    if(index==0){//if removing first
      after.setPrev(null);
      start=after;
    }
    else if(index==length-1){//if removing last
      before.setNext(null);
      end=before;;
    }
    else{
      after.setPrev(before);//cutting the middle one out
      before.setNext(after);
      current.setNext(null);
      current.setPrev(null);
    }
    length--;
    return current.getData();//returning old data
  }

  public boolean remove(Integer value){
    if(!contains(value)){//if value isn't in the linked list, return false
      return false;
    }
    else{
      int i=indexOf(value);//find the value
      remove(i);//remove it
      return true;
    }
  }

  public void extend(MyLinkedList other){
       if(this.length==0){//if the original length is 0
         for(int i=0;other.length!=0;i++){//loop through other and just add on
           this.add(i,other.getNthNode(i).getData());
           other.length--;
         }
       }
       if(other.size()!=0){//if the list has not been added(or is empty)
         end.setNext(other.start);//set the element after the last in #1 to the start of #2
         other.start.setPrev(end);//first element of other list's previous is now first list's end
         end=other.end;//set end as other end
         other.start=null;//practically eliminating the other list
         other.end=null;
         length+=other.length;//increasing the length
         other.length=0;//setting the other length to 0
       }
   }
}
