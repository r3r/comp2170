/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.gojpcms.mapcomponent;

import java.awt.geom.Point2D.Float;

/**
 *
 * @author JCARJ
 */
public class MapComponent {
    
    /**
     * Get latitude and longitude for a given location string
     * @param location - Geographic Location/ Address
     * @return Point2D.Float - Coordinates
     */
    public Float getCoordinate(String location){
        //Access Google Maps API
        return new Float(0,0);
        
    }
    
    /**
     * Renders a geographic maps with tags placed at given coordinates
     * @param locations Float[] - List of coordinates
     * @param tags String[] - List of matching tags for coordinates to place on the map
     * 
     */
    public void renderMap(Float[] locations, String[] tags){
       
    }
    
}
