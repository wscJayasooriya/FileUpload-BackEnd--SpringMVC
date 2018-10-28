package sandun.file.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sandun.file.upload.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
