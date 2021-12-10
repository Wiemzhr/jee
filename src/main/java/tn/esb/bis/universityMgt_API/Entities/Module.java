package tn.esb.bis.universityMgt_API.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import tn.esb.bis.universityMgt_API.Enumerations.studyLevel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor // genere un constructeure avec uniquement avec des attributs obligatoire (
// annotés avec @NonNull de Lambok)
@Data // remplace le @getter et le @setter ensemble, @RequeredArgsConstructor, @ToString
@Entity
public class Module {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NonNull private String firstName;

  @NonNull private Integer numberOfHours;

  @NonNull private studyLevel level;

  @OneToMany(mappedBy = "StudentModule", cascade = CascadeType.ALL)
  private Set<Mark> Marks = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "id_teacher", referencedColumnName = "id")
  private Teacher TeacherModule;

  @ManyToMany private Set<Group> groups = new HashSet<>();
}
