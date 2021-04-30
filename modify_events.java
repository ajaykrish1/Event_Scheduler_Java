import java.io.*;
import java.util.*;

public class modify_events {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int found = 0;

    Accept_String obj1 = new Accept_String();
    chk_date obj2 = new chk_date();

    public void modify() throws IOException {
        int n = 1;
        try {
            while (n >= 0) {
                String date1, time1;

                System.out.println();
                System.out.println();
                System.out.println();
                System.out.print("\t\t");
                System.out.println("******************************************");
                System.out.print("\t\t");
                System.out.println("*                                       				        *");
                System.out.print("\t\t");
                System.out.println("*            		  ~ Modify Menu ~                            *");
                System.out.print("\t\t");
                System.out.println("*                                       				        *");
                System.out.print("\t\t");
                System.out.println("*-----------------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*         	       1.To Modify Event                                   *");
                System.out.print("\t\t");
                System.out.println("*-----------------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*          	       2.To Modify Venue           		        *");
                System.out.print("\t\t");
                System.out.println("*-----------------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*          	       3.To Modify Date             		        *");
                System.out.print("\t\t");
                System.out.println("*-----------------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*         	       4.To Return To Main Menu                   *");
                System.out.print("\t\t");
                System.out.println("*-----------------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println(
                        "*                                                                                         *");
                System.out.print("\t\t");
                System.out.println("******************************************");

                Accept_int obj5 = new Accept_int();

                System.out.println();
                System.out.print("\t\t    * ");
                System.out.println("Enter Your Choice <1 TO 4> *");
                System.out.print("\t\t      ");
                String choice = obj5.accept_int(br.readLine());

                int choice1 = Integer.parseInt(choice);

                while (choice1 > 4 || choice1 < 1) {
                    System.out.println();
                    System.out.print("\t\t");
                    System.out.println("* Invalid Option Entered So Please Enter Again <1 TO 4> *");
                    System.out.print("\t\t");
                    choice = obj5.accept_int(br.readLine());
                    choice1 = Integer.parseInt(choice);
                }

                modify_events m = new modify_events();

                chk_time obj3 = new chk_time();

                switch (choice1) {
                case 1: {
                    System.out.println();
                    System.out.print("\t\t");
                    System.out
                            .println("* Enter Date In The Format Given In The Bracket ( Day : 1 To 31 / 1 / 2016 ) *");
                    System.out.print("\t\t");
                    date1 = obj2.accept_date(br.readLine());

                    System.out.println();
                    System.out.print("\t\t");
                    System.out
                            .println("* Enter Time In The Format Given In The Bracket ( Hour < 24 : Minutes < 60 ) *");
                    System.out.print("\t\t");
                    time1 = obj3.accept_time(br.readLine());
                    System.out.println();

                    m.mod_event(date1, time1);

                    System.out.println();
                    System.out.println("\n\t\t* Press Enter To Return To Modify Menu *");
                    System.out.print("\t\t\t");
                    char ch2 = (char) br.read();
                    br.readLine();

                    modify();

                    break;
                }
                case 2: {
                    System.out.println();
                    System.out.print("\t\t");
                    System.out
                            .println("* Enter Date In The Format Given In The Bracket ( Day : 1 To 31 / 1 / 2016 ) *");
                    System.out.print("\t\t");
                    date1 = obj2.accept_date(br.readLine());

                    System.out.println();
                    System.out.print("\t\t");
                    System.out
                            .println("* Enter Time In The Format Given In The Bracket ( Hour < 24 : Minutes < 60 ) *");
                    System.out.print("\t\t");
                    time1 = obj3.accept_time(br.readLine());
                    System.out.println();

                    m.mod_venue(date1, time1);

                    System.out.println();
                    System.out.println("\n\t\t* Press Enter To Return To Modify Menu *");
                    System.out.print("\t\t\t");
                    char ch2 = (char) br.read();
                    br.readLine();
                    modify();

                    break;
                }
                case 3: {
                    System.out.println();
                    System.out.print("\t\t");
                    System.out
                            .println("* Enter Date In The Format Given In The Bracket ( Day : 1 To 31 / 1 / 2016 ) *");
                    System.out.print("\t\t");
                    date1 = obj2.accept_date(br.readLine());

                    System.out.println();
                    System.out.print("\t\t");
                    System.out
                            .println("* Enter Time In The Format Given In The Bracket ( Hour < 24 : Minutes < 60 ) *");
                    System.out.print("\t\t");
                    time1 = obj3.accept_time(br.readLine());
                    System.out.println();

                    m.mod_date(date1, time1);

                    System.out.println();
                    System.out.println("\n\t\t* Press Enter To Return To Modify Menu *");
                    System.out.print("\t\t\t");
                    char ch2 = (char) br.read();
                    br.readLine();
                    modify();

                    break;
                }
                case 4: {
                    Mainmenu obj = new Mainmenu();
                    obj.menu();
                }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.print("\t\t    * ");
            System.out.println("* Invalid Option Entered *");
            modify();
        }
    }

    public void mod_event(String date1, String time1) throws IOException {
        try {
            Scanner s = new Scanner(new FileReader("Event.dat"));
            PrintWriter pw = new PrintWriter(new FileWriter("temp1.dat"));

            String str, new_event;
            String time, event, venue, name_chiefguest, date, no_people;
            int total_length = 0;

            while (s.hasNextLine()) {
                str = s.nextLine();
                Scanner s1 = new Scanner(str).useDelimiter("-");
                date = s1.next();
                time = s1.next();

                if (date1.equalsIgnoreCase(date) && time1.equalsIgnoreCase(time)) {
                    event = s1.next();
                    venue = s1.next();
                    no_people = s1.next();
                    name_chiefguest = s1.next();

                    total_length = 24 + event.length();

                    System.out.print("\t\t ");
                    for (int j = 0; j < total_length; j++)
                        System.out.print("-");
                    System.out.println();

                    System.out.print("\t\t  ");
                    System.out.println("The Existing Event Is " + event);
                    System.out.print("\t\t ");
                    for (int j = 0; j < total_length; j++)
                        System.out.print("-");
                    System.out.println();

                    System.out.println();
                    System.out.print("\t\t");
                    System.out.println("* Enter The New Modified Event *");
                    System.out.print("\t\t");
                    new_event = obj1.accept_string(br.readLine());
                    pw.println(date + "-" + time + "-" + new_event + "-" + venue + "-" + no_people + "-"
                            + name_chiefguest);
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
                System.out.println("*---------The Record Does Not Exist---------*");
                System.out.println();

                System.out.println("\n\t\t* Press Enter To Return To Modify Menu *");
                System.out.print("\t\t\t");
                char ch2 = (char) br.read();
                br.readLine();
                modify_events obj = new modify_events();
                obj.modify();
            }

            File temp1 = new File("temp1.dat");
            File Event = new File("Event.dat");
            Event.delete();
            boolean success = temp1.renameTo(Event);
            if (success) {
                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Successfully Renamed *");
            } else {
                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Not Successfully Renamed *");
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("* The File Is Not Found *");
        }
    }

    public void mod_venue(String date1, String time1) throws IOException {
        try {
            Scanner s = new Scanner(new FileReader("Event.dat"));
            PrintWriter pw = new PrintWriter(new FileWriter("temp1.dat"));

            String str, new_venue;
            String time, event, venue, name_chiefguest, date, no_people;
            int total_length = 0;

            while (s.hasNextLine()) {
                str = s.nextLine();
                Scanner s1 = new Scanner(str).useDelimiter("-");
                date = s1.next();
                time = s1.next();

                if (date1.equalsIgnoreCase(date) && time1.equalsIgnoreCase(time)) {
                    event = s1.next();
                    venue = s1.next();
                    no_people = s1.next();
                    name_chiefguest = s1.next();

                    total_length = 24 + venue.length();

                    System.out.print("\t\t ");
                    for (int j = 0; j < total_length; j++)
                        System.out.print("-");
                    System.out.println();

                    System.out.print("\t\t  ");
                    System.out.println("The Existing Event Is " + venue);

                    System.out.print("\t\t ");
                    for (int j = 0; j < total_length; j++)
                        System.out.print("-");
                    System.out.println();

                    System.out.println();
                    System.out.print("\t\t");
                    System.out.println("* Enter The New Modifeied Venue *");
                    System.out.print("\t\t");
                    new_venue = obj1.accept_string(br.readLine());
                    pw.println(date + "-" + time + "-" + event + "-" + new_venue + "-" + no_people + "-"
                            + name_chiefguest);
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
                System.out.println("*---------The Record Does Not Exist---------*");
                System.out.println();

                System.out.println("\n\t\t* Press Enter To Return To Modify Menu *");
                System.out.print("\t\t\t");
                char ch2 = (char) br.read();
                br.readLine();
                modify_events obj = new modify_events();
                obj.modify();
            }

            File temp1 = new File("temp1.dat");
            File Event = new File("Event.dat");
            Event.delete();
            boolean success = temp1.renameTo(Event);
            if (success) {
                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Successfully Renamed *");
            } else {
                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Not Successfully Renamed *");
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("* The File Is Not Found *");
        }
    }

    public void mod_date(String date1, String time1) throws IOException {
        try {
            Scanner s = new Scanner(new FileReader("Event.dat"));
            PrintWriter pw = new PrintWriter(new FileWriter("temp1.dat"));

            String str, new_date;
            String time, event, venue, name_chiefguest, date, no_people;
            int total_length = 0;

            while (s.hasNextLine()) {
                str = s.nextLine();
                Scanner s1 = new Scanner(str).useDelimiter("-");
                date = s1.next();
                time = s1.next();

                if (date1.equalsIgnoreCase(date) && time1.equalsIgnoreCase(time)) {

                    event = s1.next();
                    venue = s1.next();
                    no_people = s1.next();
                    name_chiefguest = s1.next();

                    total_length = 24 + date.length();

                    System.out.print("\t\t ");
                    for (int j = 0; j < total_length; j++)
                        System.out.print("-");
                    System.out.println();

                    System.out.print("\t\t  ");
                    System.out.println("The Existing Event Is " + date);

                    System.out.print("\t\t ");
                    for (int j = 0; j < total_length; j++)
                        System.out.print("-");
                    System.out.println();

                    System.out.println();
                    System.out.print("\t\t");
                    System.out.println("* Enter The New Modifeid Date *");
                    System.out.print("\t\t");
                    new_date = obj2.accept_date(br.readLine());
                    pw.println(new_date + "-" + time + "-" + event + "-" + venue + "-" + no_people + "-"
                            + name_chiefguest);
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
                System.out.println("*---------The Record Does Not Exist---------*");
                System.out.println();

                System.out.println("\n\t\t* Press Enter To Return To Modify Menu *");
                System.out.print("\t\t\t");
                char ch2 = (char) br.read();
                br.readLine();
                modify_events obj = new modify_events();
                obj.modify();
            }

            File temp1 = new File("temp1.dat");
            File Event = new File("Event.dat");
            Event.delete();
            boolean success = temp1.renameTo(Event);
            if (success) {
                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Successfully Renamed *");
            } else {
                System.out.println();
                System.out.print("\t\t");
                System.out.println("* Not Successfully Renamed *");
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("* The File Is Not Found *");
        }
    }
}
