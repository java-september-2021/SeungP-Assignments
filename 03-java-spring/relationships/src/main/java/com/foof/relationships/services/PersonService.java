package com.foof.relationships.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.foof.relationships.models.Person;
import com.foof.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> allPersons() {
        return personRepository.findAll();
    }
    
    public Person createPerson(Person p) {
        return personRepository.save(p);
    }
    
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
	public void deleteAll() {
		personRepository.deleteAll();
	}
	public Person updatePerson(Long id, String firstName, String lastName) {
		Person p = findPerson(id);
		p.setFirstName(firstName);
		p.setLastName(lastName);
		return personRepository.save(p);
	}
	public void deleteLicense(Long id) {
		personRepository.deleteById(id);
		
	}
}
