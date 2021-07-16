package kodlamaio.ihrms.business.abstracts;

import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.EmployeeCv;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeCvService {
    DataResult<List<EmployeeCv>> getAll();
    Result add(EmployeeCv employeeCv);
    Result addPicture(int EmployeeId, MultipartFile picture);
}
