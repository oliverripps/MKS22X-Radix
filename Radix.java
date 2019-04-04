import java.util.*;

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
    LinkedList<Integer> nums = new LinkedList<Integer>();

    for(int i=0;i<digits;i++){
      if(i==0){
        for(int l=0;l<data.length;l++){
          int curr=data[l];
          int index=Math.abs((int)(curr/(Math.pow(10,i)))% 10);
          if(curr>=0){
            buckets[index+10].add(curr);
          }
          else{
            buckets[9-index].add(curr);
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
            buckets[9 - index].add(num);
          }
        }
      }
      for(int l=0;l<20;l++){
        nums.extend(buckets[l]);
      }
    }
    int index = 0;
    while (nums.size() > 0){
      data[index] = nums.removeFront();
      index++;
    }
  }

  private static int digitsIn(int num){
    num=Math.abs(num);
    int i=0;
    while(num>0){
      num=num/10;
      i++;
    }
    return i;
  }

  private static int getLongest(int[] data){
    int longest=0;
    for(int i=0;i<data.length;i++){
      if(Math.abs(data[i])>=longest){
        longest=Math.abs(data[i]);
      }
    }
    return digitsIn(longest);
  }

  public static void main(String[]args){
        System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
        int[]MAX_LIST = {1000000000,500,10};
        for(int MAX : MAX_LIST){
          for(int size = 31250; size < 1000001; size*=2){
            long qtime=0;
            long btime=0;
            for(int trial = 0 ; trial <=5; trial++){
              int []data1 = new int[size];
              int []data2 = new int[size];
              for(int i = 0; i < data1.length; i++){
                data1[i] = (int)(Math.random()*MAX);
                data2[i] = data1[i];
              }
              long t1,t2;
              t1 = System.currentTimeMillis();
              Radix.radixsort(data2);
              t2 = System.currentTimeMillis();
              qtime += t2 - t1;
              t1 = System.currentTimeMillis();
              Arrays.sort(data1);
              t2 = System.currentTimeMillis();
              btime+= t2 - t1;
              if(!Arrays.equals(data1,data2)){
                System.out.println("FAIL TO SORT!");
                System.exit(0);
              }
            }
            System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
          }
          System.out.println();
        }
      }

}
