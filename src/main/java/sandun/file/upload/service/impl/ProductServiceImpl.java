package sandun.file.upload.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sandun.file.upload.dto.ProductDTO;
import sandun.file.upload.entity.Product;
import sandun.file.upload.repository.ProductRepository;
import sandun.file.upload.service.ProductService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    private String folderPath = "H:\\My Project\\FileUpload\\images\\";

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveProduct(ProductDTO productDTO) {
        Product product = new Product(
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getPrice(),
                productDTO.getImgURL());

        productRepository.save(product);

        return true;
    }

    @Override
    public int uploadFile(MultipartFile[] files) {
        int reply = 0;
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                reply = 1;
            }
            try {
                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                Path path = Paths.get(folderPath + file.getOriginalFilename());
                Files.write(path, bytes);

                reply = 2;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return reply;
    }

}
