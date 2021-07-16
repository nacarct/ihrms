package kodlamaio.ihrms.business.concretes;

import kodlamaio.ihrms.business.abstracts.EmployeeCvService;
import kodlamaio.ihrms.core.utilities.cloudinary.PictureService;
import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.core.utilities.results.SuccessDataResult;
import kodlamaio.ihrms.core.utilities.results.SuccessResult;
import kodlamaio.ihrms.dataAccess.abstracts.*;
import kodlamaio.ihrms.entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeCvManager implements EmployeeCvService {

    private EmployeeCvDao employeeCvDao;
    private CvSkillDao cvSkillDao;
    private CvLanguageDao cvLanguageDao;
    private CvExperienceDao cvExperienceDao;
    private CvEducationDao cvEducationDao;

    private PictureService pictureService;

    @Autowired
    public EmployeeCvManager(EmployeeCvDao employeeCvDao, CvSkillDao cvSkillDao, CvLanguageDao cvLanguageDao, CvExperienceDao cvExperienceDao, CvEducationDao cvEducationDao, PictureService pictureService) {
        this.employeeCvDao = employeeCvDao;
        this.cvSkillDao = cvSkillDao;
        this.cvLanguageDao = cvLanguageDao;
        this.cvExperienceDao = cvExperienceDao;
        this.cvEducationDao = cvEducationDao;
        this.pictureService = pictureService;
    }

    @Override
    public DataResult<List<EmployeeCv>> getAll() {
        return new SuccessDataResult<>(this.employeeCvDao.findAll());
    }

    @Override
    public Result add(EmployeeCv employeeCv) {
        this.employeeCvDao.save(employeeCv);

        this.employeeCvDao.flush();

        for (CvSkill skill: employeeCv.getCvSkills()){
            skill.setEmployeeCv(employeeCv);
            this.cvSkillDao.save(skill);
        }

        for (CvLanguage language:employeeCv.getCvLanguages()){
            language.setEmployeeCv(employeeCv);
            this.cvLanguageDao.save(language);
        }

        for (CvExperience experience:employeeCv.getCvExperiences()){
            experience.setEmployeeCv(employeeCv);
            this.cvExperienceDao.save(experience);
        }

        for (CvEducation education: employeeCv.getCvEducations()){
            education.setEmployeeCv(employeeCv);
            this.cvEducationDao.save(education);
        }

        return new SuccessResult("CV eklendi.");
    }

    @Override
    public Result addPicture(int employeeCvId, MultipartFile picture) {
        @SuppressWarnings("unchecked")
        Map<String,String> uploadPicture = this.pictureService.uploadPicture(picture).getData();

        EmployeeCv employeeCv = this.employeeCvDao.getById(employeeCvId);
        employeeCv.setPictureUrl(uploadPicture.get("url"));

        this.employeeCvDao.save(employeeCv);
        return new SuccessResult("Fotoğraf eklendi!");
    }
}
