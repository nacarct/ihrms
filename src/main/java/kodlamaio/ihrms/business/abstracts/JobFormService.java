package kodlamaio.ihrms.business.abstracts;

import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.JobForm;
import kodlamaio.ihrms.entities.dtos.JobFormDetailsDto;
import kodlamaio.ihrms.entities.dtos.JobFormDto;

import java.util.List;

public interface JobFormService {
    DataResult<List<JobFormDetailsDto>> getAll();
    Result add(JobFormDto jobFormDto);
    DataResult<List<JobFormDetailsDto>> getAllDateSorted(boolean sortType);
    DataResult<List<JobFormDetailsDto>> getCompanyForms(String companyName);
    Result closeJobForm(int jobId);
}
