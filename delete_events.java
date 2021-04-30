import java.io.*;
import java.util.*;

public class delete_events {
    int found = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void delete_record() throws IOException {
        chk_date obj2 = new chk_date();
        chk_time obj3 = new chk_time();

        System.out.println();
        System.out.print("\t\t");
        System.out.println(
                "* Enter Date Of The Record You Want To Delete In The Format Given In Bracket ( Day : 1 To 31 / 1 / 2016 ) *");
        System.out.print("\t\t");
        String date1 = obj2.accept_date(br.readLine());
        System.out.println();

        System.out.println();
        System.out.print("\t\t");
        System.out.println(
                "* Enter Time Of The Record You Want To Delete In The Format Given In Bracket ( Hour < 24 : Minutes < 60 ) *");
        System.out.print("\t\t");
        String time1 = obj3.accept_time(br.readLine());
        System.out.println();

        delete_events m = new delete_events();
        m.delete_date(date1, time1);

    }

    public void delete_date(String date1, String time1) throws IOException {
        try {
            Scanner s = new Scanner(new FileReader("Event.dat"));
            PrintWriter pw = new PrintWriter(new FileWriter("temp1.dat"));

            String date, time;
            String str;

            while (s.hasNextLine()) {
                str = s.nextLine();
                Scanner s1 = new Scanner(str).useDelimiter("-");
                date = s1.next();
                time = s1.next();

                if (date1.equalsIgnoreCase(date) && time1.equalsIgnoreCase(time)) {
                    found++;
                } else {
                    pw.println(str);
                }
            }
            s.close();
            pw.close();

            if (found == 0) {
                System.out.println();
                System.out.print("\t\t");
                System.out.println("--------THE RECORD DOES NOT EXIST--------");
                System.out.println();
                System.out.println("\n\t\t* Press Enter To Return To MainMenu *");
                System.out.print("\t\t\t");
                char ch2 = (char) br.read();
                br.readLine();

                Mainmenu obj = new Mainmenu();
                obj.menu();
            }

            File temp1 = new File("temp1.dat");
            File Event = new File("Event.dat");
            Event.delete();
            boolean success = temp1.renameTo(Event);

            if (success) {
                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Successfully Deleted *");
            } else {
                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Not Successfully Deleted *");
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("* The File Is Not Found *");
        }
    }
}
