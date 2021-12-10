package tn.esb.bis.universityMgt_API.Entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Objects;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @EqualsAndHashCode.Include
    private int number;

    @NonNull
    @EqualsAndHashCode.Include
    private String street;

    @NonNull
    @EqualsAndHashCode.Include
    private int zipCode;

    @OneToOne
    private Student Student;
}
