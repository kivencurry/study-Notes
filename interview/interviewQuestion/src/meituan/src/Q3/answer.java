package Q3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class answer {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int srcNum = sc.nextInt();
//        int i = 0;
//        while (i < srcNum) {
//            String s = sc.next();
//            System.out.println(addNum(s));
//            i++;
//        }
        String s="10101";
        System.out.println(addNum(s));
    }
        public static int addNum(String s1){
            //ͳ��0�ĸ���
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
            if(num_0==0){//ֻ��1��û��0
                return index_1.size() % 2;
            }
            int leftStart=0;
            int leftEnd=index_0.get(0);
            int rightStart=index_0.get(index_0.size()-1)+1;
            int rightEnd=s1.length();
            int num=0;
            int i=0;
            while (leftEnd<=rightStart){
                String a=s1.substring(leftStart,leftEnd);
                String b=s1.substring(rightStart,rightEnd);
                num+=getDiffer(a,b);
                leftStart=index_0.get(i)+1;
                if(i+1>=index_0.size()){//���ֻ��һ��0�Ļ����Ѿ��õ��˽��
                    break;
                }
                leftEnd=index_0.get(i+1);
                rightStart=index_0.get(index_0.size()-2-i)+1;
                rightEnd=index_0.get(index_0.size()-1-i);
                i++;
            }
            return num;
        }
        public static  int getDiffer(String a,String b){//���������ֻ����1������ֻ���س��Ⱦ���
        return  Math.abs(a.length()-b.length());
        }

}

