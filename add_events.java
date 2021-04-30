import java.io.*;
import java.util.*;

public class add_events {
    public void add() throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Event.dat", true));
            PrintWriter pw = new PrintWriter(bw);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String n1;
            String time, event, venue, name_chiefguest, date, no_people;

            Accept_int obj = new Accept_int();
            Accept_String obj1 = new Accept_String();
            chk_time obj2 = new chk_time();
            chk_date obj3 = new chk_date();

            System.out.println();
            System.out.print("\t\t");
            System.out.println("* How Many Records Do You Want To Enter *");
            System.out.print("\t\t");
            n1 = obj.accept_int(br.readLine());
            int n = Integer.parseInt(n1);

            for (int i = 0; i < n; i++) {
                System.out.println();
                System.out.print("\t\t");
                System.out
                        .println("* Enter The Date In The Format Given In The Bracket ( Day : 1 To 31 / 1 / 2016 ) *");
                System.out.print("\t\t");
                date = obj3.accept_date(br.readLine());

                System.out.println();
                System.out.print("\t\t");
                System.out
                        .println("* Enter The Time In The Format Given In The Bracket ( Hour < 24 : Minutes < 60 ) *");
                System.out.print("\t\t");
                time = obj2.accept_time(br.readLine());

                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Enter Event *");
                System.out.print("\t\t");
                event = obj1.accept_string(br.readLine());

                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Enter Venue *");
                System.out.print("\t\t");
                venue = obj1.accept_string(br.readLine());

                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Enter No Of People Coming *");
                System.out.print("\t\t");
                no_people = obj.accept_int(br.readLine());

                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Enter name of chief guest coming *");
                System.out.print("\t\t");
                name_chiefguest = obj1.accept_string(br.readLine());

                pw.println(date + "-" + time + "-" + event + "-" + venue + "-" + no_people + "-" + name_chiefguest);

                if (i != (n - 1)) {
                    System.out.println();
                    System.out.print("\t\t");
                    System.out.print("------- THE NEXT RECORD------");
                    System.out.println();
                }
            }

            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("* The File Is Not Found *");
        }
    }
}
