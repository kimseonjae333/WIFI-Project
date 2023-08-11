package kp_ac_kopo_ctc_kopo39_service;


import kp_ac_kopo_ctc_kopo39_domain.WifiItem;

public class WifiItemService { // 최소/최대 거리 데이터를 찾고 출력하는 로직 구현(거리 계산 결과를 바탕으로 최소/최대 거리 데이터를 찾는 코드와 결과를 출력하는 코드
								// 포함)

	public double getDistance(WifiItem wifiItem1, WifiItem wifiItem2) { // 두 개의 WifiItem 객체를 인자로 받아 거리 계산 수행
		// 여러 곳에 쓸수잇을려면 함수 안에서 고정값 해놓으면 필요없음

		double dist_k39 = Math.sqrt(Math.pow(wifiItem2.getLongitude()-wifiItem1.getLongitude(),2)
                +Math.pow(wifiItem2.getLatitude()-wifiItem1.getLatitude(),2));
																				
		return dist_k39;
	}
}
