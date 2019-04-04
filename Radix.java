public class Radix{
  public static void radixsort(int[] data){
    if(data.length<=1){
      return;
    }
    int digits=getLongest(data);

    @SuppressWarnings("unchecked")
    LinkedList<Integer>[] buckets = new LinkedList[20];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new LinkedList<Integer>();
    }

    //boolean done=false;
    MyLinkedList<Integer> nums = new MyLinkedList<Integer>();

    for(int i=0;i<digits;i++){
      if(i==0){
        for(int l=0;l<data.length;l++){
          int curr=data[l];
          int index=Math.abs((int)(curr/(Math.pow(10,i)))% 10);
          if(curr>=0){
            buckets[index+10].add(curr);
          }
          else{
            buckets[9-index].add(temp);
          }
        }
      }
      else{
        while(nums.size()>0){
          int num=nums.removeFront();
          int index=Math.abs((int)(num/(Math.pow(10, i)))% 10);
          if(num>= 0){
            buckets[index+10].add(num);
          }
          else{
            buckets[9 - idx].add(num);
          }
        }
      }
      
      /*LinkedList() l = new LinkedList();
      nums[i]=l;
      l.add(data[i]);
      l.get(i).setTal=data[i]%digits;*/
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
