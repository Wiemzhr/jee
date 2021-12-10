package tn.esb.bis.universityMgt_API.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import tn.esb.bis.universityMgt_API.Enumerations.teacherGrade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Teacher {
  @Id @GeneratedValue private Long id;

  @NonNull private String firstName;

  @NonNull private String lastName;

  private teacherGrade grade;

  @OneToMany(mappedBy = "TeacherModule", cascade = CascadeType.ALL)
  private Set<Module> Modules = new HashSet<>();

  public Teacher(@NonNull String firstName, @NonNull String lastName, teacherGrade grade) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.grade = grade;
  }
}
