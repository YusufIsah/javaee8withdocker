/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.learningjavaee8.boundary;

import code.learningjavaee8.control.CarFactory;
import code.learningjavaee8.control.CarRepository;
import code.learningjavaee8.entity.Car;
import code.learningjavaee8.entity.CarCreated;
import code.learningjavaee8.entity.Specification;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author hanin
 */
@Stateless
public class CarManufacturer {
    
    @Inject
    private CarFactory carFactory;
    @Inject
    private CarRepository carRepository;
    @Inject
    private Event<CarCreated> carCreated;
    
    public Car manufactureCar(Specification specification){
        Car car = carFactory.createCar(specification);
        //persist car here...
        carRepository.store(car);
        carCreated.fire(new CarCreated(car.getIdentifier()));
        return  car;
    }
    
    public List<Car> retrieveCars(){
        return carRepository.loadCars();
    }

    public Car retrieveCars(String identifier) {
       Car car = new Car();
       car.setIdentifier(identifier);
       return car;
    }
    
  
}
