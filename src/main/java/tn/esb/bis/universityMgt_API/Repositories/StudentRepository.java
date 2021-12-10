package tn.esb.bis.universityMgt_API.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bis.universityMgt_API.Entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
