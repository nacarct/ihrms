package kodlamaio.ihrms.dataAccess.abstracts;

import kodlamaio.ihrms.entities.concretes.CvLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvLanguageDao extends JpaRepository<CvLanguage, Integer> {
}