package kodlamaio.ihrms.business.concretes;

import kodlamaio.ihrms.business.abstracts.JobPositionService;
import kodlamaio.ihrms.core.utilities.results.*;
import kodlamaio.ihrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.ihrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(this.jobPositionDao.findAll());
    }

    @Override
    public Result add(String jobPositionName) {

        if (positionNameExist(jobPositionName))
            return new ErrorResult("İş pozisyonu sistemde mevcut!");

        JobPosition jobPosition = new JobPosition();
        jobPosition.setJobPositionName(jobPositionName);

        this.jobPositionDao.save(jobPosition);

        return new SuccessResult("İş pozisyonu eklendi.");
    }

    @Override
    public JobPosition getJobPositionByJobPositionName(String jobPositionName) {
        return this.jobPositionDao.getJobPositionByJobPositionName(jobPositionName);
    }

    public boolean positionNameExist(String positionName){

        try {
            if (positionName.equals(getJobPositionByJobPositionName(positionName).getJobPositionName()))
                return true;
        }
        catch (Exception e){
            return false;
        }

        return false;
    }
}
