import java.util.Scanner;

/**
*�ͻ��� ����6������
*@author ��ܾ
*@since jdk1.8
*@version 8.0
*/

public class Customer {
	public static void main(String[] args) {
		Customer customer = new Customer(); // �û�����
		SysMenus sysMenus = new SysMenus(); // ϵͳ����
		Scanner input = new Scanner(System.in);
		do{
			// չʾϵͳ�˵�
			sysMenus.showSysMenus();
			// �û�����ѡ��
			System.out.print("\n=>����ѡ�������");
			String usrOpt = input.next();
			switch (usrOpt) {
				case "1":
					//����
					customer.foodOrders();
					break;
				case "2":
					//�鿴����
					customer.queryOrders();
					break;
				case "3":
					// ǩ�ն���
					customer.signOrders();
					break;
				case "4":
					// ɾ������
					customer.deletOrders();
					break;
				case "5":
					// ���޶���
					customer.giveGoodOrders();
					break;
				case "6":
					System.out.println("\nлл��ʹ�ñ�ϵͳ��Goodbye��\n");
					System.exit(0);
					break;
				default:
					System.out.println("\n���������������������...\n");
			}
		}while (true);
	}
	
	/**
	*������ʼ
	*/
	Scanner scan = new Scanner(System.in);
	FoodMenusEntity foodMenus = new FoodMenusEntity(); // ���׶���
	OrdersEntity orders = new OrdersEntity(); // ��������
	/**
	*���ͷ���
	*@Param foodOpt ʵ��
	*/
	public void foodOrders() {
		//1.��ʾ����
		foodMenus.foodMenusShow();
		//2.�û�ѡ��
		String ans = "y";
		do{
			System.out.print("\n=>��ѡ���Ʒ��");
			int foodOpt = scan.nextInt();
			TableFather foodRow = foodMenus.foodMenusMatch(foodOpt); // ������ƥ��
			orders.ordersAdd(foodRow); // �������ɷ���
			System.out.print("\n=>�Ƿ����������Ʒ(y/n)��");
			ans = scan.next();
		}while("y".equals(ans));
	}
	/**
	*�鿴��������
	*/
	public void queryOrders() {
		orders.ordersShow(); // ���ö�����ӡ����
	}
	/**
	*ǩ�ն�������
	*/
	public void signOrders() {
		// 1. ��ʾ����
		orders.ordersShow(); // ���ö�����ӡ����
		// 2.���û�ѡ�񶩵�
		System.out.print("\n=>��ѡ������Ҫǩ�յĶ�����");
		int id = scan.nextInt();
		// 3. ƥ�䶩��
		int orderRow = orders.ordersMatch(id); // ƥ�䶩����
		// 3. �Ѷ�Ӧ������״̬�޸�
		orders.ordersCheck(orderRow); // ���в�����ǩ�ն������������޸�
	}
	/**
	*ɾ����������
	*/
	public void deletOrders() {
		// 1. ��ʾ����
		orders.ordersShow(); // ���ö�����ӡ����
		// 2.���û�ѡ�񶩵�
		System.out.print("\n=>��ѡ������Ҫɾ���Ķ�����");
		int id = scan.nextInt();
		// 3. ƥ�䶩��
		int orderRow = orders.ordersMatch(id); // ƥ�䶩����
		// 3. ɾ������
		orders.ordersDelete(orderRow,id);
	}
	/**
	*���޶�������
	*/
	public void giveGoodOrders() {
		// 1. ��ʾ����
		orders.ordersShow(); // ���ö�����ӡ����
		// 2.���û�ѡ�񶩵�
		System.out.print("\n=>��ѡ������Ҫ���޵Ķ�����");
		int id = scan.nextInt();
		// 3. ƥ�䶩��
		int orderRow = orders.ordersMatch(id); // ƥ�䶩����
		// 4. ����
		orders.ordersGoods(orderRow); // ���� �� ���� ����+1
	}
}