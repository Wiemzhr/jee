package tn.esb.bis.universityMgt_API.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import tn.esb.bis.universityMgt_API.Enumerations.studyLevel;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter //Permet de generer tous les getters pour tous les attributs
@Setter // Permet de generer tous les setters pour tous les attributs
@NoArgsConstructor // Permet de generer un constructeur non paramétré
@RequiredArgsConstructor
//@ToString Redefinition de toString() retournant une chaine de caractere contenant les valeurs de tous les attributs
@ToString(exclude = "photo") //Retourne les valeurs de tous les champs sauf Photo
@Entity  //La classe student sera transformé en une table relationnelle par l'ORM // ORM : Object Relationnal Mapper
// L'ORM dans le cas de spring-boot est Hibernate
@Table(name = "student_tab")
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Redefinit les méthodes equals() et hashCode de la classe Object
//Dans ce cas deux  etudiants sont identique s'il y a egalité entre tous les champs annotés avec @EqualsAndHshcode.Include
public class Student {
    @Id //Primary Key
    @GeneratedValue
    // La clé primaire sera automatiquement générée ( par défaut identity (commence par 1 et incrémente par 1))
    private Long id;

    @NonNull //first name est obligatoire
    @Column(name = "first_name", length = 50)
    @EqualsAndHashCode.Include
    private String firstName;

    @Column(name = "last_name", length = 50)
    @NonNull
    @EqualsAndHashCode.Include
    private String lastName;

    @NonNull
    @JsonFormat(pattern = "yyyy-mm-dd")
    @EqualsAndHashCode.Include
    private LocalDate birthDate;

    private studyLevel level;

    @NonNull
    @Column(name = "email", unique = true, length = 255)
    private String email;

    @Lob // Pour pouvoir stocker la photo dans la BD
    private byte[] photo;

    @ManyToOne
    @JoinColumn(name = "id_group", referencedColumnName = "id")
    private Group StudentGroup;

    @OneToOne(mappedBy = "Student", cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private Address StudentAddress;

    @OneToMany(mappedBy = "StudentMark", cascade = CascadeType.ALL)
    private Set<Mark> Marks = new HashSet<>();

    public Student(Long id, @NonNull String firstName, @NonNull String lastName, @NonNull LocalDate birthDate, studyLevel level, @NonNull String email, byte[] photo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.level = level;
        this.email = email;
        this.photo = photo;
    }
}
