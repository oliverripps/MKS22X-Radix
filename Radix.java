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


  private static int digitsIn(int num){
    num=Math.abs(num);
    int i=0;
    while(num>0){
      num=num/10;
      i++
    }
    return i;
  }
  
  private static int getLongest(int[] data){
    int longest=0
    for(int i=0;i<data.length;i++){
      if(Math.abs(data[i])>=longest){
        longest=Math.abs(data[i]);
      }
    }
    return digitsIn(longest);
  }

}
