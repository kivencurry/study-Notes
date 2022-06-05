import java.util.*;

class P43 {
	public static void main(String []args){
		String num1="123";
		String num2="456";
		int len1=num1.length();
		int len2=num2.length();
		
		int nums[]=new int[len1+len2-1];
		for(int i=0;i<len1;i++){
			for(int j=0;j<len2;j++){
				nums[i+j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
			}
		}
		int carry=0;
//		List<String> list=new ArrayList<>();
		StringBuffer s=new StringBuffer();
		for(int i=len1+len2-2;i>=0;i--){

			int temp=nums[i]+carry;
			s.insert(0,temp%10+"");
			carry=temp/10;
		}
		if(carry!=0){
		s.insert(0,carry+"");
		}

		System.out.println(s);


	}
	
}
