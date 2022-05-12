//P50
//2的N次方的计算
//递归方法:
//将2^n=2^(n/2)*2^(n/2)*2^(n%2)
int temp=2^(n/2);
int 2^n=temp*temp*2^(n%2);
//特殊情况：x=0,1,-1;
//单独考虑n=-2147483648的情况
if(n==-2147483648){
    if(x<1&&x>-1){
	return Double.POSITIVE_INFINITY;
    }
    else
	return 0;
}
//迭代iterate：
private double getPower(double x,int n){

 double ans=1;
 while(n>0){
	if ((n & 1) == 1) {
	 ans*=x;
	}
	x=x*x;
	n=n>>1;
	}
	return ans;
}
//p49
//思路分析：将字符串转成字符数组，然后排序，再转换成字符串，如果相同，
//则把原来的字符串加进该list，不然的话，新建一个list存储现在的字符串
//映射
public List<List<String>> groupAnagrams(String[] strs) {
	HashMap<String,List<String>> map=new HashMap<>();
	List<List<String>> ans=new ArrayList<>();
	//Integer对应当前String存在List<List<>>的位置
	for(int i=0;i<strs.length;i++){
	String s=strs[i];
	char[] temp=s.toCharArray();
	Collection.sort(temp);
	if(map.containsKey(temp.toString()))
		map.get(temp.toString()).add(s);
	else{
		List<String> temp=new ArrayList<>();
	map.put(temp.toString(),temp.add(s));
	
	}
	}
	//需要值相同的键
	Iterator<List<String>> e=map.KeySet().Iterator();
	while(e.hasnext()){
	ans.add(e);
	
	}
        
    }

    // 使用map接口默认方法
    private static void method_3(HashMap<String, Integer> map) {
        map.forEach((Key, Value)->{
            System.out.println(Key+"---"+Value);
        });
    }

    // 通过迭代器的方式获取
    public static void method_1( HashMap<String, Integer> mp){
        Set<Map.Entry<String, Integer>> set = mp.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey()+"---"+next.getValue());
        }
    }

    // 通过get方式获取
    public static void method_2( HashMap<String, Integer> mp) {
        Set<String> set = mp.keySet();
        for (String s : set) {
            Integer val = mp.get(s);
            System.out.println(s+"----"+val);
        }
    }
    public static void method( HashMap<String, Integer> mp){
        Set<String> set = mp.keySet();
        for (String s : set) {
            System.out.println(s);
        }
        Collection<Integer> values = mp.values();
        for (Integer value : values) {
            System.out.println(value);
        }

    }



