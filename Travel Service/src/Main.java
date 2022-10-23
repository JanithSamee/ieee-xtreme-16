import java.util.Scanner;

public class Main {
       private static Scanner sc = new Scanner(System.in);
       private static int INITIAL_CAPAcITY=0;
    public static void main(String[] args) {

        byte t= sc.nextByte();

        for (int __i = 0; __i < t; __i++) {
            int stations =sc.nextInt();
            INITIAL_CAPAcITY= sc.nextInt();
            int ri =sc.nextInt();
            int total = calcCost(INITIAL_CAPAcITY,stations,INITIAL_CAPAcITY,0,ri);
//            System.out.println(total);

        }
    }

    public static int calcCost(int capacity,int stations,int prevCapacity,int prevConsumption,int previousCost){
        int consumption =sc.nextInt();
        int cost =sc.nextInt();

            if (stations<1){
                return 0;
            };
            if(capacity<=consumption) {
                System.out.println(capacity - consumption);
                return (previousCost*(prevCapacity-prevConsumption)+500)+ calcCost(INITIAL_CAPAcITY, stations - 1,consumption,INITIAL_CAPAcITY,cost);
            }
            return calcCost(capacity - consumption, stations - 1,capacity,consumption,cost);
    }
}
