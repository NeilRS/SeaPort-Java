/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Ships;

import Classes.Cargo.*;

/**
 *
 * @author Neil
 */
public class OilTanker extends Ship {
    protected Oil oil;
    protected double oilCapacity; //in barrels

    public OilTanker() {
        this.name = "Zenda";
        this.countryOfRegistration = "Ruritania";
        this.transponder = 0;
        this.oilCapacity = 700000;
        this.length = 90;
        this.beam = 10;
        this.draft = 5;
        this.longitude = -2.977838;
        this.latitude = 53.410777;
        this.oil = new Oil();
        this.row = 65;
        this.col = 8;
        this.symbol = 'T';
    }

    public OilTanker(String name, String countryOfRegistration, long transponder, double oilCapacity, double length, double beam, double draft, double longitude, double latitude, int row, int col, Oil oil, char symbol) {
        this.name = name;
        this.countryOfRegistration = countryOfRegistration;
        this.transponder = transponder;
        this.oilCapacity = oilCapacity;
        this.length = length;
        this.beam = beam;
        this.draft = draft;
        this.longitude = longitude;
        this.latitude = latitude;
        this.row = row;
        this.col = col;
        this.oil = oil;
        this.symbol = symbol;       
    }

    public OilTanker(String shipString) {
        String token[];
        token = shipString.split(",");
        
        this.name = token[0];
        this.countryOfRegistration = token[1];
        this.transponder = Long.parseLong(token[2]);
        this.oilCapacity = Integer.parseInt(token[3]);
        this.length = Double.parseDouble(token[4]);
        this.beam = Double.parseDouble(token[5]);
        this.draft = Double.parseDouble(token[6]);
        this.longitude = Double.parseDouble(token[7]);
        this.latitude = Double.parseDouble(token[8]);
        //this.row = Integer.parseInt(token[9]);
        //this.col = Integer.parseInt(token[10]);
        this.oil = new Oil(token[9],Integer.parseInt(token[10]));
        //this.symbol = token[13].charAt(0);
        
    }

    public Oil getOil() {
        return oil;
    }

    public void setOil(Oil oil) {
        this.oil = oil;
    }

    public double getOilCapacity() {
        return oilCapacity;
    }

    public void setOilCapacity(double oilCapacity) {
        this.oilCapacity = oilCapacity;
    }
    
    public int getOilQuantity() {
        return this.oil.getBarrels();
    }
    
    public void setOilQuantity(int quantity) {
        this.oil.setBarrels(quantity);
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
        System.out.printf("Barral Capacity:  %f\n",this.oilCapacity);
        System.out.printf("Location (%f , %f)\n", this.longitude,this.latitude);
        System.out.printf("Location (%d , %d)\n", this.row,this.col);
        oil.print();
    }
    
    /**
     * Converts the ship object to a string of the form
     * Name, origin, transponder, capacity, length, beam, draft, longitude, latitude, cargo description, cargo weight
     */
    public String toString() {
        String temp;
        String union = ",";
        
        temp = this.name + union + this.countryOfRegistration + union + Long.toString(this.transponder)
                 + union + Double.toString(this.oilCapacity) + union + Double.toString(this.length) + union + 
                Double.toString(this.beam) + union + Double.toString(this.draft) + union + Double.toString(this.longitude)
                 + union + Double.toString(this.latitude) + union + this.oil.getDescription() + union + 
                Double.toString(this.oil.getBarrels());
        return temp;
    }
    
}
