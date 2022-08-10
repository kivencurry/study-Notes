 
//不适合回溯或者BFS
/*

思路：i*****j**
i可以最远到达j的情况下，i+1不可以到达比j更远的情况。
*/

 public int canCompleteCircuit(int[] gas, int[] cost) {
    int len=gas.length;

    
    for(int i=0;i<len;){
        int j=i;
        //可以到达i+1点
        int remain=0;//the gas is 0 at the  begining
        remian+=gas[j];

        while(remain-cost[j]>=0){
            remain-=cost[j];
            j=(j+1)%len;
            if(j==i){
                return remain;
            }
        }
        i=j+1;

    }
    return -1;


 }