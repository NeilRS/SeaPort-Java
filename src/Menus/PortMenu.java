/**
 * Neil Simmons
 * 1001031670
 */
package Menus;


import Classes.Docks.*;
import Classes.Map;
import Classes.Port;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Port menu class
 */
public class PortMenu {
    
    Scanner input;
    DockMenu dkMenu = new DockMenu(); // Create a dock menu object
    public PortMenu() {
        this.input = new Scanner(System.in);
    }
    
    public void menu(Port ptPort, Map ptMap) throws NullPointerException {
        boolean flag = true; // While loop control
        String answer; // Variable to hold user answers
        
        
        while(flag) {
            System.out.println("Port Menu");
            System.out.println("------------------");
            System.out.println("1. Update Dock");
            System.out.println("2. Unload Ship");
            System.out.println("3. Display all Cargos");
            System.out.println("4. Display all Docks");
            System.out.println("5. Previous Menu");
            System.out.println("-------------------");
            System.out.print("Enter a selection: ");
            answer=input.next();
            
            try {
                switch(answer) {
                    case "1":
                        updateDock(ptPort); // Dock update menu
                        break;
                    case "2":
                        unloadShip(ptPort, ptMap); // Properties menu
                        break;
                    case "3":
                        ptPort.printCargos();
                        break;
                    case "4":
                        ptPort.printDocks();
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
     * Menu for the dock update. This menu displays the current docks, for the user to select one.
     * It then calls the dock properties update menu.
     */
    public void updateDock(Port ptPort) throws NullPointerException {
        int answer;
        
        System.out.printf("Docks");
        System.out.println("------------------");
        ptPort.printDockShort();
        System.out.println("------------------");
        System.out.print("Enter a selection: ");
        
        try {
            answer=input.nextInt();
            dockProp(ptPort.getDock(answer));
        }
        catch (InputMismatchException IME) {
            System.out.println("That was some real bad input!");
            System.out.println("You caused a InputMismatchException!");
            IME.printStackTrace(System.err);
        }
    }
    
    /**
     * dock properties update menu
     */
    private void dockProp(Dock dock) throws NullPointerException{
        boolean flag = true; // While loop control
        String answer; // Variable to hold user answers
        
        if(dock==null) {
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
                        dock.setNumber(Integer.parseInt(answer));
                        System.out.printf("The dock's number is now %s.\n",answer);
                        break;
                    case "2":
                        System.out.print("Enter the length: ");
                        answer=input.next();
                        dock.setLength(Double.parseDouble(answer));
                        System.out.printf("The dock's length is now %s.\n",answer);
                        break;
                    case "3":
                        System.out.print("Enter the width: ");
                        answer=input.next();
                        dock.setWidth(Double.parseDouble(answer));
                        System.out.printf("The dock's width is now %s.\n",answer);
                        break;
                    case "4":
                        System.out.print("Enter the width: ");
                        answer=input.next();
                        dock.setDepth(Double.parseDouble(answer));
                        System.out.printf("The dock's depth is now %s.\n",answer);
                        break;
                    case "5":
                        System.out.print("Enter the latitude in degrees: ");
                        answer=input.next();
                        dock.setLatitude(Double.parseDouble(answer));
                        System.out.printf("The dock's latitude is now %s degrees.\n",answer);
                        System.out.print("Enter the longitude in degrees: ");
                        answer=input.next();
                        dock.setLongitude(Double.parseDouble(answer));
                        System.out.printf("The dock's longitude is now %s degrees.\n",answer);
                        break;
                    case "6":
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
    
    
    public void unloadShip(Port ptPort, Map ptMap) throws NullPointerException {
        int answer;
        
        ptMap.unloadShipPrint();
        try{
            System.out.print("Enter a ship to unload: ");
            answer=input.nextInt();
            ptPort.addCargo(ptMap.unloadShip(answer));
        }
        catch (InputMismatchException IME) {
                System.out.println("That was some real bad input!");
                System.out.println("You caused a InputMismatchException!");
                IME.printStackTrace(System.err);
        }
        
        
        System.out.print("Cargo added!");
    }
    
    
}
