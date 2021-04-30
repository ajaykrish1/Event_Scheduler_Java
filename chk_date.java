import java.io.*;
import java.util.*;

public class chk_date {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int day, month, year;
    int ctr = 0;

    public String accept_date(String date) throws IOException {

        do {

            try {
                Scanner s = new Scanner(date).useDelimiter("/");
                day = s.nextInt();
                month = s.nextInt();
                year = s.nextInt();

                if (day > 31 || day <= 0 || month != 1 || year != 2016) {

                    System.out.println();
                    System.out.print("\t\t");
                    System.out.println(
                            "* Enter a Valid Date In The Format Given In Bracket ( Day : 1 To 31 / 1 / 2016 ) *");
                    System.out.print("\t\t");
                    date = br.readLine();
                    ctr++;

                } else {
                    break;
                }

            } catch (InputMismatchException e) {

                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Enter Integer Only *");
                System.out.print("\t\t");
                date = br.readLine();
                ctr++;

            } catch (NoSuchElementException e1) {

                System.out.println();
                System.out.print("\t\t");
                System.out
                        .println("* Enter a Valid Date In The Format Given In Bracket ( Day : 1 To 31 / 1 / 2016 ) *");
                System.out.print("\t\t");
                date = br.readLine();
                ctr++;

            }
        } while (ctr != 0);
        return date;
    }
}
