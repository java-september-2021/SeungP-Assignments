package com.foof.relationships.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.foof.relationships.models.License;
import com.foof.relationships.models.Person;
import com.foof.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	
    public List<License> allLicenses() {
        return licenseRepository.findAll();
    }
    
    public License createLicense(License l) {
        return licenseRepository.save(l);
    }
    
    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }
	public void deleteAll() {
		licenseRepository.deleteAll();
	}
	public License updateLicense(Long id, String number, Date expiration_date, String state, Person person) {
		License l = findLicense(id);
		l.setNumber(number);
		l.setExpiration_date(expiration_date);
		l.setState(state);
		l.setPerson(person);
		return licenseRepository.save(l);
	}
	public void deleteLicense(Long id) {
		licenseRepository.deleteById(id);
		
	}
}
