package Classes;
/**
 * Neil Simmons
 * 1001031670
 */
import Classes.Cargo.*;
import Classes.Ships.*;
import Classes.Docks.*;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Map class. Contains.... the entire world, essentially.
 */
public class Map {
    
    private ArrayList <Ship>shipArr=new ArrayList<>();  // Holds the ships!
    
    /**
     * Map variables, They mean exactly what they are named. Convenient!
     */
    private final static char water = '.';
    private final static char land = '*';
    private final static char ship = 'S';
    private final static char containerShip = 'B';
    private final static char tankerShip = 'T';
    private final static char shipInDock = '$';
    private final static char shipInDanger = 'X';
    private final static char emptyDock = 'D';
    private final static char emptyPier = 'P';
    private final static char emptyCrane = 'C';
    
    private char map[][]; // The map
    Scanner input;

    /**
     * Map constructor. No arguments required.
     */
    public Map() {
        this.map = new char[54][36]; // Defines the map
        this.input = new Scanner(System.in);
        this.shipArr.add(null); // Ensures there is something in the ship array.
    }
    
    
    /**
     * Returns the number of ships
     */
    public int getShipArrSize() {
        return shipArr.size();
    }
    
    /**
     * Clears the ship array
     */
    public void deleteShipArr() {
        shipArr.clear();
    }
    
    /**
     * Returns a specific ship from the ship array.
     */
    public Ship getShip(int index) {
        return shipArr.get(index);
    }

    /**
     * Retruns a boolean if the provided longitude and latitude are
     * not on the land, meaning it is probably safe for a ship to be there.
     */
    public boolean atSeaOrDock(double longitude, double latitude) {
        int latRow, lonCol;
        latRow = MapConverter.lat2row(latitude);
        lonCol = MapConverter.lon2col(longitude);
        return (map[lonCol][latRow] != land);

    }

    /**
     * Print the current ships from the ship array
     */
    public void printShips() {
        int i;
        System.out.println("Current Ships");
        System.out.println("------------------");
        //Loop through the aray, printing each ship.
        for(i=0;i<shipArr.size();i++) {
            System.out.printf("%d. %s\n",i,shipArr.get(i).getName());
        }
        System.out.println("-------------------");
    }
    
    /**
     * Generate a random assortment of ships.
     * 
     */
    public void genShips(){
        int answer = 0; // Holds the number of ships to be made
        int randy;      // Holder of a random integer
        double randyLon, randyLat;  // Holds random doubles for test porpises
        long randyTran; // Holds a random transponder number
        long tranMin = 1000000;     // The minimum transponder number
        long tranMax = 9999999;     // The maximum transponder number
        int i;  // for loop control
        boolean flag = true; // While loop control
        Random rand = new Random(); // For making things psudo random!
        Ship tempShip;      // a temporary ship object
        String newShipName;
        
        /**
         * 2D array of potential ship names
         */
        String shipNames[][] = new String[][]{
            {"Red","Green","Dark","Light","Day","Night","Savanah","Mountain","Captain's","Admiral's"},
            {"Buffalo","Pastures","Knight","Wave","Star","Moon","Lion","Goat","Pride","Joy"}};
        
        /**
         * Find out how many ships the user would like to make.
         */
        while(flag) {
            System.out.println("How many ships would you like to create?");
            System.out.print("Enter a number between 1 and 10: ");

            /**
             * Some error control. The user can not request more than 10 ships be made
             */
            try {
                answer = input.nextInt();
                
                if(answer <= 10 && answer >= 1) {
                    flag = false;
                }
                else {
                    System.out.printf("Is %d between 1 and 10?\n",answer);
                }
            }
            catch (InputMismatchException inputMismatchException) {
                System.out.println("I'm sure your fingur just slipped.");
                System.out.println("Try to input a number this time, k?");
                inputMismatchException.printStackTrace(System.err);
            }
            catch (Exception general) {
                System.out.println("I... I dont know what happened.");
                System.out.println("Try again...");
                general.printStackTrace(System.err);
            }
        }
        
        shipArr.clear(); // Ensure the ship array is empty
        
        /**
         * Make the number of ships the user requested
         */
        for(i=0;i<answer;i++) {
            // Create a temporary new ship
            randy = rand.nextInt(2);
            switch(randy) {
                case 0:
                    tempShip = new Ship();
                    break;
                case 1:
                    tempShip = new ContainerShip();
                    break;
                default:
                    tempShip = new OilTanker();
                    break;
            }
            
            
            /**
             * Loop to find random latitude and longitude that are not land. 
             * Keeps looping until this is true.
             */
            flag = true;
            while(flag) {
                randyLon = MapConverter.col2lon(rand.nextInt(54));
                randyLat = MapConverter.row2lat(rand.nextInt(36));
                // Ensure the random values are not on dry land
                if(atSeaOrDock(randyLon,randyLat)) {
                    // If the values are not dry land then assigne them to the new ship
                    tempShip.setLongitude(randyLon);
                    tempShip.setLatitude(randyLat);
                    flag = false;
                }
            }
            
            // Generate the ships name by pulling randomly from the 2D array
            randy = rand.nextInt(10);
            newShipName = shipNames[0][randy];
            randy = rand.nextInt(10);
            newShipName = newShipName + " " + shipNames[1][randy];
            tempShip.setName(newShipName);
            
            // Generate a random transponder number
            randyTran = ((long)(rand.nextDouble()*(tranMax-tranMin)))+tranMin;
            tempShip.setTransponder(randyTran);
            
            // Assign the new ship to the ship array
            shipArr.add(tempShip);
        }  
        
    }
    
