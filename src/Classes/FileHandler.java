/**
 * Neil Simmons
 * 1001031670
 */
package Classes;

import Classes.Cargo.*;
import Classes.Ships.*;
import Classes.Docks.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *Loads and saves all the files for the seaport.
 * requires a string to name the files.
 * File names are of the format string.datatype.txt
 */
public class FileHandler {
    
    private Scanner input;
    private Formatter output;
    private File shipFile;      // Ship file
    private File portFile;      // Port file, contains docks and caegos
    private File mapFile;       // Map file
    private final String union = ",";       // used for merging strings

    /**
     * requires a string to name the files, or to load the files
     */
    public FileHandler(String name) {
        this.shipFile = new File(name + ".ship.txt");
        this.portFile = new File(name + ".port.txt");
        this.mapFile = new File(name + ".map.txt");
    }

    /**
     * saves the map to the map file.
     * the map string is generated in the map class
     */
    public void mapSave(String map) throws FileNotFoundException {
        this.output = new Formatter(this.mapFile);
        this.output.format("%s",map);
        this.output.close();
        System.out.println("Map Saved!");
    }
    
    /**
     * reads each line of the map file in, and passes it to the map class
     * for building the map.
     */
    public void mapLoad(Map ptMap) throws FileNotFoundException {
        this.input = new Scanner(this.mapFile);
        String temp;
        while(this.input.hasNext()) {
            temp = this.input.nextLine();
            ptMap.fromString(temp);
        }
        this.input.close();
        System.out.println("Map loaded!");
    }
    
    /**
     * Saves the port to the port file.
     * The port string is built in the Port class
     */
    public void portSave(String port) throws FileNotFoundException {
        this.output = new Formatter(this.portFile);
        this.output.format("%s",port);
        this.output.close();
        System.out.println("Port Saved!");
    }
    
    /**
     * Loads the port from the port file.
     * Much more complicated than the map file.
     * Requires the passing of information to several constructors and 
     * passes completed objects back to the port's arrays.
     */
    public void portLoad(Port ptPort) throws FileNotFoundException {
        this.input = new Scanner(this.portFile);
        String temp;
        String tempArr[];
        int i, docks, cranes, piers, cargo;
        Dock tempDock;
        Cargo tempCargo;
        
        /**
         * The first line of the port file contains the number of docks and
         * cargos the port has.
         */
        temp = this.input.nextLine();
        tempArr = temp.split(",");
        ptPort.setName(tempArr[0]);     // THe docks name
        docks = Integer.parseInt(tempArr[1].trim());    // The number of docks
        cranes = Integer.parseInt(tempArr[2].trim());    // The number of cranes
        piers = Integer.parseInt(tempArr[3].trim());    // The number of piers
        cargo = Integer.parseInt(tempArr[4].trim());    // The number of cargos
        
        /**
         * After the first line, the next lines, if any, are the docks
         * the string is passed to a new dock class object, then appended
         * to the dock array in the port class.
         */
        for(i=0;i<docks;i++) {
            temp = this.input.nextLine();
            tempDock = new Dock(temp);
            ptPort.addDock(tempDock);  
        }
        
        /**
         * After the docks are the cranes.
         * The string is passed to a new dock class object, then appended
         * to the dock array in the port class.
         */
        for(i=0;i<cranes;i++) {
            temp = this.input.nextLine();
            tempDock = new Crane(temp);
            ptPort.addDock(tempDock);  
        }
        
        /**
         * After the cranes are the piers.
         * The string is passed to a new dock class object, then appended
         * to the dock array in the port class.
         */
        for(i=0;i<piers;i++) {
            temp = this.input.nextLine();
            tempDock = new Pier(temp);
            ptPort.addDock(tempDock);  
        }
        
        /**
         * Like the docks the cargo then follows in the file.
         * These lines are passed to a new cargo object, then appended
         * to the cargo array in the port class.
         */
        for(i=0;i<cargo;i++) {
            temp = this.input.nextLine();
            tempCargo = new Cargo(temp);
            ptPort.addCargo(tempCargo);  
        }
        this.input.close();
        System.out.println("Port loaded!");
    }
    
    /**
     * Unlike the other file save functions this one builds the ship save file.
     * This is done by looping through the array of ships and building the string
     * as it goes.
     */
    public void shipSave(ArrayList <Ship>shipArr) throws FileNotFoundException {
        String temp = "";
        int i;
        this.output = new Formatter(this.shipFile);
        /**
         * Construct the string that will become the save file. 
         */
        for(i=0;i<shipArr.size();i++) {
            temp = temp + shipArr.get(i).toString() + "\n";
        }
        this.output.format("%s",temp);
        this.output.close();
        System.out.println("Ships saved!");
    }
    
    /**
     * Works in a similar fashion to the port file loader.
     * Reads in each line of a saved ship file, assigns it to
     * a new ship object, then appends the new ship to the ship array.
     */
    public void shipLoad(ArrayList <Ship>shipArr) throws FileNotFoundException {
        
        String temp;
        Ship tempShip;
        
        if (this.shipFile.exists()) {
            this.input = new Scanner(this.shipFile);
            while(this.input.hasNext()) {
                temp = this.input.nextLine();
                tempShip = new Ship(temp);
                shipArr.add(tempShip);
            }
            this.input.close();

            System.out.println("Ships loaded!");
        }
        else {
            System.out.println("No ship file to load!");
        }
    }
    
}
