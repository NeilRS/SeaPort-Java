package Classes;

/**
 * Neil Simmons
 * 1001031670
 */
import Classes.Cargo.*;
import Classes.Docks.*;
import Classes.FileHandler;
import Classes.MapConverter;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Port class
 */
public class Port {
    
    private String name;    // Name of the port
    private ArrayList <Dock>dockArr=new ArrayList<>();  // Array for the docks
    private ArrayList <Cargo>cargoArr=new ArrayList<>();    // Array for the cargo

    /**
     * Constructor
     */
    public Port() {
        this.name = "Liverpool";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * PRint the cargo information
     */
    public void printCargos() {
       int i = 0;
       
       // Error check, in case someone wants to print an empty list
       // Doesent work! AWESOME!
       if(dockArr.size()==0) {
           System.out.println("There are no cargos!");
       }
       
       System.out.println("Cargos");
       System.out.println("------------------");
       // Loop through and print the cargos
       for(i=0;i<cargoArr.size();i++) {
            System.out.printf("Cargo %d \n", i);
            System.out.println("------------------");
            cargoArr.get(i).print();
            System.out.println("------------------\n");
       }
       System.out.println("------------------");
   }
   
    /**
     * Print the dock information
     */
    public void printDocks() {
       int i = 0;
       
       // Error check in case someone tries to print an empty list
       if(dockArr.size() == 0) {
           System.out.println("There are no docks!");
       }
       
       // Loop throught the docks and print thier information
       for(i=0;i<dockArr.size();i++) {
            System.out.printf("Dock %d \n", i);
            System.out.println("------------------");
            dockArr.get(i).print();
            System.out.println("------------------\n");
       }
    }
   
    
    /**
     * abreviated for of the dock print function. Prints only the index and name.
     */
    public void printDockShort() {
       int i = 0;
       for(i=0;i<dockArr.size();i++) {
            System.out.printf("%d: %s\n",i,dockArr.get(i).getName());
        }
    }
   
    /**
     * given an index, returns a dock object
     */
   public Dock getDock(int index) {
       return dockArr.get(index);
   }
   
   /**
    * adds a cargo to the cargo list
    */
   public void addCargo(Cargo cargo) {
       cargoArr.add(cargo);
   }
   
   /**
    * adds a dock to the dock list
    */
   public void addDock(Dock dock) {
       dockArr.add(dock);
   }
   
   /**
    * Finds a dock based on supplied row and column information.
    * If a dock is at the supplied row and column it will be returned.
    * Otherwise returns null.
    */
   public Dock findDock(int row, int col) {
      int i, dockRow, dockCol;
      
      // Loop through all the docks
      for(i=0;i<dockArr.size();i++) {
          dockRow = MapConverter.lat2row(dockArr.get(i).getLatitude());
          dockCol = MapConverter.lon2col(dockArr.get(i).getLongitude());
          
          // Return the dock if it matches the supplied information
          if((dockRow == row) && (dockCol == col)) {
              return dockArr.get(i);
          }
      }
      return null;
   }
   
   
   /**
    * Save the port information
    */
   public void save(String fileName) throws FileNotFoundException {
        FileHandler ptFile = new FileHandler(fileName);
        ptFile.portSave(toString());
        ptFile = null;
   }
   
   /**
    * Load the port information from a saved file.
    */
   public void load(String fileName) throws FileNotFoundException {
        FileHandler ptFile = new FileHandler(fileName);
        ptFile.portLoad(this);
        ptFile = null;
   }
   
   
   /**
    * Returns a 2D array of dock rows and columns.
    */
   public int[][] getDockLocs() {
       int i; // Loop counter
       int dockLocs[][] = new int[this.dockArr.size()][3]; // Make the array big enough to hold all of the docks
       
       // Loop through the docks, find thier row and column representations, and
       // assign them to the array
       for(i=0;i<this.dockArr.size();i++) {
           dockLocs[i][0] = MapConverter.lon2col(this.dockArr.get(i).getLongitude());
           dockLocs[i][1] = MapConverter.lat2row(this.dockArr.get(i).getLatitude());
           if ( this.dockArr.get(i) instanceof Pier) {
                dockLocs[i][2] = 3;
           }
           else if ( this.dockArr.get(i) instanceof Crane) {
                dockLocs[i][2] = 2;
           }
           else {
               dockLocs[i][2] = 1;
           }
       }
       
       return dockLocs;
   }
   
   
   /**
    * convert the port a string object that is able to be written to a file.
    * The begging of the file is the port name, number of docks, number of cargos
    * The remainder of the file is then the docks, one per line, followed by the cargo,
    * one per line.
    */
   @Override
   public String toString() {
        String temp;
        String union = ",";
        int i = 0;
        
        temp = this.name + union + Integer.toString(dockArr.size()) + union + Integer.toString(cargoArr.size()) + "\n";
        for(i=0;i<dockArr.size();i++) {
            temp = temp + dockArr.get(i).toString() + "\n";
        }
        for(i=0;i<cargoArr.size();i++) {
            temp = temp + cargoArr.get(i).toString() + "\n";
        }
        return temp;
    }
    
}
