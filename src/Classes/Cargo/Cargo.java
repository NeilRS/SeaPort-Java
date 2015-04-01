package Classes.Cargo;

/**
 * Neil Simmons
 * 1001031670
 */

/**
 * Cargo class represents the cargo that might be on a ship that would use
 * a seaport.
 */
public class Cargo implements Comparable<Cargo> {

    private double weight; // In tons
    protected String description; // Bannanas
    
    /*Cargo class constructor.
    */
    public Cargo(){
        this.weight = 10.0;
        this.description= "Bananas!";
    }
    
    /*Overload Cargo class constructor. Requires a description as a string and weight as a double
    */
    public Cargo(String description, Double weight){
        this.weight= weight;
        this.description= description;
    }
    
    /*Overload Cargo class constructor. Requires a comma seperated string
    */
    public Cargo(String cargoString) {
        String token[];
        token = cargoString.split(",");
        
        this.description = token[0];
        this.weight = Double.parseDouble(token[1]);
    }
    
    public void setWeight(double newWeight){
        this.weight=newWeight;
    }
    
    public double getWeight(){
        return this.weight;
    }
    
    public void setDescription(String newDescription){
        this.description=newDescription;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    /**
     * Print the cargos information
     */
    public void print(){
        System.out.printf("%d tons of %s\n",(int)this.weight,this.description);
    }
    
    /**
     * Output the cargo as a string
     * @return 
     */
    @Override
    public String toString() {
        String temp;
        String union = ",";
        
        temp = this.description + union + Double.toString(this.weight);
        return temp;
    }

    @Override
    public int compareTo(Cargo o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
