package kodlamaio.ihrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "employee_cv")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCv{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_id")
    private int cvId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "cover_letter")
    private String coverLetter;

    @OneToMany(mappedBy = "employeeCv")
    private List<CvSkill> cvSkills;

    @OneToMany(mappedBy = "employeeCv")
    private List<CvEducation> cvEducations;

    @OneToMany(mappedBy = "employeeCv")
    private List<CvExperience> cvExperiences;

    @OneToMany(mappedBy = "employeeCv")
    private List<CvLanguage> cvLanguages;
}
