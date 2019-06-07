/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.learningjavaee8.control;

import code.learningjavaee8.entity.CarColor;
import javax.enterprise.inject.Produces;

/**
 *
 * @author hanin
 */
public class DefaultColorExposer {
    
    @Produces
    @Diesel
    public CarColor exposeDefaultColor(){
        //any busines logi can be here then return the result
        return CarColor.RED;
    }
    
}
