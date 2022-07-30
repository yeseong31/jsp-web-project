package myshop.dao;

import com.oreilly.servlet.MultipartRequest;
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
    public int insertProd(MultipartRequest mr) {
        String sql = "insert into PRODUCT values (PROD_SEQ.nextval,?,?,?,?,?,?,?,?,?,sysdate)";
        try {
            con = ds.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, mr.getParameter("name"));
            ps.setString(2,
                    mr.getParameter("pcategory_fk") + mr.getParameter("code"));
            ps.setString(3, mr.getParameter("company"));
            ps.setString(4, mr.getFilesystemName("filename"));
            ps.setInt(5, Integer.parseInt(mr.getParameter("qty")));
            ps.setInt(6, Integer.parseInt(mr.getParameter("price")));
            ps.setString(7, mr.getParameter("specs"));
            ps.setString(8, mr.getParameter("content"));
            ps.setInt(9, Integer.parseInt(mr.getParameter("point")));
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
    public int updateProd(MultipartRequest mr) {
        String sql = "update PRODUCT set PNAME=?, PCOMPANY=?, PIMAGE=?, PQTY=?, PRICE=?, PSPEC=?, PCONTENTS=?, POINT=? where PNUM=?";
        try {
            con = ds.getConnection();
            ps = con.prepareStatement(sql);
            String img = mr.getFilesystemName("filename");
            if (img == null)
                img = mr.getFilesystemName("filename2")
;            ps.setString(1, mr.getParameter("name"));
            ps.setString(2, mr.getParameter("company"));
            ps.setString(3, img);
            ps.setInt(4, Integer.parseInt(mr.getParameter("qty")));
            ps.setInt(5, Integer.parseInt(mr.getParameter("price")));
            ps.setString(6, mr.getParameter("specs"));
            ps.setString(7, mr.getParameter("content"));
            ps.setInt(8, Integer.parseInt(mr.getParameter("point")));
            ps.setInt(9, Integer.parseInt(mr.getParameter("num")));
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("updateProd() ERROR!!");
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
    public ProductDTO getProd(int pnum) {
        String sql = "select * from PRODUCT where pnum = ?";
        try {
            con = ds.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pnum);
            rs = ps.executeQuery();
            return makeList(rs).get(0);
        } catch (SQLException e) {
            System.out.println("getProd() ERROR!!");
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
    public List<ProductDTO> selectBySpec(String spec) {
        String sql = "select * from PRODUCT where PSPEC = ?";
        try {
            con = ds.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, spec);
            rs = ps.executeQuery();
            return makeList(rs);
        } catch (SQLException e) {
            System.out.println("selectBySpec() ERROR!!");
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
    public List<ProductDTO> getListProdByCateCode(String code) {
        String sql = "select * from PRODUCT where PCATEGORY_FK like ?";
        try {
            con = ds.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, code + '%');
            rs = ps.executeQuery();
            return makeList(rs);
        } catch (SQLException e) {
            System.out.println("getListProdByCateCode() ERROR!!");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ignored) {}
        }
        return null;
    }
}
