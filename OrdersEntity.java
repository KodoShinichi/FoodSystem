import java.util.Scanner;

/**
*�������� ���̳б�����
*@author ��ܾ
*@since jdk1.8
*@version 8.0
*/

public class OrdersEntity extends TableFather{
	// ��Ա����˽�л�
	private int buyNum; // ��������
	private String userName; // ����
	private long telephone; // �ֻ���
	private String address; // ��ַ
	private int sumPrice; // �ܼ�
	private String state; // ״̬
	
	// �޲ι�����
	public OrdersEntity() {
		
    }
	// �вι�����
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
	*��������
	*/
	public void ordersAdd(TableFather foodRow) {
		int pos = 0;
		for (int j=0; j<ordersArr.length && ordersArr[j] != null; j++) {
			pos++; // ÿ�β�����+1
		}
		if (foodRow != null) {
			int id = ordersCurrIdMatch(); // �������
			String foodName = foodRow.getFoodName(); // ����
			System.out.print("\n=>�����빺��������");
			int buyNum = input.nextInt(); // ��������
			System.out.print("=>�������ջ��ˣ�");
			String userName = input.next(); // ����
			System.out.print("=>������绰���룺");
			long telephone = input.nextLong(); // �ֻ�����
			System.out.print("=>�������ջ���ַ��");
			String address = input.next(); //��ַ
			int price = foodRow.getPrice(); // ����
			int sumPrice = price * buyNum; // �ܼ�
		
			// ��ʼ���붩��
			ordersArr[pos] = new OrdersEntity(id,foodName,buyNum,userName,telephone,address,price,sumPrice,"��ǩ��",0);
		}else {
			System.out.print("\n�����������\n");
		}
	}
	/**
	*��ӡ����
	*/
	public void ordersShow() {
		System.out.println("\n==================================���Ķ���===========================================\n");
		System.out.println("\n���\t��Ʒ����\t����\t�ջ���\t�ֻ���\t��ַ\t����\t�ܼ�\t״̬\t������\n");
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
	*ǩ�ն���
	*/
	public void ordersCheck(int orderRow) {
		if (orderRow != -1) { // �ж��Ƿ��������ȷ
			ordersArr[orderRow].setState("��ǩ��");
			System.out.println("\n" + ordersArr[orderRow].getId() + "�Ŷ��������ǩ�գ�����\n");
		}else {
			System.out.println("������󣡣�");
		}
	}
	/**
	*ɾ������
	*/
	public void ordersDelete(int orderRow,int id) {
		if (orderRow != -1 ) {
			if ("������".equals(ordersArr[orderRow])) { // �ж�Ҫɾ�Ķ����Ƿ���ǩ��
				System.out.println("\n\n����δǩ�գ��޷�ɾ����\n");
			}else {
				for (int i=orderRow; i<ordersArr.length-1; i++) { // ���������һ��
					ordersArr[i] = ordersArr[i+1]; // �����ÿһ����ǰ�ƶ�һ��
				}
				ordersArr[ordersArr.length-1] = null; // ���һ��Ҳ��Ϊnull
				System.out.println("\n" + id + "�Ŷ�����ɾ��������\n");
			}
		}else {
			System.out.println("\n�����������\n");
		}	
	}
	/**
	*���޶���
	*/
	public void ordersGoods(int orderRow) {
		if (orderRow != -1) { // �ж��Ƿ��ҵ�����
			int goodNums = ordersArr[orderRow].getGoodNums();
			ordersArr[orderRow].setGoodNums(goodNums + 1); // ����������+1
			String matchFoodName = ordersArr[orderRow].getFoodName();
			for(int i=0; i<foodMenusArr.length; i++){
				if(matchFoodName.equals(foodMenusArr[i].getFoodName())){
					foodMenusArr[i].setGoodNums(foodMenusArr[i].getGoodNums()+1); // ������ĵ�����+1
				}
			}
		}else {
			System.out.println("\n�����������\n");
		}
	}
	/**
	*ƥ�䶩��
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
	*�ҵ���󶩵����
	*/
	public int ordersCurrIdMatch() {
		int orderCurrId = 0;
		for (int i=0; i<ordersArr.length && ordersArr[i] != null; i++) {
			orderCurrId = ordersArr[i].getId();
		}
		return orderCurrId + 1;
	}
	
	// getter �� setter 
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
