import java.io.*;
import java.util.*;

public class Accept_int {

    int ctr = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String accept_int(String num) throws IOException {
        do {

            if (num.equals("")) {

                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Please Input A Valid Entry *");
                System.out.print("\t\t");
                num = br.readLine();
                ctr++;
            }

            for (int i = 0; i < num.length(); i++) {

                ctr = 0;
                if (Character.isDigit(num.charAt(i)) == false) {

                    System.out.println();
                    System.out.print("\t\t");
                    System.out.println("* Enter Integer only *");
                    System.out.print("\t\t");
                    num = br.readLine();
                    ctr++;
                    break;

                }
            }

        } while (ctr != 0);
        return num;
    }
}
