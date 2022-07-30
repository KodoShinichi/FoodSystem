import java.util.Scanner;

/**
*系统菜单类：负责打印输出系统菜单，不能修改或删除
*@author 刘芫
*@since jdk1.8
*@version 1.0
*/

public class SysMenus {
	String[] sysMenusArr = {"我要订餐","查看餐袋","签收订单","删除订单","我要点赞","退出系统"};// 定义系统菜单数组
	/**
	*显示系统菜单
	*/
	public void showSysMenus() {
		System.out.println("\n=====================欢迎使用吃货联盟系统=====================");
		for (int i=0; i<sysMenusArr.length; i++) {
			System.out.println("\n\t\t\t"+ (i+1) + ". " + sysMenusArr[i]);
		}
		System.out.println("\n==============================================================");
	}
}