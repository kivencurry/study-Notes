package Huawei;

import sun.nio.ch.sctp.SctpServerChannelImpl;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
//        int  n=1;
        int index=0;
        Q2 q2 = new Q2();
        while(index<n){
            String s=sc.next();
            int res=q2.canBechange(s);
            index++;
            System.out.println(res);
        }
    }
    private int  canBechange(String s){
        //splite as * and =
        String [] str=s.split("=|\\*");
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
