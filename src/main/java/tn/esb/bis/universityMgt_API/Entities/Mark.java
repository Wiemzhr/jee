package tn.esb.bis.universityMgt_API.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Mark {
  @Id @GeneratedValue private Long id;

  @NonNull private Float value;

  private String distinction;

  @NonNull private String justification;

  @ManyToOne
  @JoinColumn(name = "id_student", referencedColumnName = "id")
  private Student StudentMark;

  @ManyToOne
  @JoinColumn(name = "id_module", referencedColumnName = "id")
  private Module StudentModule;

  public Mark(@NonNull Float value, String distinction, @NonNull String justification) {
    this.value = value;
    this.distinction = distinction;
    this.justification = justification;
  }
}
