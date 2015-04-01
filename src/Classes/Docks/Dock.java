package Classes.Docks;

/**
 * Neil Simmons
 * 1001031670
 */

/**
 * Dock class. represents a dock in a seaport that a Ship could use to unload
 * cargo.
 */
public class Dock implements Comparable<Dock>{
    protected String name;
    protected char section;
    protected int number;
    protected double depth; // meters
    protected double length; // meters
    protected double width; // meters
    protected double longitude; // degerees
    protected double latitude; // degerees
    protected char symbol;
    protected int row;
    protected int col;

    public Dock(String name, char section, int number, double depth, double length, double width, double longitude, double latitude, char symbol, int row, int col) {
        this.name = name;
        this.section = section;
        this.number = number;
        this.depth = depth;
        this.length = length;
        this.width = width;
        this.longitude = longitude;
        this.latitude = latitude;
        this.symbol = symbol;
        this.row = row;
        this.col = col;
    }

    /**
     * Alternate constructor for the dock class. Requires a string of the following format
     * (String)name, (Char)section, (Int)number, (Double)depth, (Double)length, (Double)width, (Double)longitude, (Double)latitude
     */
    public Dock(String dockString) {
        String token[];
        token = dockString.split(",");
        
        this.name = token[0];
        this.section = token[1].charAt(0);
        this.number = Integer.parseInt(token[2]);
        this.depth = Double.parseDouble(token[3]);
        this.length = Double.parseDouble(token[4]);
        this.width = Double.parseDouble(token[5]);
        this.longitude = Double.parseDouble(token[6]);
        this.latitude = Double.parseDouble(token[7]);
        //this.symbol = token[8].charAt(0);
        //this.row = Integer.parseInt(token[9]);
        //this.col = Integer.parseInt(token[10]);
    }

    
    /**
     * Constructor for the dock class
     */
    public Dock() {
        this.name = "Rudolph's Dock";
        this.section = 'N';
        this.number = 100;
        this.depth = 15;
        this.length = 100;
        this.width = 6;
        this.longitude = -3.011300;
        this.latitude = 53.428000;
        this.symbol = 'D';
        this.row = 27;
        this.col = 18;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSection() {
        return section;
    }

    public void setSection(char section) {
        this.section = section;
    }

    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    public char getSymbol() {
        return this.symbol;
    }

    public void setSymbol(char newSymbol) {
        this.symbol = newSymbol;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
    
    
    /**
     *Print the docks information 
     */
    public void print(){
        System.out.printf("Name: %s\n",this.name);
        System.out.printf("Dock Number: %c%d\n",this.section,this.number);
        System.out.printf("Size: %f x %f x %f meters \n", this.length, this.depth, this.width);
        System.out.printf("Location (%f , %f)\n", this.longitude,this.latitude);
        System.out.printf("Location (%d , %d)\n", this.row,this.col);
    }
    
    /**
     * Output the dock as a formated string, in the following format
     * (String)name, (Char)section, (Int)number, (Double)depth, (Double)length, (Double)width, (Double)longitude, (Double)latitude
     * @return 
     */
    @Override
    public String toString() {
        String temp;
        String union = ",";
        
        temp = this.name + union + Character.toString(section) + union + Integer.toString(number)
                 + union + Double.toString(this.length) + union + Double.toString(this.depth) + union + 
                Double.toString(this.width) + union + Double.toString(this.longitude) + union + Double.toString(this.latitude);
        return temp;
    }

    @Override
    public int compareTo(Dock o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
