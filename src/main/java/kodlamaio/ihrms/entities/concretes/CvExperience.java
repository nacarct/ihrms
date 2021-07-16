package kodlamaio.ihrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(name = "cv_experiences")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_experience_id")
    private int experienceId;

    @NotBlank(message = "Şirket adı boş geçilemez!")
    @Column(name = "company_name")
    private String companyName;

    @NotBlank(message = "Pozisyon adı boş geçilemez!")
    @Column(name = "position_name")
    private String positionName;

    @NotNull(message = "Başlangıç tarihi boş geçilemez!")
    @Column(name = "start_year")
    private int startYear;

    @Column(name = "end_year")
    @Nullable
    private int endYear;

    @Column(name = "working_now")
    private boolean workingNow;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    private EmployeeCv employeeCv;
}
