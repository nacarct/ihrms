package kodlamaio.ihrms.dataAccess.abstracts;

import kodlamaio.ihrms.entities.concretes.CvEducation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvEducationDao extends JpaRepository<CvEducation, Integer> {
}