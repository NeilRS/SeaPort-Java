package Menus;

/**
 * Neil Simmons
 * 1001031670
 */

/**
 * Menu and sub menus for Dock class objects.
 * Allows the user to create and update the settings for a Dock class object. 
 */

import Classes.Docks.Dock;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DockMenu {
    Scanner input;
    Dock newDock = null; // Create a null dock variable 
    public DockMenu() {
        this.input = new Scanner(System.in);
    }
    
    public void menu() throws NullPointerException{
        boolean flag = true; // While loop control
        String answer; // Variable to hold user answers
        
        
        while(flag) {
            System.out.println("Dock Menu");
            System.out.println("------------------");
            System.out.println("1. Allocate Memory for Dock");
            System.out.println("2. Update Dock");
            System.out.println("3. Set Dock to Null");
            System.out.println("4. Display the Dock");
            System.out.println("5. Previous Menu");
            System.out.println("-------------------");
            System.out.print("Enter a selection: ");
            answer=input.next();
            
            try {
                switch(answer) {
                    case "1":
                        makeMem(); // Allocate memory
                        break;
                    case "2":
                        dockProp(); // Properties menu
                        break;
                    case "3":
                        dockNull(); // Set to null
                        break;
                    case "4":
                        dockDisp(); // Display current setting
                        break;
                    case "5":
                        flag = false; // Exit
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
            catch (InputMismatchException IME) {
                System.out.println("That was some real bad input!");
                System.out.println("You caused a InputMismatchException!");
                IME.printStackTrace(System.err);
            }
        }    
    }
    
    /**
     * If there is a dock warn the user, otherwise allocate memory for a dock.
     */
    public void makeMem() throws NullPointerException{
        if(newDock!=null) {
            System.out.println("YOU ALREADY HAVE A DOCK! Be happy with what you have!");
        }
        else {
            newDock = new Dock();
            System.out.println("Memory has been allocated for a dock!");
        }
        
    }
    
    /**
     * Menu to edit the dock properties. Ensures the dock has memory allocated first.
     */
    private void dockProp()  throws NullPointerException{
        boolean flag = true; // While loop control
        String answer; // Variable to hold user answers
        
        if(newDock==null) {
            System.out.println("THERE IS NO DOCK! Make a dock!");
            flag = false;
        }
            
            
        while(flag) {
            System.out.println("Dock Properties Menu");
            System.out.println("------------------");
            System.out.println("1. Set the number");
            System.out.println("2. Set the length");
            System.out.println("3. Set the width");
            System.out.println("4. Set the depth");
            System.out.println("5. Set longitude and latitude");
            System.out.println("6. Previous Menu");
            System.out.println("-------------------");
            System.out.print("Enter a selection: ");
            answer=input.next();
            
            try {
                switch(answer) {
                    case "1":
                        System.out.print("Enter a number: ");
                        answer=input.next();
                        newDock.setNumber(Integer.parseInt(answer));
                        System.out.printf("The dock's number is now %s.\n",answer);
                        break;
                    case "2":
                        System.out.print("Enter the length: ");
                        answer=input.next();
                        newDock.setLength(Double.parseDouble(answer));
                        System.out.printf("The dock's length is now %s.\n",answer);
                        break;
                    case "3":
                        System.out.print("Enter the width: ");
                        answer=input.next();
                        newDock.setWidth(Double.parseDouble(answer));
                        System.out.printf("The dock's width is now %s.\n",answer);
                        break;
                    case "4":
                        System.out.print("Enter the width: ");
                        answer=input.next();
                        newDock.setDepth(Double.parseDouble(answer));
                        System.out.printf("The dock's depth is now %s.\n",answer);
                        break;
                    case "5":
                        System.out.print("Enter the latitude in degrees: ");
                        answer=input.next();
                        newDock.setLatitude(Double.parseDouble(answer));
                        System.out.printf("The dock's latitude is now %s degrees.\n",answer);
                        System.out.print("Enter the longitude in degrees: ");
                        answer=input.next();
                        newDock.setLongitude(Double.parseDouble(answer));
                        System.out.printf("The dock's longitude is now %s degrees.\n",answer);
                        break;
                    case "8":
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
            catch (InputMismatchException IME) {
                System.out.println("That was some real bad input!");
                System.out.println("You caused a InputMismatchException!");
                IME.printStackTrace(System.err);
            }
        }        
    }
    
    /**
     * Set the dock variable to null
     */
    private void dockNull() throws NullPointerException{
        newDock = null;
        System.out.println("The dock is now gone.");
    }
    
    /**
     * Prints the dock information using its inbuilt print function.
     */
    private void dockDisp() throws NullPointerException{
        newDock.print();
    } 
    
    
}
