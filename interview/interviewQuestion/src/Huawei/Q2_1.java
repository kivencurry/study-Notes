package Huawei;

import java.util.Scanner;

public class Q2_1 {
    public static void main(String[] args) {
        Q2_1 q2_1 = new Q2_1();
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int index=0;
        while (index<n1){
//            String s=sc.next();
            String s="12*12=444";
            int res=q2_1.canBechange(s);
            System.out.println(res);
            index++;
        }

    }
    private int  canBechange(String s){
        //splite as * and =
//        String [] str=s.split("=|\\*");
        String [] str=new String [3];
        int n1=s.indexOf("*");
        str[0]=s.substring(0,n1);
        int n2=s.indexOf("=");
        str[1]=s.substring(n1+1,n2);
        int len=s.length();
        str[2]=s.substring(n2+1,len);

        int num1=getNum(str[0]);
        int num2=getNum(str[1]);
        int ans=getNum(str[2]);
        if(num2*num2==ans){
            return 1;
        }
        // check ans can exchange

        if(exchange(num1*num2+"",str[2])){
            return 1;
        }
        //check num1 can be change
        int temp=ans/num2;
        if(exchange(temp+"",str[0])){
            return 1;
        }
        //check num2 can be change
        temp=ans/num1;
        if(exchange(temp+"",str[1])){
            return 1;
        }

        return -1;

    }


    private int getNum(String s){
        int len=s.length();
        int index=0;
        int res=0;
        while (index<len){
            int temp=s.charAt(index)-'0';
            res=res*10+temp;
            index++;
        }
        return res;
    }
    private boolean exchange(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        int len= s1.length();
        int count=0,index=0;

        while(index<len&&count<2){
            if(s1.charAt(index)!=s2.charAt(index)){
                count++;
            }
            index++;
        }
        if(count<=1){
            return true;
        }
        else
            return false;

    }
}
