package kodlamaio.ihrms.business.abstracts;

import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.Employer;
import kodlamaio.ihrms.entities.dtos.EmployerForAuthDto;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    Result add(EmployerForAuthDto employerForAuthDto);
    Employer getEmployerByEmail(String email);
}
