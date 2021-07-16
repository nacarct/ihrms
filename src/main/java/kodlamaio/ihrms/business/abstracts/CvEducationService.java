package kodlamaio.ihrms.business.abstracts;

import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.CvEducation;

import java.util.List;

public interface CvEducationService {
    DataResult<List<CvEducation>> getAll();
    Result add(CvEducation cvEducation);
}
