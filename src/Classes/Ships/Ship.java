package Classes.Ships;

import Classes.Cargo.*;

/**
 * Neil Simmons
 * 1001031670
 */


/**
 * Ship class. Represents a ship that might use a dock in a seaport.
 *
 */
public class Ship implements Comparable<Ship> {
    protected String name;
    protected String countryOfRegistration;
    protected long transponder;
    protected double cargoCapacity; //in tons
    protected double length; //In meters
    protected double beam; //In Meters
    protected double draft; //In Meters
    protected double longitude; //In Degrees
    protected double latitude; //In Degrees
    protected int row;
    protected int col;
    protected Cargo cargo; //
    protected char symbol;

    
    /**
     * Old constructor
     */
    public Ship() {        
        this.name = "Zenda";
        this.countryOfRegistration = "Ruritania";
        this.transponder = 0;
        this.cargoCapacity = 10;
        this.length = 90;
        this.beam = 10;
        this.draft = 5;
        this.longitude = -2.977838;
        this.latitude = 53.410777;
        this.cargo = new Cargo();
        this.row = 65;
        this.col = 8;
        this.symbol = 'S';
    }

    public Ship(String name, String countryOfRegistration, long transponder, double cargoCapacity, double length, double beam, double draft, double longitude, double latitude, int row, int col, Cargo cargo, char symbol) {
        this.name = name;
        this.countryOfRegistration = countryOfRegistration;
        this.transponder = transponder;
        this.cargoCapacity = cargoCapacity;
        this.length = length;
        this.beam = beam;
        this.draft = draft;
        this.longitude = longitude;
        this.latitude = latitude;
        this.row = row;
        this.col = col;
        this.cargo = cargo;
        this.symbol = symbol;
    }
    
    /**
     * Ship object constructor. Requires a string of the form
     * Name, origin, transponder, capacity, length, beam, draft, longitude, latitude, cargo description, cargo weight
     */
    public Ship(String shipString) {
        String token[];
        token = shipString.split(",");
        
        this.name = token[0];
        this.countryOfRegistration = token[1];
        this.transponder = Long.parseLong(token[2]);
        this.cargoCapacity = Double.parseDouble(token[3]);
        this.length = Double.parseDouble(token[4]);
        this.beam = Double.parseDouble(token[5]);
        this.draft = Double.parseDouble(token[6]);
        this.longitude = Double.parseDouble(token[7]);
        this.latitude = Double.parseDouble(token[8]);
        //this.row = Integer.parseInt(token[9]);
        //this.col = Integer.parseInt(token[10]);
        this.cargo = new Cargo(token[9],Double.parseDouble(token[10]));
        //this.symbol = token[13].charAt(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryOfRegistration() {
        return countryOfRegistration;
    }

    public void setCountryOfRegistration(String countryOfRegistration) {
        this.countryOfRegistration = countryOfRegistration;
    }

    public long getTransponder() {
        return transponder;
    }

    public void setTransponder(long transponder) {
        this.transponder = transponder;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getBeam() {
        return beam;
    }

    public void setBeam(double beam) {
        this.beam = beam;
    }

    public double getDraft() {
        return draft;
    }

    public void setDraft(double draft) {
        this.draft = draft;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    public void setCargoDescription(String name) {
        this.cargo.setDescription(name);
    }
    
    public String getCargoDescription() {
        return this.cargo.getDescription();
    }
    
    public void setCargoWeight(double weight) {
        this.cargo.setWeight(weight);
    }
    
    public double getCargoWeight() {
        return this.cargo.getWeight();
    }
    
    public void printCargo() {
        this.cargo.print();
    }
    
    public int cargoType() {
        if (this.cargo instanceof Oil) {
            return 1;
        }
        else if (this.cargo instanceof Box) {
            return 2;
        }
        else {
            return 3;           
        }
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

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    
    
    
    /**
     * Print the ships information
     */

    public void print(){
        System.out.printf("Name:  %s\n",this.name);
        System.out.printf("Country of Origin:  %s\n",this.countryOfRegistration);
        System.out.printf("Transponder:  %d\n",(int)this.transponder);
        System.out.printf("Length:  %f\n",this.length);
        System.out.printf("Beam:  %f\n",this.beam);
        System.out.printf("Draft:  %f\n",this.draft);
        System.out.printf("Capactiy:  %f\n",this.cargoCapacity);
        System.out.printf("Location (%f , %f)\n", this.longitude,this.latitude);
        System.out.printf("Location (%d , %d)\n", this.row,this.col);
        cargo.print();
    }
    
    /**
     * Converts the ship object to a string of the form
     * Name, origin, transponder, capacity, length, beam, draft, longitude, latitude, cargo description, cargo weight
     */
    public String toString() {
        String temp;
        String union = ",";
        
        temp = this.name + union + this.countryOfRegistration + union + Long.toString(this.transponder)
                 + union + Double.toString(this.cargoCapacity) + union + Double.toString(this.length) + union + 
                Double.toString(this.beam) + union + Double.toString(this.draft) + union + Double.toString(this.longitude)
                 + union + Double.toString(this.latitude) + union + this.cargo.getDescription() + union + 
                Double.toString(this.cargo.getWeight());
        return temp;
    }

    @Override
    public int compareTo(Ship o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
