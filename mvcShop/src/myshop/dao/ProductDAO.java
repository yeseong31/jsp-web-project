package myshop.dao;
import myshop.dto.ProductDTO;

import java.util.List;

public interface ProductDAO {
    int insertProd(ProductDTO dto);
    List<ProductDTO> listProd();
    int deleteProd(int pnum);
    int updateProd(ProductDTO dto);
}
