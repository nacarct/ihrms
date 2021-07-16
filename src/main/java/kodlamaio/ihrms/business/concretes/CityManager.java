package kodlamaio.ihrms.business.concretes;

import kodlamaio.ihrms.business.abstracts.CityService;
import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.core.utilities.results.SuccessDataResult;
import kodlamaio.ihrms.core.utilities.results.SuccessResult;
import kodlamaio.ihrms.dataAccess.abstracts.CityDao;
import kodlamaio.ihrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(cityDao.findAll());
    }

    @Override
    public Result add(City city) {
        this.cityDao.save(city);
        return new SuccessResult("Şehir eklendi.");
    }

    @Override
    public DataResult<City> getCityByCityId(int cityId) {
        return new SuccessDataResult<>(this.cityDao.getCityByCityId(cityId));
    }
}
