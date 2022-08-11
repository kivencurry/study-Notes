package Q3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
*   问题分析：因为只能是添加1，所以考虑0的位置；
* 0只能在处于两侧
* */
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int sNum=sc.nextInt();
        int i=0;
        while(i<sNum){
            String s=sc.next();
            System.out.println(addNum(s));
            i++;
        }
    }
    public static int addNum(String s1){
        //统计0的个数
        int num_0=0;
        List<Integer> index_0=new ArrayList<>();
        List<Integer> index_1=new ArrayList<>();

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)-'0'==0)
                index_0.add(i);
            else {
                index_1.add(i);
            }
        }
        num_0=index_0.size();
        if(num_0==0){//只有1，没有0
           return index_1.size() % 2;
        }
        if(num_0%2==1){//奇数个
            int mid_0=index_0.get(index_0.size()/2);
            int num=getDiffer(0,mid_0,s1)-getDiffer(mid_0,s1.length()-1,s1);
            //统计mid_0两边的1的个数的差，即为要添加的1的个数
            return Math.abs(num);
        }
        else{//偶数个，统计(num_0%2==0)
            int mid_left=index_0.get(index_0.size()/2);
            int mid_right=index_0.get(index_0.size()/2+1);
            //统计mid_0两边的1的个数的差，即为要添加的1的个数
            int num=getDiffer(0,mid_left,s1)-getDiffer(mid_right,s1.length()-1,s1);
            System.out.println(num);
            return Math.abs(num);
        }
    }

   public static  int getDiffer(int start,int end,String s){
        int num=0;
        for(int i=start;i<=end;i++){
            if(s.charAt(i)-'0'==1){
                num++;
            }

        }
        return num;

   }
}