    /**
     * Check a ship against the map to see if it safe in a dock
     */
    public boolean safeInDock(Ship ship) throws NullPointerException {
        int shipRow, shipCol;
        shipRow = MapConverter.lat2row(ship.getLatitude());
        shipCol = MapConverter.lon2col(ship.getLongitude());
        return (map[shipCol][shipRow] == shipInDock);
    }
    
    /**
     * Print ships that are currently safe in a dock
     */
    public void unloadShipPrint() throws NullPointerException  {
        int i, j;
        System.out.println("Ships safely in a dock");
        System.out.println("------------------");
        
        /**
         * Loop through the ship array, checking to see if they are safe in a dock.
         * If safe the ship, and its index are printed.
         */
        for(i=0;i<shipArr.size();i++) {
            if(safeInDock(shipArr.get(i))) {
                System.out.printf("%d: %s\n",i,shipArr.get(i).getName());
            }
        }
        System.out.println("-------------------");
        
    }
    
    /**
     * Unload a cargo from a ship indexed in the ship array.
     * Requires the ships index as an integer.
     * Returns a cargo object.
     */
    public Cargo unloadShip(int index) throws NullPointerException  {
        Cargo cargo = shipArr.get(index).getCargo();
        shipArr.get(index).setCargo(null);
        return cargo;
    }
    
    /**
     * Saves the map and ships. Requires the string of the file name.
     */
    public void save(String fileName) throws FileNotFoundException {
        FileHandler ptFile = new FileHandler(fileName);
        ptFile.mapSave(toString());
        ptFile.shipSave(shipArr);
        ptFile = null;
    }
    
    /**
     * Loads the map and ships
     */
    public void load(String fileName, Port ptPort) throws FileNotFoundException {
        FileHandler ptFile = new FileHandler(fileName);
        
        // Ensures the ship array is empty
        this.shipArr.clear();
        
        // Load the map and ships
        ptFile.mapLoad(this);
        ptFile.shipLoad(this.shipArr);
        
        // Update the map to show the ships
        mapUpdate(ptPort);
        
        ptFile = null;
    }
    
