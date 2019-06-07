/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.learningjavaee8.control;

import code.learningjavaee8.entity.Car;
import code.learningjavaee8.entity.CarColor;
import code.learningjavaee8.entity.Specification;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author hanin
 */
public class CarFactory {

    @Inject
    @Diesel
    CarColor defaultCarColor;

    public Car createCar(Specification specification) {
        Car car = new Car();
        car.setIdentifier(UUID.randomUUID().toString());
        car.setColor(specification.getColor() == null ? defaultCarColor : specification.getColor());
        car.setEngineType(specification.getEngineType());
        return car;
    }
}
