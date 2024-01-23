package tw.MidtermTopic;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tw.Lunyan.JDBC_util.JDBCUtil;

public class ChildCareDaoJdbcImpl  implements IChildCareDAo{
	private ArrayList<String> coulerCN = new ArrayList<String>();
	private ArrayList<String> coulerEN = new ArrayList<String>();
	private Connection conn;

	public ChildCareDaoJdbcImpl() {
		// TODO Auto-generated constructor stub
		coulerCN.add("序號");
		coulerCN.add("托育類型");
		coulerCN.add("名稱");
		coulerCN.add("行政區");
		coulerCN.add("地址");
		coulerCN.add("聯絡人");	
		coulerCN.add("電話");
		coulerCN.add("簡介");
		coulerCN.add("優惠內容");
		coulerCN.add("優惠起日");
		coulerCN.add("優惠迄日");
		coulerCN.add("備註");

		
		coulerEN.add("id");
		coulerEN.add("ChildcareType");
		coulerEN.add("ChildcareName");
		coulerEN.add("District");
		coulerEN.add("address");
		coulerEN.add("ContactPerson");	
		coulerEN.add("phone");
		coulerEN.add("Introduction");
		coulerEN.add("DiscountContent");
		coulerEN.add("DiscountStart");
		coulerEN.add("DiscountEnd");
		coulerEN.add("Remark");
				
	}

