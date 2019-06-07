/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.learningjavaee8.control;

import code.learningjavaee8.entity.CarCreated;
import javax.enterprise.event.Observes;

/**
 *
 * @author hanin
 */
public class CarCreatedEventListener {
    
    public void onCarCreation(@Observes CarCreated carCreated){
        //any business logic goes here 
        System.out.println("New Car Created with Identifier = " + carCreated.getIdentifier());
    }
}
