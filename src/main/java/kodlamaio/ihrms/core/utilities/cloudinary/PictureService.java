package kodlamaio.ihrms.core.utilities.cloudinary;

import kodlamaio.ihrms.core.utilities.results.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


public interface PictureService {
    DataResult<Map> uploadPicture(MultipartFile picture);
}
