package sandun.file.upload.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import sandun.file.upload.dto.ProductDTO;

import java.util.ArrayList;

public interface ProductService {
    public boolean saveProduct( ProductDTO productDTO);

    public int uploadFile(MultipartFile[] files);

}
