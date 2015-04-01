/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Cargo;

/**
 *
 * @author Neil
 */
public class Oil extends Cargo {
    private int barrels;
    
    /*Cargo class constructor.
    */
    public Oil(){
        this.barrels = 700000;
        this.description= "Light Crude";
    }
    
    /*Overload Cargo class constructor. Requires a description as a string and weight as a double
    */
    public Oil(String description, int newBarrels){
        this.barrels = newBarrels;
        this.description= description;
    }
    
    /*Overload Cargo class constructor. Requires a comma seperated string
    */
    public Oil(String cargoString) {
        String token[];
        token = cargoString.split(",");
        
        this.description = token[0];
        this.barrels = Integer.parseInt(token[1]);
    }
    
    public void setBarrels(int newBarrels){
        this.barrels=newBarrels;
    }
    
    public int getBarrels(){
        return this.barrels;
    }
    
    /**
     * Print the cargos information
     */
    @Override
    public void print(){
        System.out.printf("%d barrels of %s\n",(int)this.barrels,this.description);
    }
    
    /**
     * Output the cargo as a string
     * @return 
     */
    @Override
    public String toString() {
        String temp;
        String union = ",";
        
        temp = this.description + union + Integer.toString(this.barrels);
        return temp;
    }
}
