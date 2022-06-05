import java.util.*;

public class P38_iterate {
    public String countAndSay(int n) {
        if(n<0){
            return "";
        }
       String str="1";
        if(n==1)   return str;
        while(n>1){
            String last="";
            for(int i=0;i<str.length();){
                int num=getRepeatNum(str.substring(i));
                 last=last+num+""+str.charAt(i);
                 i=i+num;
            }
            n--;
            str=last;
        }
        return str;
    }
    private int getRepeatNum(String str){
        if(str==null||str.length()==0)
            return 0;
        int num=1;
        while(num<str.length()&&str.charAt(num)==str.charAt(num-1)){
            num++;
        }
        return num;
    }
}

