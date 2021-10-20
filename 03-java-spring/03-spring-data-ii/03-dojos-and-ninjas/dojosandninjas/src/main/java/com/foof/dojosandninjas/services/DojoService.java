package com.foof.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foof.dojosandninjas.models.Dojo;
import com.foof.dojosandninjas.models.Ninja;
import com.foof.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteAll() {
		dojoRepository.deleteAll();
	}
	public Dojo updateDojo(Long id, String name) {
		Dojo d = findDojo(id);
		d.setName(name);
		return dojoRepository.save(d);
	}
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
		
	}
	public Dojo updateDojo(@Valid Dojo dojo) {
		Dojo d = findDojo(dojo.getId());
		d.setName(dojo.getName());
		d.setNinjas(dojo.getNinjas());
		return dojoRepository.save(d);
		
	}
	public Dojo addNinja(Long id, Ninja ninja) {
		Dojo d = findDojo(id);
		d.getNinjas().add(ninja);
		return dojoRepository.save(d);
	}
}
