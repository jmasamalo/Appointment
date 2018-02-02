package com.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Appointment;


@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
	
	@Query("SELECT e FROM Appointment e WHERE e.id = :id")
	Appointment findById(@Param("id") long id);
	
	@Query(value = "SELECT e FROM Appointment e WHERE e.description LIKE %:desc%")
	public List<Appointment> findBydescription(@Param("desc") String desc);
	
}
