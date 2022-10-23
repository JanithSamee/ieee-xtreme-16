import java.util.Scanner;

public class Main {
    public static void main (String[] args){


        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()){

        String charactor = sc.nextLine();

        String _out="";
            for (int i = 0; i < charactor.length(); i++) {
                _out+=decrypt(charactor.charAt(i));
            }
        System.out.println(_out);
        }
    }

     static char decrypt(char letter){
        char out =' ';
        short position = (short) letter;
        if (position>96 && position<123){
            out =  position>=109?(char) (position-12):(char) (position+14);
            return out;
        }else if(position>64 && position<91){
            out =  position>=77?(char) (position-12):(char) (position+14);
            return out;
        }else {
            return (char) (position);
        }
    }
}
