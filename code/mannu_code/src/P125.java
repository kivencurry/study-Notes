class P125
{
	
  public boolean isPalindrome(String s) {
		s=s.toLowerCase();//change to lower case 
		int start=0;
		int end=s.length()-1;
		while(start<end){
			while(!isAlphabetNumber(s.charAt(start))){
				start+=1;
				//out of boundary
				if(start==s.length()){
					return true;
				}

			}
			while(!isAlphabetNumber(s.charAt(end))){
				end-=1;
				if(end==0){
					return true;
				}

			}
			if(s.charAt(start)==s.charAt(end)){
			//move to next position
				start+=1;
				end-=1;
			}
			else{
				return false;
			}

		}
      return true;

	}
	private boolean isAlphabetNumber(char c){
		if(c>='a'&&c<='z'||c>='A'&&c<='Z'||c>='0'&&c<='9'){
			return true;
		}
		else{
			return false;
		}
	}
}
