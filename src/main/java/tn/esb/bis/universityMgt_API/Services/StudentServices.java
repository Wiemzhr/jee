package tn.esb.bis.universityMgt_API.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.bis.universityMgt_API.Entities.Student;
import tn.esb.bis.universityMgt_API.Repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    private StudentRepository studentRepos;

    public ResponseEntity<?> getAllStudents() {
        List<Student> res = studentRepos.findAll();
        if (res.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity addStudent(Student st) {
        if (studentRepos.findAll().contains(st))
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("This student already exists");

        Student s = studentRepos.save(st);
        return ResponseEntity.status(HttpStatus.CREATED).body(st);
    }

    public ResponseEntity<?> getStudentById(Long id)
    {
        Optional<Student> st=studentRepos.findById(id);
        if (st.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("this student does not exist");
        return ResponseEntity.status(HttpStatus.OK).body(st.get());
    }


}
