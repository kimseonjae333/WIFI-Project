package kp_ac_kopo_ctc_kopo39;

import java.util.List;

import kp_ac_kopo_ctc_kopo39_dao.WifiItemDao;
import kp_ac_kopo_ctc_kopo39_domain.WifiItem;
import kp_ac_kopo_ctc_kopo39_service.WifiItemService;

public class WifiMain { //���� ȣ��(dao,service Ŭ������ �ν��Ͻ��� ���� �����Ͽ� ����, service Ŭ������ �޼ҵ带 ȣ���Ͽ� ��� ���)

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("wifi project");
		
		WifiItem item = new WifiItem();
		WifiItemService wifiItemService = new WifiItemService();
		WifiItemDao wifiItemDao = new WifiItemDao();
		List<WifiItem> wifiItems = wifiItemDao.selectAll(); //�޼ҵ常 ������
		
		WifiItem me = new WifiItem();
		
		double lat_k39 = 37.3860521; //���ձ�������� ����
		double lng_k39 = 127.1214038; //���ձ�������� �浵
		
		me.setLatitude(lat_k39);
		me.setLongitude(lng_k39);
		
		
		double minDist_k39 = Double.MAX_VALUE; // �ּ� �Ÿ�
        double maxDist_k39 = 0; // �ִ� �Ÿ�
        WifiItem minField_k39 = null;
        WifiItem maxField_k39 = null;
        
		for(WifiItem target : wifiItems) {
			target.getLotNumberAddress();
			target.getLatitude();
			target.getLongitude();
			double dist_k39 = wifiItemService.getDistance(me, target);
			 if (dist_k39 < minDist_k39) { //�ּҰŸ��� ���ŵ� ��
				 minDist_k39 = dist_k39; //�ּҰŸ� ����
				 minField_k39 = target; //�̶� �ʵ尪�� �ּ� �Ÿ� �����ͷ� ���� 
	         }
	         if (dist_k39 > maxDist_k39) { //�ִ�Ÿ��� ���ŵ� ��
	        	 maxDist_k39 = dist_k39; //�ִ�Ÿ� ����
	             maxField_k39 = target; //�̶� �ʵ尪�� �ִ� �Ÿ� �����ͷ� ����
	         }
		}
		
		
		System.out.printf("************[�ּ� �Ÿ� ������]***************\n");
		System.out.printf("�����������ּ� : %s\n",minField_k39.getLotNumberAddress() ); //�����������ּ�
		System.out.printf("���� : %s\n", minField_k39.getLatitude() ); //����
		System.out.printf("�浵 : %s\n", minField_k39.getLongitude() ); //�浵
		System.out.printf("���������� �Ÿ� : %f\n",minDist_k39 ); //������������ �Ÿ�
		System.out.printf("*********************************************\n");
		
		System.out.printf("************[�ִ� �Ÿ� ������]***************\n");
		System.out.printf("�����������ּ� : %s\n", maxField_k39.getLotNumberAddress()); //�����������ּ�
		System.out.printf("���� : %s\n",maxField_k39.getLatitude()); //����
		System.out.printf("�浵 : %s\n",maxField_k39.getLongitude()); //�浵
		System.out.printf("���������� �Ÿ� : %f\n", maxDist_k39); //������������ �Ÿ�
		System.out.printf("*********************************************\n");
	}

}
