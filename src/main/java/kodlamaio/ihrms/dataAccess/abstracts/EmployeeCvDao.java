package kodlamaio.ihrms.dataAccess.abstracts;

import kodlamaio.ihrms.entities.concretes.EmployeeCv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCvDao extends JpaRepository<EmployeeCv, Integer> {
}