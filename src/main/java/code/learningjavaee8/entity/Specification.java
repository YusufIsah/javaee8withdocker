/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.learningjavaee8.entity;

/**
 *
 * @author hanin
 */
public class Specification {
    private  CarColor color;
    private  EngineType engineType;

    public Specification() {
    }
    
    public Specification(CarColor color, EngineType engineType) {
        this.color = color;
        this.engineType = engineType;
    }

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

   
    
    
}
