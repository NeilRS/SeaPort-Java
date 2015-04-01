package Menus;

/**
 * Neil Simmons
 * 1001031670
 */

/**
 * Menu and sub menus for Ship class objects.
 * Allows the user to create and update the settings for a Ship class object. 
 */

import Classes.Ships.*;
import Classes.Map;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShipMenu {
    Scanner input;
    public ShipMenu() {
        this.input = new Scanner(System.in);
    }
    

    
    public void menu(Map ptMap)throws NullPointerException {
        boolean flag = true; // While loop control
        String answer; // Variable to hold user answers
        
        
        while(flag) {
            System.out.println("Ship Menu");
            System.out.println("------------------");
            System.out.println("1. Generate Ships");
            System.out.println("2. Update Ship");
            System.out.println("3. Display the Ships");
            System.out.println("4. Remove All Ships");
            System.out.println("5. Previous Menu");
            System.out.println("-------------------");
            System.out.print("Enter a selection: ");
            answer=input.next();
            
            try {
                switch(answer) {
                    case "1":
                        ptMap.genShips(); // calls the ship generation function
                        break;
                    case "2":
                        shipUpdate(ptMap); // Properties menu
                        break;
                    case "3":
                        if(ptMap.getShipArrSize() > 0) {
                            ptMap.printShips();
                        }
                        else {
                            System.out.println("THERE ARE NO SHIPS! Make some ships!!!");
                        }
                        break;
                    case "4":
                        ptMap.deleteShipArr(); // Deletes the current ships
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
    
    private void shipUpdate(Map ptMap) throws NullPointerException {
        int answer; // Variable to hold user answers
        
        if(ptMap.getShipArrSize() > 0) {
            ptMap.printShips();
            System.out.print("Which ship would you like to edit: ");
            answer=input.nextInt();
            shipProp(ptMap.getShip(answer));
        }
        else {
            System.out.println("THERE ARE NO SHIPS! Make some ships!!!");
        }
    }
  
    /**
     * Menu to edit the ship properties. Ensures the dock has memory allocated first.
     */
    private void shipProp(Ship ship) throws NullPointerException{
        boolean flag = true; // While loop control
        String answer; // Variable to hold user answers
        

            
            
        while(flag) {
            System.out.println("Ship Properties Menu");
            System.out.println("------------------");
            System.out.println("1. Update Name");
            System.out.println("2. Update Registration");
            System.out.println("3. Update Transponder");
            System.out.println("4. Update Capacity");
            System.out.println("5. Update Length");
            System.out.println("6. Update Beam");
            System.out.println("7. Update Draft");
            System.out.println("8. Update Longitude and Latitude");
            System.out.println("9. Update Cargo");
            System.out.println("10. Display the Ship");
            System.out.println("11. Previous Menu");
            System.out.println("-------------------");
            System.out.print("Enter a selection: ");
            answer=input.next();
            
            try {
                switch(answer) {
                    case "1":
                        System.out.print("Enter a name: ");
                        answer=input.next();
                        ship.setName(answer);
                        System.out.printf("The ships name is now %s.\n",answer);
                        break;
                    case "2":
                        System.out.print("Enter the registration: ");
                        answer=input.next();
                        ship.setCountryOfRegistration(answer);
                        System.out.printf("The ships registration is now %s.\n",answer);
                        break;
                    case "3":
                        System.out.print("Enter the transponder: ");
                        answer=input.next();
                        ship.setTransponder(Long.parseLong(answer));
                        System.out.printf("The ships transponder is now %s.\n",answer);
                        break;
                    case "4":
                        if (ship instanceof ContainerShip) {
                            System.out.print("Enter the number of holds: ");
                            answer=input.next();
                            ((ContainerShip)ship).setHolds(Integer.parseInt(answer));
                            System.out.printf("The ships number of holds is now %s.\n",answer);
                            
                        }
                        else if (ship instanceof OilTanker) {
                            System.out.print("Enter the oil capacity in barrels: ");
                            answer=input.next();
                            ((OilTanker)ship).setOilCapacity(Double.parseDouble(answer));
                            System.out.printf("The ships oil capacity is now %s barrels.\n",answer); 
                        }
                        else {
                            System.out.print("Enter the capacity in tons: ");
                            answer=input.next();
                            ship.setCargoCapacity(Double.parseDouble(answer));
                            System.out.printf("The ships capacity is now %s tons.\n",answer);           
                        }
                        break; 
                    case "5":
                        System.out.print("Enter the length in meters: ");
                        answer=input.next();
                        ship.setLength(Double.parseDouble(answer));
                        System.out.printf("The ships length is now %s meters.\n",answer);
                        break;
                    case "6":
                        System.out.print("Enter the beam in meters: ");
                        answer=input.next();
                        ship.setBeam(Double.parseDouble(answer));
                        System.out.printf("The ships beam is now %s meters.\n",answer);
                        break;
                    case "7":
                        System.out.print("Enter the draft in meters: ");
                        answer=input.next();
                        ship.setDraft(Double.parseDouble(answer));
                        System.out.printf("The ships draft is now %s meters.\n",answer);
                        break;
                    case "8":
                        System.out.print("Enter the latitude in degrees: ");
                        answer=input.next();
                        ship.setLatitude(Double.parseDouble(answer));
                        System.out.printf("The ships latitude is now %s degrees.\n",answer);
                        System.out.print("Enter the longitude in degrees: ");
                        answer=input.next();
                        ship.setLongitude(Double.parseDouble(answer));
                        System.out.printf("The ships longitude is now %s degrees.\n",answer);
                        break;
                    case "9":
                        shipPropCargo(ship);
                        break;
                    case "10":
                        ship.print();
                        break;
                    case "11":
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
     * Menu to edit the Cargo class object that is embedded within the Ship class.
     */
    private void shipPropCargo(Ship ship) throws NullPointerException{
        boolean flag = true; // While loop control
        String answer; // Variable to hold user answers
        
        //Update for new class types
        
        while(flag) {
            System.out.println("Cargo Properties Menu");
            System.out.println("---------------------");
            System.out.println("1. Update Description");
            System.out.println("2. Update Quantity");
            System.out.println("3. Display Cargo");
            System.out.println("4. Previous Menu");
            System.out.println("---------------------");
            System.out.print("Enter a selection: ");
            answer=input.next();
            
            try {
                switch(answer) {
                    case "1":
                        System.out.print("Enter the description: ");
                        answer=input.next();
                        ship.setCargoDescription(answer);
                        System.out.printf("The ships cargo description is now %s.\n",answer);
                        break;
                    case "2":
                        if (ship.cargoType() == 1) {
                            System.out.printf("Enter the amount of %s, in barrals, the ship is loaded with: ", ship.getCargoDescription());
                            answer=input.next();
                            ((OilTanker)ship).setOilQuantity(Integer.parseInt(answer));
                            System.out.printf("The ships cargo weight is now %s barrels.\n",answer);
                            
                        }
                        else if (ship.cargoType() == 2) {
                            System.out.printf("Enter the amount of %s, in TEUs, the ship is loaded with: ", ship.getCargoDescription());
                            answer=input.next();
                            ((ContainerShip)ship).setBoxTeu(Integer.parseInt(answer));
                            System.out.printf("The ships cargo is now %s TEUs.\n",answer); 
                        }
                        else {
                            System.out.printf("Enter the amount of %s, in tons, the ship is loaded with: ", ship.getCargoDescription());
                            answer=input.next();
                            ship.setCargoWeight(Double.parseDouble(answer));
                            System.out.printf("The ships cargo weight is now %s tons.\n",answer);           
                        }
                        break;
                    case "3":
                        ship.printCargo();
                        break;
                    case "4":
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
}