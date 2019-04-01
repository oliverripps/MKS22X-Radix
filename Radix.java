public class Radix{
  public static void radixsort(int[] data){
    MyLinkedList() l = new MyLinkedList();
    int digits=getLongest(data);
    digits=10*digits-1;
    for(int i=0;i<data.length;i++){
      add(data[i]);
      l.get(i).setTal=data[i]%digits;
    }


  }

  private static int getLongest(int[] data){
    int longest=0
    int str;
    for(int i=0;i<data.length;i++){
      str=data[i]+""
      if(str.length()>longest){
        longest=str.length;
      }
    }
    return longest;
  }

}
