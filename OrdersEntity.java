import java.util.Scanner;

/**
*订单子类 ：继承表单父类
*@author 刘芫
*@since jdk1.8
*@version 8.0
*/

public class OrdersEntity extends TableFather{
	// 成员属性私有化
	private int buyNum; // 购买数量
	private String userName; // 姓名
	private long telephone; // 手机号
	private String address; // 地址
	private int sumPrice; // 总价
	private String state; // 状态
	
	// 无参构造器
	public OrdersEntity() {
		
    }
	// 有参构造器
    public OrdersEntity(int id, String foodName
	, int buyNum, String userName, long telephone
	, String address, int price, int sumPricel
	, String state, int goodNums) {
		super(id,foodName,price,goodNums);
        this.buyNum = buyNum;
        this.userName = userName;
        this.telephone = telephone;
        this.address = address;
        this.sumPrice = sumPrice;
        this.state = state;

    }
	Scanner input = new Scanner(System.in);
	OrdersEntity[] ordersArr = new OrdersEntity[20];
	/**
	*新增订单
	*/
	public void ordersAdd(TableFather foodRow) {
		int pos = 0;
		for (int j=0; j<ordersArr.length && ordersArr[j] != null; j++) {
			pos++; // 每次插入编号+1
		}
		if (foodRow != null) {
			int id = ordersCurrIdMatch(); // 订单编号
			String foodName = foodRow.getFoodName(); // 菜名
			System.out.print("\n=>请输入购买数量：");
			int buyNum = input.nextInt(); // 购买数量
			System.out.print("=>请输入收货人：");
			String userName = input.next(); // 姓名
			System.out.print("=>请输入电话号码：");
			long telephone = input.nextLong(); // 手机号码
			System.out.print("=>请输入收货地址：");
			String address = input.next(); //地址
			int price = foodRow.getPrice(); // 单价
			int sumPrice = price * buyNum; // 总价
		
			// 开始插入订单
			ordersArr[pos] = new OrdersEntity(id,foodName,buyNum,userName,telephone,address,price,sumPrice,"待签收",0);
		}else {
			System.out.print("\n您输入的有误！\n");
		}
	}
	/**
	*打印订单
	*/
	public void ordersShow() {
		System.out.println("\n==================================您的订单===========================================\n");
		System.out.println("\n编号\t菜品名称\t数量\t收货人\t手机号\t地址\t单价\t总价\t状态\t点赞数\n");
		for (int i=0; i<ordersArr.length; i++) {
			if (ordersArr[i] == null) {
				break;
			}
			System.out.print(
			 ordersArr[i].getId() + "\t"
			+ordersArr[i].getFoodName() + "\t"
			+ordersArr[i].getBuyNum() + "\t"
			+ordersArr[i].getUserName() + "\t"
			+ordersArr[i].getTelephone() + "\t"
			+ordersArr[i].getAddress() + "\t"
			+ordersArr[i].getPrice() + "\t"
			+ordersArr[i].getSumPrice() + "\t"
			+ordersArr[i].getState() + "\t"
			+ordersArr[i].getGoodNums() + "\t"
			);
			System.out.println();
		}
		System.out.println("\n=====================================================================================\n");
	}
	/**
	*签收订单
	*/
	public void ordersCheck(int orderRow) {
		if (orderRow != -1) { // 判断是否输入的正确
			ordersArr[orderRow].setState("已签收");
			System.out.println("\n" + ordersArr[orderRow].getId() + "号订单已完成签收！！！\n");
		}else {
			System.out.println("输入错误！！");
		}
	}
	/**
	*删除订单
	*/
	public void ordersDelete(int orderRow,int id) {
		if (orderRow != -1 ) {
			if ("待接收".equals(ordersArr[orderRow])) { // 判断要删的订单是否已签收
				System.out.println("\n\n订单未签收，无法删除！\n");
			}else {
				for (int i=orderRow; i<ordersArr.length-1; i++) { // 不包括最后一行
					ordersArr[i] = ordersArr[i+1]; // 后面的每一行往前移动一行
				}
				ordersArr[ordersArr.length-1] = null; // 最后一行也赋为null
				System.out.println("\n" + id + "号订单已删除！！！\n");
			}
		}else {
			System.out.println("\n您输入的有误！\n");
		}	
	}
	/**
	*点赞订单
	*/
	public void ordersGoods(int orderRow) {
		if (orderRow != -1) { // 判断是否找到订单
			int goodNums = ordersArr[orderRow].getGoodNums();
			ordersArr[orderRow].setGoodNums(goodNums + 1); // 订单点赞数+1
			String matchFoodName = ordersArr[orderRow].getFoodName();
			for(int i=0; i<foodMenusArr.length; i++){
				if(matchFoodName.equals(foodMenusArr[i].getFoodName())){
					foodMenusArr[i].setGoodNums(foodMenusArr[i].getGoodNums()+1); // 菜谱里的点赞数+1
				}
			}
		}else {
			System.out.println("\n您输入的有误！\n");
		}
	}
	/**
	*匹配订单
	*/
	public int ordersMatch(int id) {
		for (int i=0; i<ordersArr.length && ordersArr[i] != null; i++) {
			if (id == ordersArr[i].getId()) {
				return i;
			}
		}
		return -1;
	}
	/**
	*找到最大订单编号
	*/
	public int ordersCurrIdMatch() {
		int orderCurrId = 0;
		for (int i=0; i<ordersArr.length && ordersArr[i] != null; i++) {
			orderCurrId = ordersArr[i].getId();
		}
		return orderCurrId + 1;
	}
	
	// getter 和 setter 
    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
