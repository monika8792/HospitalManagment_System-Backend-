package com.example.demo.Controller.copy;

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

import com.example.demo.Entity.Pateint;
import com.example.demo.Repository.PateintRepository;
@RestController
@RequestMapping("/api/v1")
public class PateintController {
	@Autowired
	private PateintRepository repos;
	
	@PostMapping("/save")
	public ResponseEntity<Pateint> createPateint(@RequestBody Pateint pateint) {
		 Pateint pp= repos.save(pateint); 
		 return new ResponseEntity<>(pp,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Pateint>> getall() {
		 List<Pateint>  ppp=repos.findAll();
		 return new ResponseEntity<>(ppp,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Pateint> getPateintById(@PathVariable int id){
		  Pateint pateint=repos.findById(id).orElseThrow(() -> new AttributeExtractionException("pateint  not found with id:"+id));
		   return new ResponseEntity<>(pateint,HttpStatus.OK);
	}
	
	@PutMapping("/all/{id}")
	public ResponseEntity<Pateint> updatePateintById(@PathVariable int id,Pateint patientDetails){
		  Pateint pateint=repos.findById(id).orElseThrow(() -> new AttributeExtractionException("pateint  not found with id:"+id));
		  
		  pateint.setAge(patientDetails.getAge());
		  pateint.setBlood(patientDetails.getBlood());
		  pateint.setDose(patientDetails.getDose());
		  pateint.setFees(patientDetails.getFees());
		  pateint.setId(patientDetails.getId());
		  pateint.setName(patientDetails.getName());
		  pateint.setPrescription(patientDetails.getPrescription());
		  pateint.setUrgency(patientDetails.getUrgency());
		  
		  Pateint savepateint= repos.save(pateint);
		  return new ResponseEntity<>(savepateint,HttpStatus.OK);
	}
	@DeleteMapping("/pateint/{id}")
	public ResponseEntity<Map<String,Boolean>> deletePateint(@PathVariable int id) throws AttributeNotFoundException{
	 Pateint pateint 	= repos.findById(id).orElseThrow(() -> new AttributeNotFoundException("pateint not found"));
     repos.delete(pateint);	
     Map<String,Boolean> response=new HashMap<String,Boolean>();
     response.put("Deleted", Boolean.TRUE);
	 return ResponseEntity.ok(response);
		
	}
	
	

}
