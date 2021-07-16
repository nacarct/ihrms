package kodlamaio.ihrms.business.concretes;

import kodlamaio.ihrms.business.abstracts.AdminService;
import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.core.utilities.results.SuccessDataResult;
import kodlamaio.ihrms.core.utilities.results.SuccessResult;
import kodlamaio.ihrms.dataAccess.abstracts.AdminDao;
import kodlamaio.ihrms.entities.concretes.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminManager implements AdminService {

    private AdminDao adminDao;

    @Autowired
    public AdminManager(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public DataResult<List<Admin>> getAll() {
        return new SuccessDataResult<>(this.adminDao.findAll());
    }

    @Override
    public Result add(Admin admin) {
        this.adminDao.save(admin);
        return new SuccessResult("Admin eklendi.");
    }

    @Override
    public DataResult<Admin> getByEmail(String email) {
        return new SuccessDataResult<>(this.adminDao.getAdminByEmail(email));
    }
}
