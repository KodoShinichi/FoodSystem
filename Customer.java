import java.util.Scanner;

/**
*客户类 调度6个动作
*@author 刘芫
*@since jdk1.8
*@version 8.0
*/

public class Customer {
	public static void main(String[] args) {
		Customer customer = new Customer(); // 用户对象
		SysMenus sysMenus = new SysMenus(); // 系统对象
		Scanner input = new Scanner(System.in);
		do{
			// 展示系统菜单
			sysMenus.showSysMenus();
			// 用户菜谱选择
			System.out.print("\n=>请您选择操作：");
			String usrOpt = input.next();
			switch (usrOpt) {
				case "1":
					//订餐
					customer.foodOrders();
					break;
				case "2":
					//查看订单
					customer.queryOrders();
					break;
				case "3":
					// 签收订单
					customer.signOrders();
					break;
				case "4":
					// 删除订单
					customer.deletOrders();
					break;
				case "5":
					// 点赞订单
					customer.giveGoodOrders();
					break;
				case "6":
					System.out.println("\n谢谢您使用本系统，Goodbye！\n");
					System.exit(0);
					break;
				default:
					System.out.println("\n您输入的有误！请重新输入...\n");
			}
		}while (true);
	}
	
	/**
	*方法开始
	*/
	Scanner scan = new Scanner(System.in);
	FoodMenusEntity foodMenus = new FoodMenusEntity(); // 菜谱对象
	OrdersEntity orders = new OrdersEntity(); // 订单对象
	/**
	*订餐方法
	*@Param foodOpt 实参
	*/
	public void foodOrders() {
		//1.显示菜谱
		foodMenus.foodMenusShow();
		//2.用户选择
		String ans = "y";
		do{
			System.out.print("\n=>请选择菜品：");
			int foodOpt = scan.nextInt();
			TableFather foodRow = foodMenus.foodMenusMatch(foodOpt); // 菜谱行匹配
			orders.ordersAdd(foodRow); // 订单生成方法
			System.out.print("\n=>是否继续订购菜品(y/n)？");
			ans = scan.next();
		}while("y".equals(ans));
	}
	/**
	*查看订单方法
	*/
	public void queryOrders() {
		orders.ordersShow(); // 调用订单打印方法
	}
	/**
	*签收订单方法
	*/
	public void signOrders() {
		// 1. 显示订单
		orders.ordersShow(); // 调用订单打印方法
		// 2.让用户选择订单
		System.out.print("\n=>请选择您想要签收的订单：");
		int id = scan.nextInt();
		// 3. 匹配订单
		int orderRow = orders.ordersMatch(id); // 匹配订单行
		// 3. 把对应订单的状态修改
		orders.ordersCheck(orderRow); // 传行参数给签收订单方法进行修改
	}
	/**
	*删除订单方法
	*/
	public void deletOrders() {
		// 1. 显示订单
		orders.ordersShow(); // 调用订单打印方法
		// 2.让用户选择订单
		System.out.print("\n=>请选择您想要删除的订单：");
		int id = scan.nextInt();
		// 3. 匹配订单
		int orderRow = orders.ordersMatch(id); // 匹配订单行
		// 3. 删除订单
		orders.ordersDelete(orderRow,id);
	}
	/**
	*点赞订单方法
	*/
	public void giveGoodOrders() {
		// 1. 显示订单
		orders.ordersShow(); // 调用订单打印方法
		// 2.让用户选择订单
		System.out.print("\n=>请选择您想要点赞的订单：");
		int id = scan.nextInt();
		// 3. 匹配订单
		int orderRow = orders.ordersMatch(id); // 匹配订单行
		// 4. 点赞
		orders.ordersGoods(orderRow); // 订单 和 菜谱 点赞+1
	}
}