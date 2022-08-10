public boolean wordBreak(String s, List<String> wordDict) {
       HashSet<Character> set = new HashSet<>();
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
    map.put(temp,false);
    System.out.println(temp);
    return false;
}