	@Override
	public CareData findById(int selecct  , int id ) throws Exception {
		String sqlStr;
		if(selecct ==0)
			sqlStr = "select * from TaipeiGovernmentEmployeesForChildren ";
		else
			sqlStr = "select * from TaipeiGovernmentEmployeesForChildren where id = ?";
		PreparedStatement state = conn.prepareStatement(sqlStr);
		if(selecct !=0)
			state.setInt(1, id);
		ResultSet rs = state.executeQuery();
		
		CareData data = null;
		while(rs.next()) {
			 data = new CareData(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) 
							, rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9) , rs.getString(10) , rs.getString(11) , rs.getString(12)   );
			 System.out.println("序號 : "+rs.getInt(1) +"\r\n"+ rs.getString(2)+"\r\n"+ rs.getString(3)+"\r\n" + rs.getString(4)+"\r\n" + rs.getString(5)+"\r\n" + rs.getString(6)
				+"\r\n" + rs.getString(7)+"\r\n" + rs.getString(8)+"\r\n" + rs.getString(9)+"\r\n" + rs.getString(10)+"\r\n" + rs.getString(11)+"\r\n" + rs.getString(12));
			 System.out.println();
		}
		

		rs.close();
		state.close();
		
		
		return data;
	}
	@Override
	public CareData findByIdAndDownload(int id , String file ) throws Exception {
		String sqlStr = "select * from TaipeiGovernmentEmployeesForChildren where id = ?";
		PreparedStatement state = conn.prepareStatement(sqlStr);
		state.setInt(1, id);
		ResultSet rs = state.executeQuery();
		
		CareData data = null;
		if(rs.next()) {
			 data = new CareData(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) 
							, rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9) , rs.getString(10) , rs.getString(11) , rs.getString(12)   );
		}
		
		
		FileWriter fw = new FileWriter(file+"/" + rs.getInt(1) + ".txt");
		fw.write(rs.getInt(1)+"," + rs.getString(2)+","+ rs.getString(3)+"," + rs.getString(4)+"," + rs.getString(5)+"," + rs.getString(6)
		+"," + rs.getString(7)+"," + rs.getString(8)+"," + rs.getString(9)+"," + rs.getString(10)+"," + rs.getString(11)+"," + rs.getString(12));
		fw.close();
		rs.close();
		state.close();
		System.out.println("find it ");
		
		return data;
	}

	@Override
	public void delete(String colurName, String values) throws SQLException {
		// TODO Auto-generated method stub
		int num = coulerCN.indexOf(colurName);
		String sqlStr = "delete TaipeiGovernmentEmployeesForChildren where "+coulerEN.get(num) +" like ? ";
		PreparedStatement state = conn.prepareStatement(sqlStr);
		if(num ==0)
			state.setInt(1, Integer.valueOf(values));
		else if (num>0)
			state.setString(1, "%"+values+"%");
		state.execute();
		
		state.close();
		
	}

	@Override
	public void update(int id, String colurName, String change) throws SQLException {
		// TODO Auto-generated method stub\
		int num = coulerCN.indexOf(colurName);
		if(num>0)
		{
			String sqlStr = "update TaipeiGovernmentEmployeesForChildren set "+coulerEN.get(num)+" = ? where id = ?";
			PreparedStatement state = conn.prepareStatement(sqlStr);
			state.setString(1, change);
			state.setInt(2, id);
			state.executeUpdate();
			System.out.println("update OK");
			state.close();
		}
		else
			System.out.println("沒有這個欄位");

		
	}
	@Override
	public void add(CareData data) throws SQLException {
		// TODO Auto-generated method stub
		String sqlStr = "insert TaipeiGovernmentEmployeesForChildren values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sqlStr);
		state.setString(1, data.getChildcareType());
		state.setString(2, data.getChildcareName());
		state.setString(3, data.getDistrict());
		state.setString(4, data.getAddress());
		state.setString(5, data.getContactPerson());
		state.setString(6, data.getPhone());
		state.setString(7, data.getIntroduction());
		state.setString(8, data.getDiscountContent());
		state.setString(9, data.getDiscountStart());
		state.setString(10, data.getDiscountEnd());
		state.setString(11, data.getRemark());
		
		state.execute();
		state.close();
		
	}

	@Override
	public void pictureStore(String name , String url) throws IOException, SQLException {
		// TODO Auto-generated method stub
		String sqlStr = "insert into FileStore (FileName , FileContent) values (?,?)";
		FileInputStream fis1 = new FileInputStream(url);
		PreparedStatement state = conn.prepareStatement(sqlStr);
		state.setString(1,name);
		state.setBinaryStream(2, fis1);
		
		state.execute();
		state.close();
	}
	@Override
	public void pictureDownload(int id ,String url) throws IOException, SQLException {
		String sqlStr = "select * from FileStore where fileid = ?";
		PreparedStatement state = conn.prepareStatement(sqlStr);
		state.setInt(1, id);
		ResultSet rs = state.executeQuery();
		

		while(rs.next()) {
			Blob blob = rs.getBlob(3);
			url = url+"/"+rs.getString("filename") + ".jpg";
			BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream(url));
			bos1.write(blob.getBytes(1, (int)blob.length()));
			bos1.flush();
			bos1.close();
			
		}
		rs.close();
		state.close();
		
		
	}
	
	@Override
	public void insertFiletoDb(String file) throws IOException, SQLException {
		BufferedReader in = new BufferedReader(new FileReader(file));
//		InputStreamReader isr = new InputStreamReader(new FileInputStream(file) , "UTF-8");
//		BufferedReader in2 = new BufferedReader(isr);
		String str ;	
		String sqlStr = "insert TaipeiGovernmentEmployeesForChildren values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sqlStr);
		while((str =in.readLine()) != null) {
			
			
			String[] token = str.split(",");
			if(token[1].equals("托育類型"))
			{
				continue;
			}
				
			for(int i =1 ; i<token.length ; i++) {
				state.setString(i, token[i]);
				
			}
			state.execute();
			
		}
		state.close();
		
	}

	@Override
	public void createConn() throws SQLException {
		JDBCUtil util = new JDBCUtil();
		conn = util.createconn();
		
	}

	@Override
	public void closeConn() throws SQLException {
		// TODO Auto-generated method stub
		if(conn!= null)
			conn.close();
		//System.out.println("Connect Close");
		
	}

	@Override
	public void downloadfile(String name, String files) throws IOException, SQLException {
		// TODO Auto-generated method stub
		String sqlStr = "select * from TaipeiGovernmentEmployeesForChildren";
		PreparedStatement state = conn.prepareStatement(sqlStr);
		ResultSet rs = state.executeQuery();
		File dir = new File(files);
		if(!dir.exists())
			dir.mkdir();
		File f1 = new File(files+"/" +name + ".txt");
		if(!f1.exists())
			 f1.createNewFile();
		FileWriter fw = new FileWriter(files+"/" +name + ".txt");
 
		while(rs.next()) {
			
			fw.write(rs.getInt(1)+"," + rs.getString(2)+","+ rs.getString(3)+"," + rs.getString(4)+"," + rs.getString(5)+"," + rs.getString(6)
			+"," + rs.getString(7)+"," + rs.getString(8)+"," + rs.getString(9)+"," + rs.getString(10)+"," + rs.getString(11)+"," + rs.getString(12));
			fw.write("\r\n");
		}
		fw.close();
		
		rs.close();
		state.close();

		
		
	}







}
