package kodlamaio.ihrms.business.abstracts;

import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    DataResult<List<JobPosition>> getAll();
    Result add(String jobPositionName);
    JobPosition getJobPositionByJobPositionName(String jobPositionName);
}
