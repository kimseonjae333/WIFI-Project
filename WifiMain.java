package kp_ac_kopo_ctc_kopo39;

import java.util.List;

import kp_ac_kopo_ctc_kopo39_dao.WifiItemDao;
import kp_ac_kopo_ctc_kopo39_domain.WifiItem;
import kp_ac_kopo_ctc_kopo39_service.WifiItemService;

public class WifiMain { //전부 호출(dao,service 클래스의 인스턴스를 서로 생성하여 연결, service 클래스의 메소드를 호출하여 결과 출력)

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("wifi project");
		
		WifiItem item = new WifiItem();
		WifiItemService wifiItemService = new WifiItemService();
		WifiItemDao wifiItemDao = new WifiItemDao();
		List<WifiItem> wifiItems = wifiItemDao.selectAll(); //메소드만 가져옴
		
		WifiItem me = new WifiItem();
		
		double lat_k39 = 37.3860521; //융합기술교육원 위도
		double lng_k39 = 127.1214038; //융합기술교육원 경도
		
		me.setLatitude(lat_k39);
		me.setLongitude(lng_k39);
		
		
		double minDist_k39 = Double.MAX_VALUE; // 최소 거리
        double maxDist_k39 = 0; // 최대 거리
        WifiItem minField_k39 = null;
        WifiItem maxField_k39 = null;
        
		for(WifiItem target : wifiItems) {
			target.getLotNumberAddress();
			target.getLatitude();
			target.getLongitude();
			double dist_k39 = wifiItemService.getDistance(me, target);
			 if (dist_k39 < minDist_k39) { //최소거리가 갱신될 때
				 minDist_k39 = dist_k39; //최소거리 갱신
				 minField_k39 = target; //이때 필드값을 최소 거리 데이터로 저장 
	         }
	         if (dist_k39 > maxDist_k39) { //최대거리가 갱신될 때
	        	 maxDist_k39 = dist_k39; //최대거리 갱신
	             maxField_k39 = target; //이때 필드값을 최대 거리 데이터로 저장
	         }
		}
		
		
		System.out.printf("************[최소 거리 데이터]***************\n");
		System.out.printf("소재지지번주소 : %s\n",minField_k39.getLotNumberAddress() ); //소재지지번주소
		System.out.printf("위도 : %s\n", minField_k39.getLatitude() ); //위도
		System.out.printf("경도 : %s\n", minField_k39.getLongitude() ); //경도
		System.out.printf("현재지점과 거리 : %f\n",minDist_k39 ); //현재지점과의 거리
		System.out.printf("*********************************************\n");
		
		System.out.printf("************[최대 거리 데이터]***************\n");
		System.out.printf("소재지지번주소 : %s\n", maxField_k39.getLotNumberAddress()); //소재지지번주소
		System.out.printf("위도 : %s\n",maxField_k39.getLatitude()); //위도
		System.out.printf("경도 : %s\n",maxField_k39.getLongitude()); //경도
		System.out.printf("현재지점과 거리 : %f\n", maxDist_k39); //현재지점과의 거리
		System.out.printf("*********************************************\n");
	}

}
