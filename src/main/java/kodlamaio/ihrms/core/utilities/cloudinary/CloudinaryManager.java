package kodlamaio.ihrms.core.utilities.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.ihrms.core.utilities.results.DataResult;
import kodlamaio.ihrms.core.utilities.results.ErrorDataResult;
import kodlamaio.ihrms.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CloudinaryManager implements PictureService{

    private Cloudinary cloudinary;

    public CloudinaryManager() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name","nacarct","api_key","211149769171126","api_secret","SLooREKcyq02W4KrbkAza_KIKhs"));
    }

    @Override
    public DataResult<Map> uploadPicture(MultipartFile picture) {

        try {
            @SuppressWarnings("unchecked")
            Map<String,String> map = (Map<String, String>) cloudinary.uploader().upload(picture.getBytes(),ObjectUtils.emptyMap());

            return new SuccessDataResult<>(map);
        }
        catch (Exception e){

        }

        return new ErrorDataResult<Map>();
    }
}
