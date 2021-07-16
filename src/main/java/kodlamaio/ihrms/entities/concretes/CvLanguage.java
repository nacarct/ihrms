package kodlamaio.ihrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(name = "cv_languages")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_language_id")
    private int languageId;

    @NotBlank(message = "Yabancı dil adı boş geçilemez!")
    @Column(name = "language_name")
    private String languageName;

    @Min(1)
    @Max(5)
    @NotNull(message = "Yabancı dil seviyesi boş geçilemez!")
    @Column(name = "language_level")
    private short languageLevel;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    private EmployeeCv employeeCv;
}
