package kodlamaio.ihrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "job_form")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class JobForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int jobId;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @Column(name = "job_definition")
    private String jobDefinition;

    @Column(name = "min_budget")
    private int minBudget;

    @Column(name = "max_budget")
    private int maxBudget;

    @Column(name = "position_count")
    private int positionCount;

    @Column(name = "form_date")
    private LocalDate formDate;

    @Column(name = "form_end_date")
    private LocalDate formEndDate;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
}