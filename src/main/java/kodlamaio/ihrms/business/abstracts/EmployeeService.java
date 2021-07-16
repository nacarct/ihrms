package kodlamaio.ihrms.business.abstracts;

import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.Employee;
import kodlamaio.ihrms.entities.dtos.EmployeeForAuthDto;

import java.util.List;

public interface EmployeeService {
    DataResult<List<Employee>> getAll();
    Result add(EmployeeForAuthDto employeeForAuthDto);
    boolean getEmployeeByCitizenId(String citizenId);
    boolean getEmployeeByUserEmail(String email);
}
