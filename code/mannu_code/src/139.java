 for(int i = 0;i < wordDict.size(); i++){
            if(wordBreakHelper(s,wordDict,temp + wordDict.get(i))){
                return true;
            }
        }
apple
appleapple
appleappleapple
appleapplepen
applepen
applepenapple
true
--------------------------------
for(int i=0;i<wordDict.size();i++){
            if(!ans){
                //
                str.append(wordDict.get(i));
                wordBreakHelper(s,wordDict,str);
                int len=wordDict.get(i).length();
                //移除刚才添加的元素
                str.delete(str.length()-len,str.length());
            }
            else{
                return;
            }
        }
apple
appleapple
appleappleapple
appleapplepen
appleapplepenapple
appleapplepenpen
applepen
applepenapple
true
---
apple
appleapple
appleappleapple
appleappleapplepen
appleappleapplepenpen
appleappleapplepenpenpen

-------------
导致遍历结果不通的原因，StringBuilder是对原来的字符串进行操作，String+Sting生成了新的字符串。
原来的字符串并没有改变。
-------
public boolean wordBreak(String s, List<String> wordDict) {
       HashSet<Character> set = new HashSet<>();
       //检查字符元素是否相同，意义不大。
    for (int i = 0; i < wordDict.size(); i++) {
        String t = wordDict.get(i);
        for (int j = 0; j < t.length(); j++) {
            set.add(t.charAt(j));
        }
    }
    for (int i = 0; i < s.length(); i++) {
        if (!set.contains(s.charAt(i))) {
            return false;
        }
    }
    return wordBreakHelper(s,wordDict,"",new HashMap<>());
}
//temp 是当前生成的字符串
private boolean wordBreakHelper(String s, List<String> wordDict, String temp,HashMap<String,Boolean> map) {
     if(temp.length() > s.length()){
        return false;
    }
    //之前是否存过
    if(map.containsKey(temp)){
        return map.get(temp);
    }
    //如果此时生成的字符串长度够了，就判断和目标字符日是否相等
    if(temp.length() == s.length()){
        if(temp.equals(s)){
            return true;
        }else{
            return false;
        }
    }
    //长度超了，就返回 false
   
    //考虑每个单词
    for(int i = 0;i < wordDict.size(); i++){
        String str=temp + wordDict.get(i);
        int len=str.length() >s.length() ? s.length():str.length();
        String str1 = s.substring(0, len);
        if(str1.equals(str)){//在两个字符前缀相同的情况下，继续向下搜索
               if(wordBreakHelper(s,wordDict,str,map)){
                   map.put(temp,true);
                return true;
            } 
        }
        
    }
    //一条策略生成
    map.put(temp,false);
    System.out.println(temp);
    return false;
}
------------