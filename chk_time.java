import java.io.*;
import java.util.*;

public class chk_time {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int min, hour;
    int ctr = 0;

    public String accept_time(String time) throws IOException {

        do {

            try {

                Scanner s = new Scanner(time).useDelimiter(":");
                hour = s.nextInt();
                min = s.nextInt();

                if (hour > 23 || hour < 0 || min < 0 || min > 59) {

                    System.out.println();
                    System.out.print("\t\t");
                    System.out.println(
                            "* Enter Valid Time In The Format Given In Bracket ( Hour < 24 : Minutes < 60 ) *");
                    System.out.print("\t\t");
                    time = br.readLine();
                    ctr++;

                } else {
                    break;
                }

            } catch (InputMismatchException e) {

                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Enter Integer Only *");
                System.out.print("\t\t");
                time = br.readLine();
                ctr++;

            } catch (NoSuchElementException e1) {

                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Enter Valid Time In The Format Given In Bracket ( Hour < 24 : Minutes < 60 ) *");
                System.out.print("\t\t");
                time = br.readLine();
                ctr++;

            }
        } while (ctr != 0);
        return time;

    }
}
