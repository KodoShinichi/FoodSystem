
/**
*������ 
*@author ��ܾ
*@since jdk1.8
*@version 5.0
*/

public class TableFather{
	// ��Ա����
	private int id;
	private String foodName;
	private int price;
	private int goodNums;
	// �޲ι�����
	public TableFather() {
		
	}
	// �вι�����
	public TableFather(int id,String foodName,int price,int goodNums) {
		this.id = id;
		this.foodName = foodName;
		this.price = price;
		this.goodNums = goodNums;
	}
	// ��̬��Ա��������
	static TableFather[] foodMenusArr = {
		new TableFather(1,"��������",30,0),
		new TableFather(2,"��ˮ�ײ�",120,0),
		new TableFather(3,"�������",400,0),
		new TableFather(4,"�����Ҽ�",30,0),
		new TableFather(5,"������˿",25,0)
	};
	// getter �� setter
	public int getId() {
		return id;
	}
    public void setId(int id) {
		this.id = id;
	}
    public String getFoodName() {
		return foodName;
	}
    public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
    public int getPrice() {
		return price;
	}
    public void setPrice(int price) {
		this.price = price;
	}
    public int getGoodNums() {
		return goodNums;
	}
    public void setGoodNums(int goodNums) {
		this.goodNums = goodNums;
	}
}