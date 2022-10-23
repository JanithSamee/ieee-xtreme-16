
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
    public static int c=0;
    public static void main (String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int jobs= scanner.nextInt();
        byte workers= scanner.nextByte();

        ArrayList<Integer> times= new ArrayList<Integer>();

        for (int i = 0; i < jobs; i++) {
                times.add(scanner.nextInt());
        }

        times.sort((o1, o2) -> o1-o2);

        long totalTime = 0;
        boolean isDone=false;
        while (!isDone) {

            if (workers<=1  || times.size()<=0) {
                for(int i = 0; i < times.size(); i++){
                    totalTime += (int) Math.pow(2,times.get(i));
                }
                break;
            }
            else{

            long _maxTime =(long) Math.pow(2,times.get(times.size()-1));
            int _minTime=0;
            while (_minTime<_maxTime && times.size()>0){
                _minTime+=(int) Math.pow(2,times.get(0));
                times.remove(0);

            }
            totalTime+=_maxTime%10E9+7;
            workers-=2;
            int coreTime=0;
            while (workers>1 && _maxTime-_minTime>coreTime && times.size()>0 ){
                coreTime+=(int) Math.pow(2,times.get(0));
                times.remove(0);
            }
            try {

            times.remove(times.size()-1);
            }catch (Exception e){
                continue;
            }

            }
        }

        System.out.println(totalTime);
    }



}