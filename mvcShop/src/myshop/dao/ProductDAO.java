package myshop.dao;
import com.oreilly.servlet.MultipartRequest;
import myshop.dto.ProductDTO;

import java.util.List;

public interface ProductDAO {
    int insertProd(MultipartRequest mr);
    List<ProductDTO> listProd();
    int deleteProd(int pnum);
    int updateProd(MultipartRequest mr);
    ProductDTO getProd(int pnum);
}
