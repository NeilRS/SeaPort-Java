package Menus;

/**
 * Neil Simmons
 * 1001031670
 */

/**
 * Class contains the main menu and a small amount of logic for the report.
 * 
 */

import Classes.ShowStudentID;
import Classes.Map;
import Classes.Port;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MainMenu {
    public Scanner input;

    public MainMenu() {
        this.input = new Scanner(System.in);
    }

    /**
     * The main menu for the program.
     * 
     */
    public void menu() {
        boolean flag = true; // While loop control
        ShowStudentID currentStudent = new ShowStudentID(); // Student class contains my information
        ShipMenu shMenu = new ShipMenu(); // Create a ship menu object
        PortMenu ptMenu = new PortMenu(); // Create a port menu object
        Map ptMap = new Map(); // Create a new instance of a map object
        Port ptPort = new Port(); // Create a new instance of a port object
        String answer; // Variable to hold user answers

        while(flag){
            System.out.println("Main Menu");
            System.out.println("------------------");
            System.out.println("1. Show Student ID");
            System.out.println("2. Load System");
            System.out.println("3. Ship Menu");
            System.out.println("4. Port Menu");            
            System.out.println("5. Show Map");
            System.out.println("6. Display Report");
            System.out.println("");
            System.out.println("8. Quit");
            System.out.println("-------------------");
            System.out.print("Enter a selection: ");
            answer=input.next();

            try {
                switch(answer) {
                    case "1":
                        currentStudent.print(); //Prints my information
                        break;
                    case "2":
                        System.out.print("Enter a tag for your load files: ");
                        answer=input.next();
                        ptMap.load(answer, ptPort);
                        ptPort.load(answer);
                        break;
                    case "3":
                        shMenu.menu(ptMap); // Calls the ship menu object
                        break;
                    case "4":
                        ptMenu.menu(ptPort, ptMap); // Calls the dock menu object
                        break;
                    case "5":
                        ptMap.mapUpdate(ptPort);
                        ptMap.display();
                        break;
                    case "6":
                        ptMap.printShips();
                        System.out.println("");
                        ptPort.printCargos();
                        System.out.println("");
                        ptPort.printDocks();
                        break;
                    /*
                    case "7":
                        System.out.print("Enter a name to save as: ");
                        answer=input.next();
                        ptMap.mapUpdate(ptPort);
                        ptMap.save(answer);
                        ptPort.save(answer);
                        break;
                    */
                    case "8":
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
            catch (NullPointerException nullPE) {
                System.out.println("Inconceivable!");
                System.out.println("You caused a NullPointerException!");
                nullPE.printStackTrace(System.err);
            } 
            catch (FileNotFoundException FNFE) {
                System.out.println("Inconceivable!");
                System.out.println("You caused a FileNotFoundException!");
                FNFE.printStackTrace(System.err);
            }
            catch (InputMismatchException IME) {
                System.out.println("That was some real bad input!");
                System.out.println("You caused a InputMismatchException!");
                IME.printStackTrace(System.err);
            }
            catch (Exception any) {
                System.out.println("This is really embarrassing...");
                System.out.println("You commited a generic error, from which there is no recovery.");
                System.out.println("Soo.. start over, and dont do that anymore.");
                any.printStackTrace(System.err);
            }
        }
    }
}

