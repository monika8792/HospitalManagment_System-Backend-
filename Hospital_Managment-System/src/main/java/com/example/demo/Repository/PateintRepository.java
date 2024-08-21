package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Pateint;
@Repository
public interface PateintRepository  extends JpaRepository<Pateint,Integer>{

}
