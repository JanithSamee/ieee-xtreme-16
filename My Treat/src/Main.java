import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        byte t = scanner.nextByte();
        for (byte i = 0; i < t; i++) {
            short cases =scanner.nextShort();

            HashMap<String,Byte> threates =new HashMap<String,Byte>();

            for (int j = 0; j < cases; j++) {
                String name =scanner.next();

                byte count =scanner.nextByte();
                if(threates.containsKey(name)){
                    byte oldCount=threates.get(name);
                    threates.replace(name, (byte) (oldCount+count));
                }else{
                     threates.put(name, (byte) 1);
                }


                for (int k = 0; k < count; k++) {
                    String _name =scanner.next();
                    if(threates.containsKey(_name)){
                    byte _oldCount=threates.get(_name);
                    threates.replace(_name, (byte) (_oldCount-1));

                    }else{
                        threates.put(_name, (byte) -1);

                    }

                }
            }


            short posCount=0;
            short negCount=0;

            int negTotal=0;
            for (Byte val:threates.values()
                 ) {
                if(val<0){

                    negTotal+=(-1*val);
                }else{
                    posCount++;
                }
            }

            if(posCount%threates.size()==0  ){
                System.out.print(0);
                System.out.print(" ");
                System.out.println(0);
            }

            System.out.print(negTotal);
            System.out.print(" ");
            System.out.println(negTotal<=posCount?1:negTotal%posCount +1);
        }
    }
}
