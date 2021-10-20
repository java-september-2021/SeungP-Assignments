package com.foof.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.foof.dojooverflow.models.Answer;
import com.foof.dojooverflow.models.Question;
import com.foof.dojooverflow.models.Tag;
import com.foof.dojooverflow.repositories.AnswerRepository;
import com.foof.dojooverflow.repositories.QuestionRepository;
import com.foof.dojooverflow.repositories.TagRepository;

@Service
public class DojoService {
	private AnswerRepository aRepo;
	private QuestionRepository qRepo;
	private TagRepository tRepo;
	
	//Constructor
	public DojoService(AnswerRepository aRepo, QuestionRepository qRepo, TagRepository tRepo) {
		this.aRepo=aRepo;
		this.qRepo=qRepo;
		this.tRepo=tRepo;
	}
	
	//Find methods
	public List<Answer> getAllAnswers(){
		return this.aRepo.findAll();
	}
	
	public Answer getAnswer(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
	
	public List<Question> getAllQuestions(){
		return this.qRepo.findAll();
	}
	
	public Question getQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
	public List<Tag> getAllTags(){
		return this.tRepo.findAll();
	}
	
	public Tag getTag(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	//Create
	public Answer createAnswer(String a, Question q) {
		Answer newAns = new Answer(a, q);
		//a.setQuestion(q);
		return this.aRepo.save(newAns);
	}
	public Question createQuestion(Question q) {
		return this.qRepo.save(q);
	}
	public Tag createTag(Tag t) {
		return this.tRepo.save(t);
	}
	public Tag createTag(String subject) {
		Tag t = new Tag(subject);
		return tRepo.save(t);
	}
	
	//Update
	public Answer updateAnswer(@Valid Answer answer) {
		Answer a = getAnswer(answer.getId());
		a.setAnswerText(answer.getAnswerText());
		a.setQuestion(answer.getQuestion());
		return aRepo.save(a);
	}
	public Question updateQuestion(@Valid Question question) {
		Question q = getQuestion(question.getId());
		q.setQuestionText(question.getQuestionText());
		q.setAnswers(question.getAnswers());
		q.setTags(question.getTags());
		return qRepo.save(q);
	}
	public Tag updateTag(@Valid Tag tag) {
		Tag t = getTag(tag.getId());
		t.setSubject(tag.getSubject());
		t.setQuestions(tag.getQuestions());
		return tRepo.save(t);
	}
	
	public void addQuestionTag(Long qId, Long tId) {
		Question q = getQuestion(qId);
		Tag t = getTag(tId);
		q.getTags().add(t);
		qRepo.save(q);
	}
	
	public void answerQuestion(Long qId, Long aId) {
		Question q = getQuestion(qId);
		Answer a = getAnswer(aId);
		a.setQuestion(q);
	}
	
	//Others
	public boolean tagExists(Tag t) {
		List<Tag> tList = getAllTags();
		if (tList.contains(t)) {
			return true;
		}
		else return false;
	}
	public Tag tagExists(String s) {
		List<Tag> tList = getAllTags();
		for (Tag t:tList) {
			if (t.getSubject().equals(s)){
				return t;
			}
		}
		return null;
	}
	
	public Question processTagQuery(Question q) {
		String query = q.getTagQuery();
		ArrayList<Tag> tags = new ArrayList<Tag>();
		ArrayList<String> tagStrings = new ArrayList<String>();
		for (int i=0;i<3;i++) {
			if(query.indexOf(", ") != -1) {
				tagStrings.add(query.substring(0, query.indexOf(", ")));
				query = query.substring(query.indexOf(", ") + 2);
			}
			else {
				tagStrings.add(query);
				break;
			}
		}
		
		for (String s:tagStrings) {
			Tag t = tagExists(s);
			if (t == null) {
				t = createTag(s);
				tags.add(t);
			}
			else {
				tags.add(t);
			}
		}
		
		
		q.setTags(tags);
		return updateQuestion(q);
	}
}
