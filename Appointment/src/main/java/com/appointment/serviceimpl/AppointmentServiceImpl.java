package com.appointment.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appointment.domain.Appointment;
import com.appointment.repository.AppointmentRepository;
import com.appointment.service.AppointmentService;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	public List<Appointment> getAll() {
		return (List<Appointment>) appointmentRepository.findAll();
	}

	public Appointment save(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	public Appointment get(Long id) {
		return appointmentRepository.findById(id);
	}

	// to be revisited

	@Override
	public Appointment findById(long id) {
		return appointmentRepository.findById(id);
	}

	@Override
	public List<Appointment> findByDescription(String desc) {
		return appointmentRepository.findBydescription(desc);
	};


}
