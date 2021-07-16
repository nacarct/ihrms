package kodlamaio.ihrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(name = "cv_skills")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_skill_id")
    private int skillId;

    @NotBlank(message = "Yetenek adı boş geçilemez!")
    @Column(name = "skill_name")
    private String skillName;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    private EmployeeCv employeeCv;
}
