package kodlamaio.ihrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(name = "cv_educations")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvEducation {

    @Id
    @Column(name = "cv_education_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int educationId;

    @NotBlank(message = "Okuladı boş geçilemez!")
    @Column(name = "school_name")
    private String schoolName;

    @NotBlank(message = "Okul bölümü boş geçilemez!")
    @Column(name = "school_section")
    private String schoolSection;

    @NotNull(message = "Başlangıç tarihi geçilemez!")
    @Column(name = "start_year")
    private int startYear;

    @Column(name = "end_year")
    @Nullable
    private int endYear;

    @Column(name = "study_now")
    private boolean studyNow;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    private EmployeeCv employeeCv;
}
