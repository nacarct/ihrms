package kodlamaio.ihrms.dataAccess.abstracts;

import kodlamaio.ihrms.entities.concretes.CvExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvExperienceDao extends JpaRepository<CvExperience, Integer> {
}