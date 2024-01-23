package tw.MidtermTopic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public interface IChildCareDAo {
		public CareData  findByIdAndDownload(int id , String file ) throws Exception;
		public CareData  findById(int selecct  , int id ) throws Exception;
		public void delete(String colurName, String values)throws SQLException;
		public void update(int id , String colurName, String change)throws SQLException;
		public void pictureStore(String name , String url)throws IOException, SQLException;
		public void add(CareData data)throws SQLException;
		
		public void createConn()throws SQLException;
		public void closeConn()throws SQLException;
		public void insertFiletoDb(String file) throws IOException , SQLException;
		public void downloadfile(String name , String files)throws IOException , SQLException;
		public void pictureDownload(int id ,String url)throws IOException , SQLException;
		
}
