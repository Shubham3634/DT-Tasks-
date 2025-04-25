package dev.dt.pickspot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Dto.PickRequest;
import Dto.PickResponse;
import Service.PickerService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

@RestController  // this marks the class as a Spring MVC controller that handles HTTP requests
@SpringBootApplication(scanBasePackages = { "dev.dt.pickspot", "Service" }) // this is a Spring Boot application entry point that scans the specified base packages for components
public class PickspotApplication {

    // it is a main method to start the Spring Boot application
    public static void main(String[] args) {
       
    	SpringApplication.run(PickspotApplication.class, args);  // it runs the application and starts the embedded server
        
    	System.out.println("Application pickspot started successfully!");  // i just give here a message that it confirms that the application has started
    }

    @Autowired  // this annotation automatically injects the PickerService bean into this class
   
    private PickerService picker;  // PickerService will handle the logic of picking the best slot for the container

    // it handles POST requests sent to the /pickSpot endpoint
    @PostMapping("/pickSpot")
   
    public ResponseEntity<?> pick(@RequestBody PickRequest request) {
    	
        // this chooseBestSlot method from PickerService is called to find the best available slot for the container
        return picker.chooseBestSlot(request.getContainer(), request.getYardMap())
          
        		.<ResponseEntity<?>>map(  // if a suitable slot is found it map the slot to a successful response
             			      	
        		slot -> ResponseEntity.ok(new PickResponse(request.getContainer().getId(), slot.getX(), slot.getY())))
            
        		.orElseGet(() ->  // and if no suitable slot is found it return a bad request response
                
        		ResponseEntity.badRequest().body(Map.of("error", "no suitable slot")));
    }
}
