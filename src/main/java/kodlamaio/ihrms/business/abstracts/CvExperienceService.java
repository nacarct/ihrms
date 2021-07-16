package kodlamaio.ihrms.business.abstracts;

import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.CvExperience;

import java.util.List;

public interface CvExperienceService {
    DataResult<List<CvExperience>> getAll();
    Result add(CvExperience cvExperience);
}
