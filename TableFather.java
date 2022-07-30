
/**
*表单父类 
*@author 刘芫
*@since jdk1.8
*@version 5.0
*/

public class TableFather{
	// 成员变量
	private int id;
	private String foodName;
	private int price;
	private int goodNums;
	// 无参构造器
	public TableFather() {
		
	}
	// 有参构造器
	public TableFather(int id,String foodName,int price,int goodNums) {
		this.id = id;
		this.foodName = foodName;
		this.price = price;
		this.goodNums = goodNums;
	}
	// 静态成员对象数组
	static TableFather[] foodMenusArr = {
		new TableFather(1,"宫保鸡丁",30,0),
		new TableFather(2,"开水白菜",120,0),
		new TableFather(3,"酸算菜鱼",400,0),
		new TableFather(4,"辣子找鸡",30,0),
		new TableFather(5,"鱼香肉丝",25,0)
	};
	// getter 和 setter
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