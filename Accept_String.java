import java.io.*;
import java.util.*;

public class Accept_String {
    int ctr = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String accept_string(String str) throws IOException {
        do {
            if (str.equals("") || Character.isWhitespace(str.charAt(0)) == true) {
                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Please Input A Valid Entry *");
                System.out.print("\t\t");
                str = br.readLine();
                ctr++;
            }
            for (int i = 0; i < str.length(); i++) {
                ctr = 0;
                if (Character.isLetter(str.charAt(i)) == false) {
                    if (i == 0 && Character.isWhitespace(str.charAt(0)) == true) {
                        ctr++;
                        break;
                    }

                    if (Character.isWhitespace(str.charAt(i)) == false) {
                        System.out.println();
                        System.out.print("\t\t");
                        System.out.println("* Enter Letters Only *");
                        System.out.print("\t\t");
                        str = br.readLine();
                        ctr++;
                        break;
                    }
                }
            }
        } while (ctr != 0);

        return str;

    }
}
