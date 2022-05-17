/**
 * @author cid
 * @create 2022-05-17-17:37
 */
public class p45 {
    public static void main(String[] args) {
        String str="aa";
        String pattern="a";
        System.out.println(new p45().isMatch(str, pattern));

    }
    public boolean isMatch(String str,String Pattern){
        int p=0;//index of String p
        int s=0;//index of String s
        int starIn=0;//index of '*'
        int match=0;//the index of s when p is '*'
        int flag=-1;//if exist '*' 
        while(s<str.length()){
            if(p<Pattern.length()&&(str.charAt(s)==Pattern.charAt(p)||Pattern.charAt(p)=='?')){//matched at this position
                p++;
                s++;
            }
            else if(p<Pattern.length()&&Pattern.charAt(p)=='*'){
                //match 
                match=s;
                starIn=p;
                flag=p;//change the flag
                p++;
            }
            else if(flag!=-1){
                //not match
                p=starIn+1;//come back the position
                match++;//move back
                s=match;
            }
            else{
                return false;
            }
        }
        while(p<Pattern.length()&&Pattern.charAt(p)=='*'){
            p++;
        }
        return p==Pattern.length();
    }
}
