import java.io.*;
import java.util.*;

public class search_events {
    String no_people[];
    String date[];
    String venue[];
    String time[];
    String event[];
    String name_chiefguest[];
    int day[];
    int ctr = 0, ct = 0;
    String str;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void search() throws IOException {
        try {
            int n = 1;
            while (n >= 0) {

                System.out.println();
                System.out.println();
                System.out.println();
                System.out.print("\t\t");
                System.out.println("*****************************************");
                System.out.print("\t\t");
                System.out.println("*                                      				     *");
                System.out.print("\t\t");
                System.out.println("*            		~ Search Menu ~                            *");
                System.out.print("\t\t");
                System.out.println("*                                      				     *");
                System.out.print("\t\t");
                System.out.println("*---------------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*     	   1.To Search Records By Date                  *");
                System.out.print("\t\t");
                System.out.println("*---------------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*     	   2.To Search Records By EventName     *");
                System.out.print("\t\t");
                System.out.println("*---------------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*     	3.To Return to MainMenu          	      *");
                System.out.print("\t\t");
                System.out.println("*---------------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*                                     				      *");
                System.out.print("\t\t");
                System.out.println("*****************************************");
                System.out.println();

                Accept_int obj5 = new Accept_int();

                System.out.println();
                System.out.print("\t\t     * ");
                System.out.println("Enter Your Choice <1 TO 3> *");
                System.out.print("\t\t       ");
                String choice = obj5.accept_int(br.readLine());

                int choice1 = Integer.parseInt(choice);
                System.out.println();

                while (choice1 > 3 || choice1 < 1) {
                    System.out.print("\t\t");
                    System.out.println("* Invalid Option Entered So Please Enter Again <1 TO 3> *");
                    System.out.print("\t\t\t");
                    choice = obj5.accept_int(br.readLine());
                    choice1 = Integer.parseInt(choice);
                }

                switch (choice1) {
                case 1: {
                    search_events obj = new search_events();
                    obj.search_date();
                    System.out.println("\n\t\t* Press Enter To Return To Search Menu *");
                    System.out.print("\t\t\t");
                    char ch2 = (char) br.read();
                    br.readLine();
                    search();

                    break;
                }
                case 2: {
                    search_events obj = new search_events();
                    obj.search_by_event();
                    System.out.println("\n\t\t* Press Enter To Return To Search Menu *");
                    System.out.print("\t\t\t");
                    char ch2 = (char) br.read();
                    br.readLine();
                    search();

                    break;
                }
                case 3: {
                    Mainmenu obj = new Mainmenu();
                    obj.menu();
                }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("* The File Is Not Found *");
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.print("\t\t    * ");
            System.out.println("* Invalid Option Entered *");
            search();
        }
    }

    public void search_date() throws IOException {
        try {
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
                time[ct] = s.next();
                event[ct] = s.next();
                venue[ct] = s.next();
                no_people[ct] = s.next();
                name_chiefguest[ct] = s.next();
                Scanner s3 = new Scanner(date[ct]).useDelimiter("/");
                day[ct] = s3.nextInt();
                ct++;
            }

            s2.close();

            int found = 0;
            int total_length = 0;
            String search;

            Scanner s3 = new Scanner(new FileReader("Event.dat"));
            chk_date obj3 = new chk_date();

            System.out.print("\t\t");
            System.out.println(
                    "* Enter Date To Be Searched In The Format Given In Bracket ( Day : 1 To 31  /  1 / 2016 ) *");
            System.out.print("\t\t");
            search = obj3.accept_date(br.readLine());
            System.out.println();

            for (int i = 0; i < date.length; i++) {

                if (search.equalsIgnoreCase(date[i])) {
                    total_length = date[i].length() + 1 + time[i].length() + 1 + event[i].length() + 1
                            + venue[i].length() + 1 + no_people[i].length() + 1 + name_chiefguest[i].length() + 2;

                    System.out.print("\t\t ");
                    for (int j = 0; j < total_length; j++)
                        System.out.print("-");
                    System.out.println();

                    System.out.print("\t\t  ");
                    System.out.print(date[i] + "-");
                    System.out.print(time[i] + "-");
                    System.out.print(event[i] + "-");
                    System.out.print(venue[i] + "-");
                    System.out.print(no_people[i] + "-");
                    System.out.println(name_chiefguest[i]);
                    found = 1;

                    System.out.print("\t\t ");
                    for (int j = 0; j < total_length; j++)
                        System.out.print("-");
                    System.out.println();
                }
            }

            if (found == 0) {
                System.out.println();
                System.out.print("\t\t");
                System.out.println("---------The Record Does Not Exist---------");
            }
            s3.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("* The File Is Not Found *");
        }
    }

    public void search_by_event() throws IOException {
        try {
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
                time[ct] = s.next();
                event[ct] = s.next();
                venue[ct] = s.next();
                no_people[ct] = s.next();
                name_chiefguest[ct] = s.next();
                Scanner s3 = new Scanner(date[ct]).useDelimiter("/");
                day[ct] = s3.nextInt();
                ct++;
            }
            s2.close();
            int found = 0;
            int total_length = 0;
            String search;
            Accept_String obj1 = new Accept_String();
            Scanner s3 = new Scanner(new FileReader("Event.dat"));
            System.out.println();
            System.out.print("\t\t");
            System.out.println("* Enter Name Of The Event To Be Searched *");
            System.out.print("\t\t");
            search = obj1.accept_string(br.readLine());
            ;
            System.out.println();

            for (int i = 0; i < event.length; i++) {

                if (search.equalsIgnoreCase(event[i])) {
                    total_length = date[i].length() + 1 + time[i].length() + 1 + event[i].length() + 1
                            + venue[i].length() + 1 + no_people[i].length() + 1 + name_chiefguest[i].length() + 2;

                    System.out.print("\t\t ");
                    for (int j = 0; j < total_length; j++)
                        System.out.print("-");
                    System.out.println();

                    System.out.print("\t\t  ");
                    System.out.print(date[i] + "-");
                    System.out.print(time[i] + "-");
                    System.out.print(event[i] + "-");
                    System.out.print(venue[i] + "-");
                    System.out.print(no_people[i] + "-");
                    System.out.println(name_chiefguest[i]);
                    found = 1;

                    System.out.print("\t\t ");
                    for (int j = 0; j < total_length; j++)
                        System.out.print("-");
                    System.out.println();
                }
            }

            if (found == 0) {
                System.out.println();
                System.out.print("\t\t");
                System.out.println("---------The Record Does Not Exist---------");
            }
            s3.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("* The File Is Not Found *");
        }
    }
}
