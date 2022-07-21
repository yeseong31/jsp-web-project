package myshop.dao;

import myshop.dto.CategoryDTO;
import myshop.dto.ProductDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    private static DataSource ds;
    static {
        try {
            Context init = new InitialContext();
            ds = (DataSource) init.lookup("java:/comp/env/jdbc/oracleXE");
        } catch(NamingException e) {
            System.out.println("lookup 실패: " + e.getMessage());
        }
    }

    protected List<ProductDTO> makeList(ResultSet rs) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        while (rs.next()) {
            ProductDTO dto = new ProductDTO();
            dto.setPnum(rs.getInt("pnum"));
            dto.setPname(rs.getString("pname"));
            dto.setPcategory_fk(rs.getString("pcategory_fk"));
            dto.setPcompany(rs.getString("pcompany"));
            dto.setPimage(rs.getString("pimage"));
            dto.setPqty(rs.getInt("pqty"));
            dto.setPrice(rs.getInt("price"));
            dto.setPspec(rs.getString("pspec"));
            dto.setPcontents(rs.getString("pcontents"));
            dto.setPoint(rs.getInt("point"));
            dto.setPinputdate(rs.getString("pinputdate"));
            list.add(dto);
        }
        return list;
    }

    @Override
    public int insertProd(ProductDTO dto) {
        String sql = "insert into PRODUCT values (PROD_SEQ.nextval,?,?,?,?,?,?,?,?,?,sysdate)";
        try {
            con = ds.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getPname());
            ps.setString(2, dto.getPcategory_fk());
            ps.setString(3, dto.getPcompany());
            ps.setString(4, dto.getPimage());
            ps.setInt(5, dto.getPqty());
            ps.setInt(6, dto.getPrice());
            ps.setString(7, dto.getPspec());
            ps.setString(8, dto.getPcontents());
            ps.setInt(9, dto.getPoint());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insertProd() ERROR!!");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ignored) {}
        }
        return 0;
    }

    @Override
    public List<ProductDTO> listProd() {
        String sql = "select * from PRODUCT order by PNUM";
        try {
            con = ds.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return makeList(rs);
        } catch (SQLException e) {
            System.out.println("listProd() ERROR!!");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ignored) {}
        }
        return null;
    }

    @Override
    public int deleteProd(int pnum) {
        String sql = "delete from PRODUCT where pnum = ?";
        try {
            con = ds.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pnum);
            return ps.executeUpdate();
        } catch(SQLException e) {
            System.out.println("deleteProd() ERROR!!");
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            }catch(SQLException ignored) {}
        }
        return 0;
    }

    @Override
    public int updateProd(ProductDTO dto) {
        return 0;
    }
}
