import sun.awt.SunHints;

import java.util.*;
import java.sql.*;
/**
 * @author cid
 * @create 2022-05-12-19:33
 */
class P49Anagrams {
    public static void main(String[] args) {
        String [] strs={"eat","tea","tan","ate","nat","bat"};
        System.out.println(new P49Anagrams().groupAnagrams(strs));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        List<List<String>> ans=new ArrayList<>();
        List<List<String>> ans1=new ArrayList<>();
        //Integer对应当前String存在List<List<>>的位置
        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            char[] temp=s.toCharArray();
            Arrays.sort(temp);
            String s1=String.valueOf(temp);
            if(map.containsKey(s1))
                map.get(s1).add(s);
            else{
                List<String> list=new ArrayList<>();
                list.add(s);
                map.put(s1,list);

            }
        }
        //遍历值相同的键
        //(1)
        map.forEach((Key, Value)->{
           ans1.add(Value);
        });
        //(2)
//        Set<Map.Entry<String, List<String>>> set = map.entrySet();
//        Iterator<Map.Entry<String, List<String>>> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, List<String>> next = iterator.next();
//            System.out.println(next.getKey()+"---"+next.getValue());
//        }
//        Set<String> set1=map.keySet();
        //(3)
//        for(String e:set1){
//            ans.add(map.get(e));
//        }
        //(4)
        System.out.println(map.values());
        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        return ans1;

    }
}
