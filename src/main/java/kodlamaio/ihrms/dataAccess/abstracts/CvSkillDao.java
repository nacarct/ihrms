package kodlamaio.ihrms.dataAccess.abstracts;

import kodlamaio.ihrms.entities.concretes.CvSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvSkillDao extends JpaRepository<CvSkill, Integer> {
}