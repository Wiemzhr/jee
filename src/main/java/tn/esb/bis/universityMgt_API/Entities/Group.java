package tn.esb.bis.universityMgt_API.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Integer capacity;
    private String description;
    @ManyToMany
    // La création de la table association avec @JoinTable est valable uniquement lorsque
    // la table association contient uniquement les deux clés étrangéres formant une clé primaire
    // composite.
    @JoinTable(
            name = "Group_Modules",
            joinColumns = @JoinColumn(name = "id_group", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_module", referencedColumnName = "id")
            // Pour créer une table association
            // Les deux clé etrangeres formant la clé primaire composite
    )
    private Set<Module> modules = new HashSet<>();
    @OneToMany(mappedBy = "StudentGroup", cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    public Group(@NonNull String name, @NonNull int capacity, String description) {
        this.name = name;
        this.capacity = capacity;
        this.description = description;
    }
}
