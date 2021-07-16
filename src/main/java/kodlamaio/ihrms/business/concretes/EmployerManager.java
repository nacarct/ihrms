package kodlamaio.ihrms.business.concretes;

import kodlamaio.ihrms.business.abstracts.EmployerService;
import kodlamaio.ihrms.core.utilities.results.*;
import kodlamaio.ihrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.ihrms.entities.concretes.Employer;
import kodlamaio.ihrms.entities.dtos.EmployerForAuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll());
    }

    @Override
    public Result add(EmployerForAuthDto employerForAuthDto) {

        if (!employerForAuthDto.getPassword().equals(employerForAuthDto.getRePassword()))
            return new ErrorResult("Parolalar uyuşmuyor!");

        if (emailIfExist(employerForAuthDto.getEmail()))
            return new ErrorResult("Email sistemde kayıtlı!");

        if (!employerForAuthDto.getEmail().substring(employerForAuthDto.getEmail().indexOf("@")+1).equals(employerForAuthDto.getWebsite()))
            return new ErrorResult("Email ile website alan adı uyuşmuyor!");

        Employer employer = new Employer();
        employer.setCompanyName(employerForAuthDto.getCompanyName());
        employer.setWebsite(employerForAuthDto.getWebsite());
        employer.setPhoneNumber(employerForAuthDto.getPhoneNumber());
        employer.setEmailStatus(false);
        employer.setSystemStatus(false);
        employer.setEmail(employerForAuthDto.getEmail());
        employer.setPassword(employerForAuthDto.getPassword());
        employer.setUserStatus(false);

        this.employerDao.save(employer);

        return new SuccessResult("İş veren eklendi.");
    }

    @Override
    public Employer getEmployerByEmail(String email) {
        return this.employerDao.getEmployerByEmail(email);
    }

    public boolean emailIfExist(String email){
        try {
            if (employerDao.getEmployerByEmail(email).getEmail().equals(email))
                return true;
        }
        catch (Exception e){
            return false;
        }

        return false;
    }
}
