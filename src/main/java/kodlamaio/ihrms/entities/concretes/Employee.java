package kodlamaio.ihrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "employees")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="employee_id",referencedColumnName = "user_id")
public class Employee extends User{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "citizen_id")
    private String citizenId;

    @Column(name = "year_of_birth")
    private String yearOfBirth;

    @Column(name = "email_status")
    private boolean emailStatus;

    @Column(name = "citizen_id_status")
    private boolean citizenIdStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<EmployeeCv> employeeCvs;

}
