package kodlamaio.ihrms.business.abstracts;

import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.CvLanguage;

import java.util.List;

public interface CvLanguageService {
    DataResult<List<CvLanguage>> getAll();
    Result add(CvLanguage cvLanguage);
}
