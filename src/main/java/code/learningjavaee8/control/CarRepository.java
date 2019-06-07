/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.learningjavaee8.control;

import code.learningjavaee8.entity.Car;
import code.learningjavaee8.entity.CarColor;
import code.learningjavaee8.entity.EngineType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hanin
 */
public class CarRepository {
    
    public void store(Car car){
        
    }
    
    public List<Car> loadCars(){
        return Arrays.asList(createCar("X123A234", CarColor.RED, EngineType.DIESEL),
                createCar("X123A235", CarColor.BLACK, EngineType.PETROL), createCar("X123A236", CarColor.GRAY, EngineType.PETROL));
    }
    
    private static Car createCar(String identifier, CarColor carColor, EngineType engineType){
        Car car = new Car();
        car.setIdentifier(identifier);
        car.setColor(carColor);
        car.setEngineType(engineType);
        return  car;
    }
}
