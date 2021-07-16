package kodlamaio.ihrms.business.abstracts;

import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.Admin;

import java.util.List;

public interface AdminService {
    DataResult<List<Admin>> getAll();
    Result add(Admin admin);
    DataResult<Admin> getByEmail(String email);
}
