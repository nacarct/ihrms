package kodlamaio.ihrms.api.controllers;

import kodlamaio.ihrms.business.abstracts.EmployerService;
import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.core.utilities.results.SuccessDataResult;
import kodlamaio.ihrms.entities.concretes.Employer;
import kodlamaio.ihrms.entities.dtos.EmployerForAuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @GetMapping("/add")
    public Result add(@Valid EmployerForAuthDto employerForAuthDto){
        return this.employerService.add(employerForAuthDto);
    }
}
