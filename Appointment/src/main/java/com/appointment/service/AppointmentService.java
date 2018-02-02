package com.appointment.service;

import java.util.List;

import com.appointment.domain.Appointment;

public interface AppointmentService {

	public List<Appointment> getAll();

	public Appointment save(Appointment appointment);

	public Appointment get(Long id);
	
	// To be revisited
	
	public Appointment findById(long id);
	
	public List<Appointment> findByDescription(String desc);
	
}
