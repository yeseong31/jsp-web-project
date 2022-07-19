package myshop.dao;

import myshop.dto.CategoryDTO;

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

public class CategoryDAOImpl implements CategoryDAO {
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

    protected List<CategoryDTO> makeList(ResultSet rs) throws SQLException {
        List<CategoryDTO> list = new ArrayList<>();
        while (rs.next()) {
            CategoryDTO dto = new CategoryDTO();
            dto.setCnum(rs.getInt("cnum"));
            dto.setCode(rs.getString("code"));
            dto.setCname(rs.getString("cname"));
            list.add(dto);
        }
        return list;
    }

    public int insertCate(CategoryDTO dto) {
        String sql = "insert into CATEGORY values (CATE_SEQ.nextval, ?, ?)";
        try {
            con = ds.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getCode());
            ps.setString(2, dto.getCname());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insertCate() ERROR!!");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ignored) {}
        }
        return 0;
    }

    public List<CategoryDTO> listCate() {
        String sql = "select * from CATEGORY order by CNUM";
        try {
            con = ds.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return makeList(rs);
        } catch (SQLException e) {
            System.out.println("listCate() ERROR!!");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ignored) {}
        }
        return null;
    }

    public int deleteCate(int cnum) {
        String sql = "delete from CATEGORY where cnum = ?";
        try {
            con = ds.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cnum);
            return ps.executeUpdate();
        } catch(SQLException e) {
            System.out.println("deleteCate() ERROR!!");
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            }catch(SQLException ignored) {}
        }
        return 0;
    }
}
