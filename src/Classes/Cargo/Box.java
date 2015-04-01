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
public class Box extends Cargo{
    private int teu;
    
    /*Cargo class constructor.
    */
    public Box(){
        this.teu = 10000;
        this.description= "Marble";
    }
    
    /*Overload Cargo class constructor. Requires a description as a string and weight as a double
    */
    public Box(String description, int newTeu){
        this.teu = newTeu;
        this.description= description;
    }
    
    /*Overload Cargo class constructor. Requires a comma seperated string
    */
    public Box(String cargoString) {
        String token[];
        token = cargoString.split(",");
        
        this.description = token[0];
        this.teu = Integer.parseInt(token[1]);
    }
    
    public void setTeu(int newTeu){
        this.teu=newTeu;
    }
    
    public int getTeu(){
        return this.teu;
    }
    
    /**
     * Print the cargos information
     */
    @Override
    public void print(){
        System.out.printf("%d TEUs of %s\n",(int)this.teu,this.description);
    }
    
    /**
     * Output the cargo as a string
     * @return 
     */
    @Override
    public String toString() {
        String temp;
        String union = ",";
        
        temp = this.description + union + Integer.toString(this.teu);
        return temp;
    }
}
