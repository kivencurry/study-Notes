//分治思想
//在不同的位置进行切割，在左侧子串为回文串的前提下，对右侧的子串进行切割，
//直到右侧的所有子串均为回文串时，在头部添加左侧回文子串。
class Solution {  
public List<List<String>> partition(String s) {
	List<List<String>> list=new ArrayList<>();
	if(s==null||s.length()==0){
		return list;
	}
	
	return partitionHelper(s,0);
	      
}
private List<List<String>> partitionHelper(String s,int start){
	if(s==null||s.length()==start){
		List<String> temp=new ArrayList<>();
        List<List<String>> list=new ArrayList<>();
		list.add(temp);
		return list;
	}
	List<List<String>> list=new ArrayList<>();
	for(int i=start;i<s.length();i++){
		String str=s.substring(start,i+1);
		//
		if(isPartition(str)){
			for(List<String> l:partitionHelper(s,i+1)){
				l.add(0,str);
				list.add(l);
			}
			
		
		}
		
	}
	return list;

}
private boolean isPartition(String s){
	int len=s.length()-1;
	int i=0;
	while(i<len){
		if(s.charAt(i)==s.charAt(len)){
			len--;
			i++;
		}else{
			return false;}
	}
	return true;

}
}


 



















