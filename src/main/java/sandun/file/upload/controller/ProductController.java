package sandun.file.upload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sandun.file.upload.dto.ProductDTO;
import sandun.file.upload.service.ProductService;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveProduct(@RequestBody ProductDTO product) {
        return productService.saveProduct(product);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public int uploadFile(@RequestParam("file") MultipartFile[] files) {
        return productService.uploadFile(files);
    }


}
