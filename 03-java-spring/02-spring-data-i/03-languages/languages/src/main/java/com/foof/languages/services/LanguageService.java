package com.foof.languages.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.foof.languages.models.Language;
import com.foof.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository=languageRepository;
	}
	
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	public Language createLanguage(Language l) {
		return languageRepository.save(l);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteAll() {
		languageRepository.deleteAll();
	}
	public Language updateBook(Long id, String name, String creator, String currentVersion) {
		Language l = findLanguage(id);
		l.setName(name);
		l.setCreator(creator);
		l.setCurrentVersion(currentVersion);
		return languageRepository.save(l);
	}
	public void deleteBook(Long id) {
		languageRepository.deleteById(id);
		
	}
	public Language updateBook(@Valid Language language) {
		Language l = findLanguage(language.getId());
		l.setName(language.getName());
		l.setCreator(language.getCreator());
		l.setCurrentVersion(language.getCurrentVersion());
		return languageRepository.save(l);
		
	}
}
