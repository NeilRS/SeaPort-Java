/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Docks;

import Classes.Docks.Dock;

/**
 *
 * @author Neil
 */
public class Crane extends Dock {

    public Crane(String name, char section, int number, double depth, double length, double width, double longitude, double latitude, char symbol, int row, int col) {
        super(name, section, number, depth, length, width, longitude, latitude, symbol, row, col);
    }

    public Crane(String dockString) {
        super(dockString);
    }

    public Crane() {
        this.name = "North Crane";
        this.symbol = 'C';
    }

    
    
}
