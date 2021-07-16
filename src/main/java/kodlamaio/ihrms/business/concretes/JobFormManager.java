package kodlamaio.ihrms.business.concretes;

import kodlamaio.ihrms.business.abstracts.JobFormService;
import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.core.utilities.results.SuccessDataResult;
import kodlamaio.ihrms.core.utilities.results.SuccessResult;
import kodlamaio.ihrms.dataAccess.abstracts.JobFormDao;
import kodlamaio.ihrms.entities.concretes.City;
import kodlamaio.ihrms.entities.concretes.Employer;
import kodlamaio.ihrms.entities.concretes.JobForm;
import kodlamaio.ihrms.entities.concretes.JobPosition;
import kodlamaio.ihrms.entities.dtos.JobFormDetailsDto;
import kodlamaio.ihrms.entities.dtos.JobFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Service
public class JobFormManager implements JobFormService {

    private JobFormDao jobFormDao;

    @Autowired
    public JobFormManager(JobFormDao jobFormDao) {
        this.jobFormDao = jobFormDao;
    }

    @Override
    public DataResult<List<JobFormDetailsDto>> getAll() {
        return new SuccessDataResult<List<JobFormDetailsDto>>(this.jobFormDao.getJobFormDetails());
    }

    @Override
    public Result add(JobFormDto jobFormDto) {

        JobForm jobForm = new JobForm();

        JobPosition jobPosition = new JobPosition();
        jobPosition.setJobPositionId(jobFormDto.getJobPositionId());

        City city = new City();
        city.setCityId(jobFormDto.getCityId());

        Employer employer = new Employer();
        employer.setUserId(jobFormDto.getEmployerId());

        jobForm.setJobPosition(jobPosition);
        jobForm.setCity(city);
        jobForm.setEmployer(employer);

        jobForm.setJobDefinition(jobFormDto.getJobDefinition());
        jobForm.setMinBudget(jobFormDto.getMinBudget());
        jobForm.setMaxBudget(jobFormDto.getMaxBudget());
        jobForm.setPositionCount(jobFormDto.getPositionCount());
        jobForm.setFormDate(LocalDate.now());
        jobForm.setFormEndDate(jobFormDto.getFormEndDate());
        jobForm.setActive(true);

        this.jobFormDao.save(jobForm);
        return new SuccessResult("İş ilanı eklendi.");
    }

    @Override
    public DataResult<List<JobFormDetailsDto>> getAllDateSorted(boolean sortType) {
        if (sortType)
            return new SuccessDataResult<List<JobFormDetailsDto>>(this.jobFormDao.getJobFormDetailsOrderByDesc());

        return new SuccessDataResult<List<JobFormDetailsDto>>(this.jobFormDao.getJobFormDetailsOrderByASC());
    }

    @Override
    public DataResult<List<JobFormDetailsDto>> getCompanyForms(String companyName) {
        return new SuccessDataResult<List<JobFormDetailsDto>>(this.jobFormDao.getJobFormDetailsByCompanyName(companyName));
    }

    @Override
    public Result closeJobForm(int jobId) {
        JobForm jobForm = new JobForm();
        jobForm = this.jobFormDao.getJobFormByJobId(jobId);
        jobForm.setActive(false);
        this.jobFormDao.save(jobForm);
        return new SuccessResult("Form kapatıldı!");
    }
}
