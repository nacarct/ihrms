package kodlamaio.ihrms.api.controllers;

import kodlamaio.ihrms.business.abstracts.JobFormService;
import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.JobForm;
import kodlamaio.ihrms.entities.dtos.JobFormDetailsDto;
import kodlamaio.ihrms.entities.dtos.JobFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobforms")
@CrossOrigin
public class JobFormsController {

    private JobFormService jobFormService;

    @Autowired
    public JobFormsController(JobFormService jobFormService) {
        this.jobFormService = jobFormService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobFormDetailsDto>> getAll(){
        return this.jobFormService.getAll();
    }

    @GetMapping("/add")
    public Result add(@Valid JobFormDto jobFormDto){
        return this.jobFormService.add(jobFormDto);
    }

    @GetMapping("/getAllDateSorted")
    public DataResult<List<JobFormDetailsDto>> getAllDateSorted(boolean sortType){
        return this.jobFormService.getAllDateSorted(sortType);
    }

    @GetMapping("/getCompanyForms")
    public DataResult<List<JobFormDetailsDto>> getCompanyForms(String companyName){
        return this.jobFormService.getCompanyForms(companyName);
    }

    @GetMapping("/closeJobForm")
    public Result closeJobForm(int jobId){
        return this.closeJobForm(jobId);
    }

    @GetMapping("/test")
    public Result closeJobFormTest(int jobId){
        return this.closeJobForm(jobId);
    }
}
