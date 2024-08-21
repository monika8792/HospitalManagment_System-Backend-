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
import com.example.demo.Login.Repository.MadicineRepository;

@RestController
@RequestMapping("/api/v3")
public class MadicineController {
	@Autowired
	private MadicineRepository repo;
	
	@PostMapping("/save")
	public ResponseEntity<Madicine> createMadicine(@RequestBody Madicine madicine) {
		 Madicine mm= repo.save(madicine);
		  return new ResponseEntity<>(mm,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Madicine>> getall(){
		 List<Madicine> mm= repo.findAll();
		  return new ResponseEntity<>(mm,HttpStatus.OK);
	}
	
	@GetMapping("/madicine/{id}")
	public ResponseEntity<Madicine> getMadicineById(@PathVariable int id){
		  Madicine madicine=repo.findById(id).orElseThrow(() -> new AttributeExtractionException("madicine  not found "));
		   return new ResponseEntity<>(madicine,HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Madicine> updateMadicine(@PathVariable int id,Madicine madicineDetails) throws AttributeNotFoundException{
		 Madicine madicine=repo.findById(id).orElseThrow(() -> new AttributeNotFoundException("madicine Not avaliable "));
		madicine.setDrugsname(madicineDetails.getDrugsname());
		
		madicine.setStock(madicineDetails.getStock());
		repo.save(madicine);
		 return new ResponseEntity<>(madicine,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String,Boolean>> deletemadicine(@PathVariable int id) throws AttributeNotFoundException{
		 Madicine madicine=repo.findById(id).orElseThrow(() -> new AttributeNotFoundException("madicine Not avaliable "));
	       repo.delete(madicine);
	       Map<String,Boolean> reponse=new HashMap();
	       reponse.put("deleted",Boolean.TRUE);
	       return new ResponseEntity<>(reponse,HttpStatus.OK);
	}

}
