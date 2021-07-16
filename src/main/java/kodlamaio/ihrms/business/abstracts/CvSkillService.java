package kodlamaio.ihrms.business.abstracts;

import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.CvSkill;

import java.util.List;

public interface CvSkillService {
    DataResult<List<CvSkill>> getAll();
    Result add(CvSkill cvSkill);
}
