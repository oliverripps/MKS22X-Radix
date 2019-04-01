public class Node{
 private int data,tal;
 private Node next,prev;

 public Node(Node referencefrom, int num,int t,Node referenceto){
   data=num;
   next=referenceto;
   tal=t;
   prev=referencefrom;
 }
 public Node next(){
   return this.next;

 }
 public Node prev(){
   return this.prev;
 }
 public void setNext(Node other){
   this.next=other;
 }
 public void setPrev(Node other){
   this.prev=other;
 }
 public Integer getData(){
   return data;
 }
 public Integer setData(Integer i){
   Integer olddata=data;//remembering old data
   data=i;//setting new
   return olddata;//returning the old data
 }
 public String toString(){
   return "" + data;
 }
 public Integer getTal(){
   return tal;
 }
 public Integer setTal(Integer i){
   Integer olddata=data;//remembering old data
   tal=i;//setting new
   return olddata;//returning the old data
 }

}
