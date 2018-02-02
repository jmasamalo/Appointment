package com.appointment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appointment.domain.Appointment;
import com.appointment.domain.Search;
import com.appointment.service.AppointmentService;

@Controller
public class HomeController {

	@Autowired
	AppointmentService appointmentService;
	
	@RequestMapping(value={"/"}, method=RequestMethod.GET)
	public String welcome(@ModelAttribute("appointment") Appointment appointment, Model model) {
		return "welcome";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String saveAppointment(@Valid @ModelAttribute("appointment") Appointment appointment, 
			BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "welcome";
		}
		
		appointmentService.save(appointment);

		return "welcome";
	}
	
	@RequestMapping(value = "/ajax", method=RequestMethod.POST)
	public @ResponseBody List<Appointment>  getAppointments( @RequestBody Search desc) {
		
		List<Appointment> appointments;
		if(desc==null || desc.getSearch().equals("")) {
			 appointments = appointmentService.getAll();
		}else {
			 appointments = appointmentService.findByDescription(desc.getSearch());
		}
		
		return appointments;
	}
	
	@RequestMapping(value = "/ajax", method=RequestMethod.GET)
	public @ResponseBody List<Appointment>  getAllAppointments() {
		
		List<Appointment> appointments = appointmentService.getAll();
		
		return appointments;
	}
	

}
