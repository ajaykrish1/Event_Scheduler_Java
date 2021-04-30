import java.io.*;
import java.util.*;

public class view_events {
    public void view() throws IOException {
        try {

            String no_people[];
            String date[];
            String venue[];
            String time[];
            String event[];
            String name_chiefguest[];
            int day[];
            int ctr = 0, ct = 0;
            String str = "";
            int length_event = 0, length_people = 0, length_guest = 0, length_venue = 0, total_length = 0,
                    length_date = 0, length_time = 0;

            Scanner s1 = new Scanner(new FileReader("Event.dat"));

            while (s1.hasNextLine()) {
                s1.nextLine();
                ctr++;
            }

            s1.close();

            Scanner s2 = new Scanner(new FileReader("Event.dat"));
            day = new int[ctr];
            date = new String[ctr];
            venue = new String[ctr];
            event = new String[ctr];
            time = new String[ctr];
            name_chiefguest = new String[ctr];
            no_people = new String[ctr];

            while (s2.hasNextLine()) {
                str = s2.nextLine();
                Scanner s = new Scanner(str).useDelimiter("-");

                date[ct] = s.next();
                if (length_date < date[ct].length()) {
                    length_date = date[ct].length();
                }

                time[ct] = s.next();
                if (length_time < time[ct].length()) {
                    length_time = time[ct].length();
                }

                event[ct] = s.next();
                if (length_event < event[ct].length()) {
                    length_event = event[ct].length();
                }

                venue[ct] = s.next();
                if (length_venue < venue[ct].length()) {
                    length_venue = venue[ct].length();
                }

                no_people[ct] = s.next();
                if (length_people < no_people[ct].length()) {
                    length_people = no_people[ct].length();
                }

                name_chiefguest[ct] = s.next();
                if (length_guest < name_chiefguest[ct].length()) {
                    length_guest = name_chiefguest[ct].length();
                }

                Scanner s3 = new Scanner(date[ct]).useDelimiter("/");
                day[ct] = s3.nextInt();
                ct++;
            }

            String temp;
            int temp1;
            if (ctr > 1) {
                for (int i = 0; i < date.length; i++) {
                    for (int k = 0; k < date.length - 1; k++) {

                        if (day[k] > day[k + 1]) {

                            temp1 = day[k];
                            day[k] = day[k + 1];
                            day[k + 1] = temp1;

                            temp = date[k];
                            date[k] = date[k + 1];
                            date[k + 1] = temp;

                            temp = time[k];
                            time[k] = time[k + 1];
                            time[k + 1] = temp;

                            temp = event[k];
                            event[k] = event[k + 1];
                            event[k + 1] = temp;

                            temp = venue[k];
                            venue[k] = venue[k + 1];
                            venue[k + 1] = temp;

                            temp = no_people[k];
                            no_people[k] = no_people[k + 1];
                            no_people[k + 1] = temp;

                            temp = name_chiefguest[k];
                            name_chiefguest[k] = name_chiefguest[k + 1];
                            name_chiefguest[k + 1] = temp;
                        }
                    }
                }
            }
            if (length_event < 5)
                length_event = 5;

            if (length_venue < 5)
                length_venue = 5;

            if (length_people < 12)
                length_people = 12;

            if (length_guest < 22)
                length_guest = 22;

            total_length = length_event + 1 + length_venue + 1 + length_guest + 1 + length_people + 1 + length_date + 1
                    + length_time + 1 + 13;
            System.out.println();

            System.out.print("   ");
            for (int j = 0; j < total_length; j++)
                System.out.print("*");
            System.out.println();

            for (int i = 0; i < date.length; i++) {
                if (i == 0) {

                    System.out.print("   ");
                    System.out.print("*");
                    System.out.print(" ");
                    System.out.print("DATE");
                    for (int i1 = 0; i1 < (length_date + 1) - 4; i1++)
                        System.out.print(" ");

                    System.out.print("*");
                    System.out.print(" ");
                    System.out.print("TIME");
                    for (int i1 = 0; i1 < (length_time + 1) - 4; i1++)
                        System.out.print(" ");

                    System.out.print("*");
                    System.out.print(" ");
                    System.out.print("EVENT");
                    for (int i1 = 0; i1 < (length_event + 1) - 5; i1++)
                        System.out.print(" ");

                    System.out.print("*");
                    System.out.print(" ");
                    System.out.print("VENUE");
                    for (int i1 = 0; i1 < (length_venue + 1) - 5; i1++)
                        System.out.print(" ");

                    System.out.print("*");
                    System.out.print(" ");
                    System.out.print("NO OF PEOPLE");
                    for (int i1 = 0; i1 < (length_people + 1) - 12; i1++)
                        System.out.print(" ");

                    System.out.print("*");
                    System.out.print(" ");
                    System.out.print("NAME OF THE CHIEFGUEST");
                    for (int i1 = 0; i1 < (length_guest + 1) - 22; i1++)
                        System.out.print(" ");

                    System.out.print("*");

                    System.out.println();

                    System.out.print("   ");
                    for (int j = 0; j < total_length; j++)
                        System.out.print("*");
                    System.out.println();
                }

                System.out.print("   ");
                System.out.print("*");
                System.out.print(" ");
                System.out.print(date[i]);
                for (int i1 = 0; i1 < (length_date + 1) - date[i].length(); i1++)
                    System.out.print(" ");

                System.out.print("*");
                System.out.print(" ");
                System.out.print(time[i]);
                for (int i1 = 0; i1 < (length_time + 1) - time[i].length(); i1++)
                    System.out.print(" ");

                System.out.print("*");
                System.out.print(" ");
                System.out.print(event[i]);
                for (int i1 = 0; i1 < (length_event + 1) - event[i].length(); i1++)
                    System.out.print(" ");

                System.out.print("*");
                System.out.print(" ");
                System.out.print(venue[i]);
                for (int i1 = 0; i1 < (length_venue + 1) - venue[i].length(); i1++)
                    System.out.print(" ");

                System.out.print("*");
                System.out.print(" ");
                System.out.print(no_people[i]);
                for (int i1 = 0; i1 < (length_people + 1) - no_people[i].length(); i1++)
                    System.out.print(" ");

                System.out.print("*");
                System.out.print(" ");
                System.out.print(name_chiefguest[i]);
                for (int i1 = 0; i1 < (length_guest + 1) - name_chiefguest[i].length(); i1++)
                    System.out.print(" ");
                System.out.print("*");
                System.out.println();
            }
            System.out.print("   ");
            for (int i = 0; i < total_length; i++)
                System.out.print("*");

            s2.close();
        } catch (FileNotFoundException e) {
            System.out.println("* The File Is Not Found *");
        }
    }
}
