package kodlamaio.ihrms.api.controllers;

import kodlamaio.ihrms.business.abstracts.EmployeeService;
import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.Employee;
import kodlamaio.ihrms.entities.dtos.EmployeeForAuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employee>> getAll(){
        return this.employeeService.getAll();
    }

    @GetMapping("/add")
    public Result add(@Valid EmployeeForAuthDto employeeForAuthDto){
        return this.employeeService.add(employeeForAuthDto);
    }
}
