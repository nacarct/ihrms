package kodlamaio.ihrms.api.controllers;

import kodlamaio.ihrms.business.abstracts.JobPositionService;
import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositionService.getAll();
    }

    @GetMapping("/add")
    public Result add(String jobPositionName){
        return this.jobPositionService.add(jobPositionName);
    }
}
