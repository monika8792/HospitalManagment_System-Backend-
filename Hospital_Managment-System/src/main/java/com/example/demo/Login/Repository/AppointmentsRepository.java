package com.example.demo.Login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.DoctorLogin.Entity.Appointment;
@Repository
public interface AppointmentsRepository  extends JpaRepository<Appointment,Integer>{

}
