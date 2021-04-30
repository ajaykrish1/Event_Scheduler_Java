import java.io.*;
import java.util.*;

public class Mainmenu {

    int n = 1;
    String choice;

    public void menu() throws IOException {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (n >= 0) {

                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.print("\t");
                System.out.println("---------------------------------------------------------------------");
                System.out.print("\t");
                System.out.println("|                                  EVENT SCHEDULE             |");
                System.out.print("\t");
                System.out.println(
                        "|                                                                	             	          |");
                System.out.print("\t");
                System.out.println("|                                                                    |");
                System.out.print("\t");
                System.out.println("---------------------------------------------------------------------");
                System.out.println();
                System.out.println();
                System.out.print("\t\t");
                System.out.println("*----------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*                                    			            *");
                System.out.print("\t\t");
                System.out.println("*           	      ~ Main Menu ~            	            *");
                System.out.print("\t\t");
                System.out.println("*                                     			            *");
                System.out.print("\t\t");
                System.out.println("*----------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*        	 1.To Add Events                                   *");
                System.out.print("\t\t");
                System.out.println("*----------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*        	 2.To View all the Events        	            *");
                System.out.print("\t\t");
                System.out.println("*----------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*        	 3.To Search the Events       	            *");
                System.out.print("\t\t");
                System.out.println("*----------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*        	 4.To Modify The Events     	            *");
                System.out.print("\t\t");
                System.out.println("*----------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*        	 5.To Delete The Events     	            *");
                System.out.print("\t\t");
                System.out.println("*----------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*       	  6.To Exit                   	       	            *");
                System.out.print("\t\t");
                System.out.println("*----------------------------------------------------------*");
                System.out.print("\t\t");
                System.out.println("*                                    		     	            *");
                System.out.print("\t\t");
                System.out.println("*----------------------------------------------------------*");
                System.out.println();

                Accept_int obj5 = new Accept_int();

                System.out.print("\t\t    * ");
                System.out.println("Enter Your Choice <1 TO 6> *");
                System.out.print("\t\t      ");
                choice = obj5.accept_int(br.readLine());

                System.out.println();
                int choice1 = Integer.parseInt(choice);

                while (choice1 > 6 || choice1 < 1) {

                    System.out.print("\t\t");
                    System.out.println("* Invalid Option Entered So Please Enter Again <1 TO 6> *");
                    System.out.print("\t\t");
                    choice = obj5.accept_int(br.readLine());
                    choice1 = Integer.parseInt(choice);

                }

                switch (choice1) {

                case 1: {

                    add_events obj = new add_events();
                    obj.add();

                    System.out.println("\n\t\t* Press Enter To Return To MainMenu *");
                    System.out.print("\t\t\t");
                    char ch2 = (char) br.read();
                    br.readLine();
                    menu();
                    break;

                }
                case 2: {

                    view_events obj1 = new view_events();
                    obj1.view();

                    System.out.println();
                    System.out.println("\n\t\t* Press Enter To Return To MainMenu *");
                    System.out.print("\t\t\t");
                    char ch2 = (char) br.read();
                    br.readLine();
                    menu();
                    break;

                }
                case 3: {

                    search_events obj2 = new search_events();
                    obj2.search();
                    break;

                }
                case 4: {

                    modify_events obj3 = new modify_events();
                    obj3.modify();
                    break;

                }
                case 5: {

                    delete_events obj4 = new delete_events();
                    obj4.delete_record();

                    System.out.println("\n\t\t* Press Enter To Return To MainMenu *");
                    System.out.print("\t\t\t");
                    char ch2 = (char) br.read();
                    br.readLine();
                    menu();

                }
                case 6: {

                    System.exit(0);
                    break;

                }

                }
            }

        }

        catch (NumberFormatException e) {
            System.out.println();
            System.out.print("\t\t    * ");
            System.out.println("* Invalid Option Entered *");
            menu();
        }

    }

    public static void main(String Args[]) throws IOException {

        Mainmenu obj = new Mainmenu();
        obj.menu();

    }
}