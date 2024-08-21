package com.example.demo.DocLogin.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.hibernate.jpa.internal.util.PersistenceUtilHelper.AttributeExtractionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DoctorLogin.Entity.Appointment;
import com.example.demo.DoctorLogin.Entity.Madicine;
import com.example.demo.Entity.Pateint;
import com.example.demo.Login.Repository.AppointmentsRepository;

@RestController
@RequestMapping("api/v2")
public class AppointmentController {
	@Autowired
	private AppointmentsRepository repo;
	
	@PostMapping("/save")
	public ResponseEntity<Appointment> createPateint(@RequestBody Appointment appointment) {
	Appointment app= repo.save(appointment);
	return new ResponseEntity<>(app,HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Appointment>> getall(){
		 List<Appointment>  appointment= repo.findAll();
		  return new ResponseEntity<>(appointment,HttpStatus.OK);
	}
	
	@GetMapping("/appointment/{id}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable int id){
		    Appointment appointment=repo.findById(id).orElseThrow(() -> new AttributeExtractionException("madicine  not found "));
		   return new ResponseEntity<>(appointment,HttpStatus.OK);
	}

	
	@DeleteMapping("/deleteAppointment/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteAppointment(@PathVariable int id) throws AttributeNotFoundException{
		 Appointment madicine=repo.findById(id).orElseThrow(() -> new AttributeNotFoundException("Appointment Not avaliable "));
	       repo.delete(madicine);
	       Map<String,Boolean> reponse=new HashMap();
	       reponse.put("deleted",Boolean.TRUE);
	       return new ResponseEntity<>(reponse,HttpStatus.OK);
	}
	
	@PutMapping("/updateAppointment/{id}")
	public ResponseEntity<Appointment> updateMadicine(@PathVariable int id,Appointment ApponutmentDetails) throws AttributeNotFoundException{
		 Appointment appointment=repo.findById(id).orElseThrow(() -> new AttributeNotFoundException("Appointment Not avaliable "));
		 appointment.setAge( ApponutmentDetails.getAge());
		 appointment.setName(ApponutmentDetails.getName());
		 appointment.setNumber(ApponutmentDetails.getAge());
		 appointment.setSymtoms(ApponutmentDetails.getSymtoms());
		
		
		repo.save(appointment);
		 return new ResponseEntity<>(appointment,HttpStatus.OK);
	}

}
