public class Radix{
  public static void radixsort(int[] data){
    int digits=getLongest(data);
    LinkedList()[] nums = new LinkedList()[digits];
    digits=10*digits-1;
    for(int i=0;i<nums.length;i++){
      LinkedList() l = new LinkedList();
      nums[i]=l;
      l.add(data[i]);
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