    /**
     * Updates the map to show current ship and dock information
     */
    public void mapUpdate(Port ptPort) {
        int i, shipRow, shipCol, dockLocs[][] ;
        boolean depth, width, length, weight, dangerTest, shipType;
        
        Dock dock;
        
        dockLocs = ptPort.getDockLocs();
        for(i=0;i<dockLocs.length;i++) {
            if (dockLocs[i][2] == 3) {
                map[dockLocs[i][0]][dockLocs[i][1]] = emptyPier;
            }
            else if (dockLocs[i][2] == 2) {
                map[dockLocs[i][0]][dockLocs[i][1]] = emptyCrane;
            }
            else {
                map[dockLocs[i][0]][dockLocs[i][1]] = 'D';
            }
                    
        }
        
        for(i=0;i<this.shipArr.size();i++) {
            shipRow = MapConverter.lat2row(shipArr.get(i).getLatitude());
            shipCol = MapConverter.lon2col(shipArr.get(i).getLongitude());
            
            
            if(map[shipCol][shipRow] == water) {
                map[shipCol][shipRow] = shipArr.get(i).getSymbol();
            }
            else if(map[shipCol][shipRow] == land) {
                map[shipCol][shipRow] = shipInDanger;
            }
            else if(map[shipCol][shipRow] == ship || map[shipCol][shipRow] == tankerShip || map[shipCol][shipRow] == containerShip) {
                map[shipCol][shipRow] = shipInDanger;
            }
            else if(map[shipCol][shipRow] == shipInDock) {
                map[shipCol][shipRow] = shipInDanger;
            }
            else if(map[shipCol][shipRow] == shipInDanger) {
                map[shipCol][shipRow] = shipInDanger;
            }
            else if(map[shipCol][shipRow] == emptyPier) {
                dock = ptPort.findDock(shipRow, shipCol);
                width = shipArr.get(i).getBeam() < dock.getWidth();
                depth = shipArr.get(i).getDraft() < dock.getDepth();
                length = shipArr.get(i).getLength() < dock.getLength();
                weight = shipArr.get(i).getCargoCapacity() >= shipArr.get(i).getCargoWeight();
                shipType = shipArr.get(i) instanceof OilTanker;
                dangerTest = width || depth || length || weight || shipType;
                
                if(dangerTest) {
                    map[shipCol][shipRow] = shipInDock;
                }
                else{
                    map[shipCol][shipRow] = shipInDanger;
                }
                
            }
            else if(map[shipCol][shipRow] == emptyCrane) {
                dock = ptPort.findDock(shipRow, shipCol);
                width = shipArr.get(i).getBeam() < dock.getWidth();
                depth = shipArr.get(i).getDraft() < dock.getDepth();
                length = shipArr.get(i).getLength() < dock.getLength();
                weight = shipArr.get(i).getCargoCapacity() >= shipArr.get(i).getCargoWeight();
                shipType = shipArr.get(i) instanceof ContainerShip;
                dangerTest = width || depth || length || weight || shipType;
                
                if(dangerTest) {
                    map[shipCol][shipRow] = shipInDock;
                }
                else{
                    map[shipCol][shipRow] = shipInDanger;
                }
                
            }
            
            else if(map[shipCol][shipRow] == emptyDock) {
                dock = ptPort.findDock(shipRow, shipCol);
                width = shipArr.get(i).getBeam() < dock.getWidth();
                depth = shipArr.get(i).getDraft() < dock.getDepth();
                length = shipArr.get(i).getLength() < dock.getLength();
                weight = shipArr.get(i).getCargoCapacity() >= shipArr.get(i).getCargoWeight();
                dangerTest = width || depth || length || weight;
                
                if(dangerTest) {
                    map[shipCol][shipRow] = shipInDock;
                }
                else{
                    map[shipCol][shipRow] = shipInDanger;
                }
                
            }
            
        }
        
    }
    
    
    /**
     * Print the map. Simple loop.
     */
    public void display() {
        int rows = 36;
        int cols = 54;
        int i, j;
        
        for(i=0;i<cols;i++) {
            for(j=0;j<rows;j++) {
                System.out.printf("%c",map[i][j]);
            }
        System.out.print("\n");
        }
    }
    
    /**
     * Builds the map with strings from the save file.
     * requires a comma separated string in the form of column, row, char
     */
    public void fromString(String fromFile) {
        String token[];
        token = fromFile.split(",");
        map[Integer.parseInt(token[0])][Integer.parseInt(token[1])] = token[2].charAt(0);
    }
        
    
    /**
     * Retruns the map as a string object. Each cell of the map array is converted to a line
     * of the form column, row, char.
     */
    @Override
    public String toString() {
        String temp = "";
        String union = ",";
        int i, j;
        String newLine = "\n";
        
        for(i=0;i<54;i++) {
            for(j=0;j<36;j++) {
                temp = temp + Integer.toString(i) + union + Integer.toString(j) + union + map[i][j] + newLine;
            }
        }
        
        return temp;
    }
    

}
