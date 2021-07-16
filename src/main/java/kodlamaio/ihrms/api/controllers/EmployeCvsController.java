package kodlamaio.ihrms.api.controllers;

import kodlamaio.ihrms.business.abstracts.EmployeeCvService;
import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.EmployeeCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/employeecvs")
public class EmployeCvsController {

    private EmployeeCvService employeeCvService;

    @Autowired
    public EmployeCvsController(EmployeeCvService employeeCvService) {
        this.employeeCvService = employeeCvService;
    }

    @GetMapping("/getAll")
    public DataResult<List<EmployeeCv>> getAll(){
        return this.employeeCvService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody EmployeeCv employeeCv){
        return this.employeeCvService.add(employeeCv);
    }

    @PostMapping("/addPicture")
    public Result addPicture(@RequestParam(value = "employeeCvId") int employeeCvId ,@RequestParam(value = "picture") MultipartFile picture){
        return this.employeeCvService.addPicture(employeeCvId,picture);
    }
}
