package Q2;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int wa=0,wb=0,wc=0;
            while(scanner.hasNextInt())
            {
                wa = scanner .nextInt();
                wb = scanner .nextInt();
                wc = scanner .nextInt();
            }
            int [] w={wa,wb,wc};

            char []day_food={'A','B','C','C','A','A','B'};
            char []food={'A','B','C'};
            int day=0;

            int [] power={8,5,7};
            int i=0;
            while(true){
                int index=day_food[i]-'A';//�ж���һ��ʳ��
                int need=w[index]-power[index];//��ȥ��Ӧ������

                if(need>=0){
                    w[index]-=power[index];
                    day++;
                }
                else{
                    break;
                }
                i++;
                if(i==day_food.length){//����ѭ����ֻҪʳ�ﹻ
                    i=0;
                }
            }
            System.out.println(day);

        }

}
