import java.util.Scanner;

/**
*ϵͳ�˵��ࣺ�����ӡ���ϵͳ�˵��������޸Ļ�ɾ��
*@author ��ܾ
*@since jdk1.8
*@version 1.0
*/

public class SysMenus {
	String[] sysMenusArr = {"��Ҫ����","�鿴�ʹ�","ǩ�ն���","ɾ������","��Ҫ����","�˳�ϵͳ"};// ����ϵͳ�˵�����
	/**
	*��ʾϵͳ�˵�
	*/
	public void showSysMenus() {
		System.out.println("\n=====================��ӭʹ�óԻ�����ϵͳ=====================");
		for (int i=0; i<sysMenusArr.length; i++) {
			System.out.println("\n\t\t\t"+ (i+1) + ". " + sysMenusArr[i]);
		}
		System.out.println("\n==============================================================");
	}
}