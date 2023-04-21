package courier.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import courier.model.Courier;
import courier.service.CourierService;
import jakarta.validation.Valid;

@RestController
public class CourierController {
	
	@Autowired
	CourierService courierService;
	
	@GetMapping("/courierDetails")
	public ResponseEntity<List<Courier>> courierDetails() 
	{
		try {
			List<Courier> courier= courierService.courierDetails();
			return new ResponseEntity<List<Courier>>(courier, HttpStatus.FOUND);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}		
	}
	@GetMapping("/courierDetailsById/{courierId}")
	public ResponseEntity<Courier> courierDetailsById(@PathVariable(value="courierId") int courierId) 
	{
		try {
			Courier courier= courierService.courierDetailsById(courierId);
			return new ResponseEntity<Courier>(courier,HttpStatus.FOUND);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
	}	
	
	@PostMapping("/createCourierDetails")
	public ResponseEntity<Courier> createCourier(@RequestBody @Valid Courier courier) {
		try {
			courier=courierService.createCourierDetails(courier);
			return new ResponseEntity<Courier>(courier,HttpStatus.CREATED);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	@PutMapping("/updateCourierDetails/{courierId}")
	public ResponseEntity<Courier> updateCard(@PathVariable (value="courierId") int courierId,@RequestBody Courier courier) 
	{
		try
		{
			Courier existcourier=courierService.courierDetailsById(courierId);
			existcourier.setCourierName(courier.getCourierName());
			existcourier.setCourierId(courier.getCourierId());
			existcourier.setCourierWeight(courier.getCourierWeight());
			existcourier.setCourierService(courier.getCourierService());
			existcourier.setCourierDate(courier.getCourierDate());
			existcourier.setCourierDestination(courier.getCourierDestination());
			existcourier.setCourierCharges(courier.getCourierCharges());
    
			Courier updatedCourier=courierService.updateCourierDetails(existcourier);
			return new ResponseEntity<Courier>(updatedCourier,HttpStatus.OK);
		}
		catch(Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/deleteCourier/{courierId}")
	public ResponseEntity<Courier> deleteCourier(@PathVariable(value="courierId") int courierId)
	{
		Courier courier=null;
		try
		{
			courier=courierService.courierDetailsById(courierId);
			courierService.deleteCourier(courier);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<Courier>(courier,HttpStatus.OK);
	}

}
