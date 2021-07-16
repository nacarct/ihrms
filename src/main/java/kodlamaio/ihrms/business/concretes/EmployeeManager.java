package kodlamaio.ihrms.business.concretes;

import kodlamaio.ihrms.business.abstracts.EmployeeService;
import kodlamaio.ihrms.core.InfoSystem.InfoService;
import kodlamaio.ihrms.core.NICS.NationalIdentityCheckService;
import kodlamaio.ihrms.core.utilities.results.*;
import kodlamaio.ihrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.ihrms.entities.concretes.Employee;
import kodlamaio.ihrms.entities.dtos.EmployeeForAuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;
    private InfoService infoService;
    private NationalIdentityCheckService nationalIdentityCheckService;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao,NationalIdentityCheckService nationalIdentityCheckService,
                           InfoService infoService) {
        this.employeeDao = employeeDao;
        this.nationalIdentityCheckService = nationalIdentityCheckService;
        this.infoService=infoService;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<>(this.employeeDao.findAll());
    }

    @Override
    public Result add(EmployeeForAuthDto employeeForAuthDto) {

        if (!nationalIdentityCheckService.checkNationalIdentity(employeeForAuthDto.getCitizenId()))
            return new ErrorResult("TC Numarası hatalı!");

        if (!employeeForAuthDto.getPassword().equals(employeeForAuthDto.getRePassword()))
            return new ErrorResult("Parolalar uyuşmuyor!");

        if (getEmployeeByCitizenId(employeeForAuthDto.getCitizenId()))
            return new ErrorResult("TC Numarası sistemde kayıtlı!");

        if (getEmployeeByUserEmail(employeeForAuthDto.getEmail()))
            return new ErrorResult("Email sistemde kayıtlı!");

        Employee employee = new Employee();

        employee.setFirstName(employeeForAuthDto.getFirstName());
        employee.setLastName(employeeForAuthDto.getLastName());
        employee.setCitizenId(employeeForAuthDto.getCitizenId());
        employee.setYearOfBirth(employeeForAuthDto.getYearOfBirth());
        employee.setEmail(employeeForAuthDto.getEmail());
        employee.setPassword(employeeForAuthDto.getPassword());
        employee.setEmailStatus(false);
        employee.setCitizenIdStatus(false);
        employee.setUserStatus(false);

        this.employeeDao.save(employee);
        infoService.sendInfo(employee.getEmail());
        return new SuccessResult("İş arayan eklendi.");
    }

    @Override
    public boolean getEmployeeByCitizenId(String citizenId) {
        var result=false;
        try{
            if (this.employeeDao.getEmployeeByCitizenId(citizenId).getCitizenId().length()>0)
                result=true;
            else
                result=false;
        }
        catch (Exception e){
            return false;
        }

        return result;
    }

    @Override
    public boolean getEmployeeByUserEmail(String email) {
        var result=false;
        try {
            if (this.employeeDao.getEmployeeByEmail(email).getEmail().length()>0)
                result=true;
            else
                result=false;
        }
        catch (Exception e){
            return false;
        }

        return result;
    }
}
