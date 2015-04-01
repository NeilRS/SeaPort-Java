/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Docks;

/**
 *
 * @author Neil
 */
public class Pier extends Dock {

    public Pier(String name, char section, int number, double depth, double length, double width, double longitude, double latitude, char symbol, int row, int col) {
        super(name, section, number, depth, length, width, longitude, latitude, symbol, row, col);
    }

    public Pier(String dockString) {
        super(dockString);
    }

    public Pier() {
        this.name = "South Pier";
        this.symbol = 'P';
    }
    
}
