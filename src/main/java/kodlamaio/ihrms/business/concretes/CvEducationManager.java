package kodlamaio.ihrms.business.concretes;

import kodlamaio.ihrms.business.abstracts.CvEducationService;
import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.core.utilities.results.SuccessDataResult;
import kodlamaio.ihrms.core.utilities.results.SuccessResult;
import kodlamaio.ihrms.dataAccess.abstracts.CvEducationDao;
import kodlamaio.ihrms.entities.concretes.CvEducation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvEducationManager implements CvEducationService {

    private CvEducationDao cvEducationDao;

    public CvEducationManager(CvEducationDao cvEducationDao) {
        this.cvEducationDao = cvEducationDao;
    }

    @Override
    public DataResult<List<CvEducation>> getAll() {
        return new SuccessDataResult<>(this.cvEducationDao.findAll());
    }

    @Override
    public Result add(CvEducation cvEducation) {
        this.cvEducationDao.save(cvEducation);
        return new SuccessResult("Eğitim bilgisi eklendi");
    }
}
