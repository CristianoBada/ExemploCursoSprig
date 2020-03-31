package com.spring.curso.endpoint;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.curso.error.ResourceNotFoundException;
import com.spring.curso.model.Student;
import com.spring.curso.repository.StudentRepository;

@RestController
@RequestMapping("students")
public class StudentEndpoint {

	private final StudentRepository studentDAO;

	@Autowired
	public StudentEndpoint(StudentRepository studentDAO) {
		this.studentDAO = studentDAO;
	}

	@GetMapping
	public ResponseEntity<?> listAll(Pageable pageable) {
		return new ResponseEntity<>(studentDAO.findAll(pageable), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
		verifyIfStudentExists(id);
		Student student = studentDAO.findById(id).get(); 
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	private void verifyIfStudentExists(Long id) {
		if (!studentDAO.findById(id).isPresent())
			throw new ResourceNotFoundException("Student not found for ID: " + id);
	}

	@GetMapping(path = "/findByName/{name}")
	public ResponseEntity<?> getStudentByName(@PathVariable("name") String name) {
		return new ResponseEntity<>(studentDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> save(@Valid @RequestBody Student student) {
		return new ResponseEntity<>(studentDAO.save(student), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfStudentExists(id);
		studentDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody Student student) {
		verifyIfStudentExists(student.getId());
		studentDAO.save(student);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
