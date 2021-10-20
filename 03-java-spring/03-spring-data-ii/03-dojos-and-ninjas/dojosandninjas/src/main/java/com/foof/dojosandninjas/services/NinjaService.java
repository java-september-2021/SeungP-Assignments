package com.foof.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foof.dojosandninjas.models.Dojo;
import com.foof.dojosandninjas.models.Ninja;
import com.foof.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	public Ninja createNinja(Ninja n) {
		return this.ninjaRepository.save(n);
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteAll() {
		ninjaRepository.deleteAll();
	}
	public Ninja updateNinja(Long id, String firstName, String lastName, int age, Dojo dojo) {
		Ninja n = findNinja(id);
		n.setFirstName(firstName);
		n.setLastName(lastName);
		n.setAge(age);
		n.setDojo(dojo);
		return ninjaRepository.save(n);
	}
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
		
	}
	public Ninja updateBook(@Valid Ninja ninja) {
		Ninja n = findNinja(ninja.getId());
		n.setFirstName(ninja.getFirstName());
		n.setLastName(ninja.getLastName());
		n.setAge(ninja.getAge());
		n.setDojo(ninja.getDojo());
		return ninjaRepository.save(n);
	}
}
