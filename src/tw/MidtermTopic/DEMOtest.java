package tw.MidtermTopic;

import java.util.Scanner;

public class DEMOtest {

	public static void main(String[] args) throws Exception {
		IChildCareDAo dao = new ChildCareDaoJdbcImpl();
		  Scanner c=new Scanner(System.in);
		
		int id , function=1;
		String file ,name , values;
		
		dao.createConn();
		while(function !=0) {
			System.out.println("(一)匯出資料表");
			System.out.println("(二)讀取資料");
			System.out.println("(三)讀取資料並建立檔案");
			System.out.println("(四)存入圖片");
			System.out.println("(五)讀取圖片並建立檔案");
			System.out.println("(六)重新匯入資料表");
			System.out.println("(七)修改資料");
			System.out.println("(八)刪除資料");
			System.out.println("(九)新增資料");
			
			System.out.println("(零)結束連線");
			System.out.print("請選擇功能: "  );
			
			function = c.nextInt();
		switch (function) {
		case 1:
			System.out.println("輸入輸出位置與檔名");
			System.out.print("位置:");
			file = c.next();
			System.out.print("檔名:");
			name = c.next();
			dao.downloadfile(name, file);
			
			break;
		case 2:
			System.out.println("全部(0) , 單筆(1) :");
			id= c.nextInt();
			if(id ==0 )
				dao.findById(0,0);
			else
			{
				System.out.print("輸入查詢ID :");
				id= c.nextInt();
				dao.findById(1,id);
			}

			break;
		case 3:
			System.out.print("輸入查詢ID :");
			 id = c.nextInt();
			 System.out.print("輸入建立位置 :");
			 file = c.next();
			 dao.findByIdAndDownload(id , file);
			break;
		case 4:
			System.out.println("輸入檔名以及檔案位置");
			System.out.print("檔名");
			name = c.next();
			System.out.print("檔案位置");
			file = c.next();
			dao.pictureStore(name, file);
			break;
		case 5:
			System.out.println("輸入查詢ID以及檔案建立位置");
			System.out.print("ID:");
			id = c.nextInt();
			System.out.print("檔案位置:");
			file = c.next();
			dao.pictureDownload(id, file);
			break;
		case 6:
			dao.insertFiletoDb("C:\\Users\\Student\\Downloads\\test.csv");
			
			break;
		case 7:
			System.out.println("序號,托育類型,名稱,行政區,地址,聯絡人,電話,簡介,優惠內容,優惠起日,優惠迄日,備註");
			System.out.print("輸入修改ID :");
			id = c.nextInt();
			System.out.print("輸入修改欄位 :");
			name=c.next();
			System.out.print("輸入修改值 :");
			values =c.next(); 
			dao.update(id, name, values);
			break;
		case 8 :
			System.out.println("序號,托育類型,名稱,行政區,地址,聯絡人,電話,簡介,優惠內容,優惠起日,優惠迄日,備註");
			
			System.out.print("選擇欄位 :");
			name = c.next();
			System.out.print("刪除值 :");
			values = c.next();
			dao.delete(name, values);
			break;
		case 9:
			CareData data = new CareData ();
			System.out.println("托育類型");
			data.setChildcareType(c.next());
			
			System.out.println("名稱 :");
			data.setChildcareName(c.next());
			
			System.out.println("行政區 :");
			data.setDistrict(c.next());
			
			System.out.println("地址 :");
			data.setAddress(c.next());
			
			System.out.println("聯絡人 :");
			data.setContactPerson(c.next());
			
			System.out.println("電話 :");
			data.setPhone(c.next());
			
			System.out.println("簡介 :");
			data.setIntroduction(c.next());
			
			System.out.println("優惠內容 :");
			data.setDiscountContent(c.next());
			
			System.out.println("優惠起日 :");
			data.setDiscountStart(c.next());
			
			System.out.println("優惠迄日 :");
			data.setDiscountEnd(c.next());
			
			System.out.println("備註 :");
			data.setRemark(c.next());
			dao.add(data);
			break;
			
		case 0 :
			dao.closeConn();
			System.out.println("結束連線");
			break;
			
		default:
			System.out.println("輸入錯誤");
				break;
	
		}
	
		
		}
		
//		CareData data = new CareData("幼兒園","臺北市私立蔚景幼兒園","大安區","臺北市大安區復興南路一段313巷6號","臺北市私立蔚景幼兒園","02-27088833轉80" , 
//				"奧爾仕幼兒教育以開放教育為出發點，實踐O(open-minded)開放思維、U(unique)獨特差異、R(respect)尊重互信、S(sincere)誠心以對的教育理念，藉由真實教育(be real)、身心健康(well being)、自然永續(sustainabillty)及社會文化(culture)四大方向，引領孩子一起前進自信、穩定、主動學習、善良關懷的歷程。歡迎您與我們一起成為孩子成長歷程的好夥伴！！",
//				"1、註冊費新、舊生減免1000元。2、新、舊生延長受托時間費用：17:30~18:30幼幼班2000元/月；小、中、大班1000元/月。3、每位新生註冊後贈送書包、圍兜各1。4、提供之優惠適用所有分校（各園延托費用均不相同，請洽各該園所）①大安園 臺北市私立華菂幼兒園 臺北市大安區安和路二段217巷30號 2735-0267②南港園 臺北市私立道生南港幼兒園 臺北市南港區重陽路187巷1號 2788-0661③北投園 臺北市私立道生幼兒園 臺北市北投區中央北路三段188號 2892-2691④士林園 臺北市私立奧爾仕幼兒園 臺北市士林區至善路二段1-1號 2880-7531⑤永和園 新北市私立奧爾仕幼兒園 新北市永和區保平路203巷2號 2231-4384⑥新北市私立奧爾仕托嬰中心 新北市永和區保平路203巷2號3樓 8923-0098","1120801","1140731","1、送托時間：星期一至五AM08：00-PM06：302、托育方式：全日托3、接受付款方式：現金、信用卡。"
//				);
		
//		dao.add(data);
//		dao.update(1, "托育名稱", "nothing");
//		dao.findById(1);
		
		
		
	

	}
	


}
