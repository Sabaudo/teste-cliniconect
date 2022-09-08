package com.example.crudpacientes.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.crudpacientes.models.Paciente;
import com.example.crudpacientes.repositories.PacienteRepository;


@Controller
public class PacienteController {

	@Autowired
    private PacienteRepository pacienteRepository;
	
	
    @GetMapping(value="/cadastrarPaciente")
	public String form() {
		return "paginas/cadastroPaciente";
	}

    @PostMapping(value="/cadastrarPaciente")
	public String form(@Valid Paciente paciente, 
					BindingResult result, 
					RedirectAttributes attributes) {
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarPaciente";
		}
		
		pacienteRepository.save(paciente);
		attributes.addFlashAttribute("mensagem", "Paciente cadastrado com sucesso!");
		return "redirect:/cadastrarPaciente";
	}
    
    @RequestMapping("/pacientes")
	public ModelAndView listaPacientes() {
		ModelAndView mv = new ModelAndView("paginas/listaPacientes");
		Iterable<Paciente> pacientes = pacienteRepository.findAll();
		mv.addObject("pacientes", pacientes);
		return mv;
	}
    
    @GetMapping(value="pacientes/{cpf}")
	public ModelAndView detalhesPaciente(@PathVariable("cpf") String cpf){
		ModelAndView mv = new ModelAndView("paginas/detalhesPaciente");
		Paciente paciente = pacienteRepository.findByCpf(cpf);
		mv.addObject("paciente", paciente);
		
		return mv;
	}
    
    @PostMapping(value="pacientes/{cpf}")
	public String detalhesPacientePost(@PathVariable("cpf") String cpf, 
									@Valid Paciente paciente,  
									BindingResult result, 
									RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/pacientes/{cpf}";
		}
		pacienteRepository.save(paciente);
		attributes.addFlashAttribute("mensagem", "Informações atualizadas com sucesso!");
		return "redirect:/pacientes/{cpf}";
	}
    
    @RequestMapping("/deletarPaciente/{cpf}")
	public String deletarEvento(@PathVariable("cpf") String cpf, RedirectAttributes attributes){
		Paciente paciente= pacienteRepository.findByCpf(cpf);
		pacienteRepository.delete(paciente);
		return "redirect:/pacientes";
	}
}
