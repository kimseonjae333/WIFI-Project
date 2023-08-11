package kp_ac_kopo_ctc_kopo39_service;


import kp_ac_kopo_ctc_kopo39_domain.WifiItem;

public class WifiItemService { // �ּ�/�ִ� �Ÿ� �����͸� ã�� ����ϴ� ���� ����(�Ÿ� ��� ����� �������� �ּ�/�ִ� �Ÿ� �����͸� ã�� �ڵ�� ����� ����ϴ� �ڵ�
								// ����)

	public double getDistance(WifiItem wifiItem1, WifiItem wifiItem2) { // �� ���� WifiItem ��ü�� ���ڷ� �޾� �Ÿ� ��� ����
		// ���� ���� ������������ �Լ� �ȿ��� ������ �س����� �ʿ����

		double dist_k39 = Math.sqrt(Math.pow(wifiItem2.getLongitude()-wifiItem1.getLongitude(),2)
                +Math.pow(wifiItem2.getLatitude()-wifiItem1.getLatitude(),2));
																				
		return dist_k39;
	}
}
