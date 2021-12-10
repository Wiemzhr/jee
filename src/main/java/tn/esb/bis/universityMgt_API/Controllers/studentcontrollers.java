package tn.esb.bis.universityMgt_API.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tn.esb.bis.universityMgt_API.Entities.Student;
import tn.esb.bis.universityMgt_API.Services.StudentServices;

import javax.validation.Valid;

@RestController
//path coté client sera http://localhost:9592/students
@RequestMapping("/students")
public class studentcontrollers {
    @Autowired
    private StudentServices studentServ;

    //concatener au path "/all"
    @GetMapping("/all")
    public ResponseEntity<?> allStudents() {
        return studentServ.getAllStudents();
    }

    //La requete provenent du client client une entete presentant des infos generales grenre la méthode HTTP utilisée ( GET, POST..)
    // Ainsi que le type de données transmis ( Text, xml, json ...)
    //La requete contient aussi un corp ( body ) qui a son tours contient les datas a transmettre au service
    // ici le student st sera transmis dans le body
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student st) {
        return studentServ.addStudent(st);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id)
    {
        return studentServ.getStudentById(id);
    }
}
