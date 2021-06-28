package test.model.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class memberDAO{
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<memberDTO> member() throws Exception{
		ArrayList<memberDTO> list = null;
		conn = ConnectionDAO.getConnection();
		String sql = "select * from member";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		System.out.println("rs:"+rs);
		list = new ArrayList<memberDTO>();
		while(rs.next()) {
			memberDTO dto = new memberDTO();
			dto.setNum(rs.getInt("num"));
			dto.setName(rs.getString("name"));
			dto.setReg_date(rs.getTimestamp("reg_date"));
			list.add(dto);
		}
		ConnectionDAO.close(rs, pstmt, conn);
		
		return  list;
	}
}
