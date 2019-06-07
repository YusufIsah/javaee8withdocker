/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.learningjavaee8.boundary;

import code.learningjavaee8.entity.Car;
import code.learningjavaee8.entity.Specification;
import java.net.URI;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author hanin
 */
@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {
    
    @Inject
    private CarManufacturer carManufacturer;
    @Context
    private UriInfo uriInfo;
    
    //JSON-B Marshaling and Unmarshaling of POJOs.
//    @GET
//    public List<Car> retrieveCars(){
//        return carManufacturer.retrieveCars();
//    }
    @POST
    public Response createCar(Specification specification){
       Car car =  carManufacturer.manufactureCar(specification);
       URI uri = uriInfo.getBaseUriBuilder()
               .path(CarResource.class)
               .path(CarResource.class, "retrieveCar")
               .build(car.getIdentifier());
       return Response.created(uri).build();
    }
     //JSON-P Marshaling and Unmarshaling of POJOs.
     @GET
    public JsonArray retrieveCars(){
        return carManufacturer.retrieveCars().stream()
                .map(c -> Json.createObjectBuilder()
                        .add("color", c.getColor().name())
                .add("engineType", c.getEngineType().name())
                .add("identifier", c.getIdentifier())
                .add("hello", "Value").build()).collect(JsonCollectors.toJsonArray());
    }
//    @POST
//    public void createCar(JsonObject jsonObject){
//        CarColor carColor = CarColor.valueOf(jsonObject.getString("color"));
//        EngineType engineType = EngineType.valueOf(jsonObject.getString("engineType"));
//        carManufacturer.manufactureCar(new Specification(carColor, engineType));
//    }
    @GET
    @Path("{id}")
    public Car retrieveCar(@PathParam("id") String identifier){
        return  carManufacturer.retrieveCars(identifier);
    }
}
