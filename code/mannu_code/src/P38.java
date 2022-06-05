import java.util.*;

public class P38 {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        String last=countAndSay(n-1);
        return getText(last);
    }
    private String getText(String str){
        if(str==null||str.length()==0)
            return "";

        int num=getRepeatNum(str);
        return num+""+str.charAt(0)+getText(str.substring(num));


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

