// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        // Read the number of testcases
        int T = sc.nextInt();
        // Process each test case
        for (int t = 0; t < T; t++) {
            // Read the number of offsets
            int N = sc.nextInt();

            int answer = 0;
            // Read each offset
            // TODO: You will need to figure out how to
            // process the offset and change the variable answer
            for (int n = 0; n < N; n++) {
                int D = sc.nextInt();
                System.out.println(D);
            }

            // Output your answer:
            System.out.println(answer);
        }

    }
}