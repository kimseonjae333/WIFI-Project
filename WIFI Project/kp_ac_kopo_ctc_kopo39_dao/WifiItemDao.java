package kp_ac_kopo_ctc_kopo39_dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kp_ac_kopo_ctc_kopo39_domain.WifiItem;

public class WifiItemDao { // 파일을 읽고 계산하는 로직 구현(파일 경로 및 파일 읽기 관련 코드 필요)
	// C,SelectOne,U,D는 원래 써야하지만 이번 실습에서는 생략하고 SelectAll만 써보기
	// C
//	public WifiItem Create(WifiItem wifiItem) {
//	    return null;
//	}
	// R
//	public WifiItem selectOne(int id) {
//		return null;
//	}

	public List<WifiItem> selectAll() {

		List<WifiItem> wifiitems = new ArrayList<>();
		File f_k39 = new File("C:\\Users\\사용자\\Desktop\\김선재\\JAVA 심화\\PPT8\\성남시무료와이파이표준데이터.txt");
		try (BufferedReader k39_br = new BufferedReader(new FileReader(f_k39))) {

			String readtxt_k39;
			if ((readtxt_k39 = k39_br.readLine()) == null) {
				System.out.printf("빈 파일입니다\n");
			}

//			String[] field_name_k39 = readtxt_k39.split("\t");
			int LineCnt = 0;
			while ((readtxt_k39 = k39_br.readLine()) != null) {
				String[] field = readtxt_k39.split("\t");

				WifiItem item = new WifiItem();
				item.setId(LineCnt);
				item.setInstallationLocationName(field[1]);
				item.setInstallationLocationDetails(field[2]);
				item.setInstallationCityName(field[3]);
				item.setInstallationDistrictName(field[4]);
				item.setInstallationFacilityType(field[5]);
				item.setServiceProviderName(field[6]);
				item.setWifiSsid(field[7]);
				item.setDateOfInstallation(field[8]);
				item.setRoadNameAddress(field[9]);
				item.setLotNumberAddress(field[10]);
				item.setManagementAgencyName(field[11]);
				item.setManagementAgencyPhoneNumber(field[12]);
				item.setLatitude(Double.parseDouble(field[13]));
				item.setLongitude(Double.parseDouble(field[14]));
				item.setCreated(field[15]);

				wifiitems.add(item);

				LineCnt++;
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		return wifiitems;

	}

}
//	//U
//	public WifiItem update(WifiItem wifiItem) {
//		return null;
//	}
//	//D
//	public WifiItem delete(int id) {
//		return null;
//
//	}
