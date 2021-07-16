package kodlamaio.ihrms.business.abstracts;

import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.Result;
import kodlamaio.ihrms.entities.concretes.City;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();
    Result add(@RequestBody City city);
    DataResult<City> getCityByCityId(int cityId);
}
