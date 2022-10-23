import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int jobs= scanner.nextInt();
        byte workers= scanner.nextByte();

        LinkedList<Integer> timesList= new LinkedList<Integer>();

        for (int i = 0; i < jobs; i++) {
            timesList.add(scanner.nextInt());
        }

        timesList.sort((o1, o2) -> o1-o2);

        long time= calculateTime(timesList,workers);
//        long res =(long) (time % 1000000007);
        System.out.println(time);
//        System.out.println(power2(2));
    }


    public static long calculateTime(LinkedList<Integer> timeList,byte workers){
        if(timeList.size()<1 || workers<=1){
            long total =0;
            for (int t: timeList
                 ) {
//                total+=(long ) (Math.pow(2,t)% 1000000007);
                total+=power3(2,t,1000000007);
            }
            return total;

        }else{
            long maxTime=power3(2,timeList.getLast(),1000000007 );
            long minTime=0;
            while (maxTime>=minTime && timeList.size()>0){
//                minTime+=(long)(Math.pow(2,timeList.getFirst()));
                minTime+=power3(2,timeList.getFirst(),1000000007);
                timeList.removeFirst();
            }
            if(timeList.size()>1) timeList.removeLast();
            return maxTime +calculateTime(timeList, (byte) ( workers-2));
        }

    }

    public static long power(int num){
        if(num<1){
            return 1;
        }
        else if(num==1) return 2;
        else {
            long _out= (2*power(num-1)%1000000007);
            return _out;
        }
    }

    static long power2(int x)
    {
        int base = 2;

        long result = 1;

        for (; x != 0; --x) {
            result = (result*base) % 1000000007;

        }

       return result;
    }

    static int power3(int A,
                           int B, long C)
    {


        // Base cases
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;

        // If B is even
        long y;
        if (B % 2 == 0)
        {
            y = power3(A, B / 2, C);
            y = (y * y) % C;
        }

        // If B is odd
        else
        {
            y = A % C;
            y = (y * power3(A, B - 1,
                    C) % C) % C;
        }

        return (int)((y + C) % C);
    }


}
