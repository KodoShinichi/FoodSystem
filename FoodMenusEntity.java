
/**
*菜谱子类 ：继承表单父类
*@author 刘芫
*@since jdk1.8
*@version 5.0
*/

public class FoodMenusEntity extends TableFather{
	/**
	*根据用户选择匹配菜谱行方法
	*/
	public TableFather foodMenusMatch(int foodOpt) {
 		for (int i=0; i<foodMenusArr.length; i++) {
			if (foodOpt == foodMenusArr[i].getId()) {
				return foodMenusArr[i];
			}
		}
		return null;
	}
	/**
	*显示菜谱方法
	*/
	public void foodMenusShow() {
		foodMenusSort(0,foodMenusArr.length-1); // 调用排序方法
		System.out.println("\n=====================菜单=====================\n");
		System.out.println("序号\t菜名\t\t单价\t点赞数");
		for (int i=0; i<foodMenusArr.length; i++) {
			System.out.print(" " + foodMenusArr[i].getId() + "\t"
			+foodMenusArr[i].getFoodName() + "\t"
			+foodMenusArr[i].getPrice() + "\t"
			+foodMenusArr[i].getGoodNums() + "\t");
			System.out.println();
		}
		System.out.println("\n==============================================\n");
	}
	/**
	*菜谱根据点赞数排序方法
	*/
	public void foodMenusSort(int low,int high) { 
		int lo = low;
		int hi = high;
		if(lo>=hi) {
			return;
		}
		boolean flag = false;
		while(lo<hi){
			if(foodMenusArr[lo].getGoodNums()<foodMenusArr[hi].getGoodNums()){
				TableFather temp = foodMenusArr[lo];
				foodMenusArr[lo] = foodMenusArr[hi];
				foodMenusArr[hi] = temp;
				
				flag=!flag;
			}
			if(flag){
				lo++;
			}else{
				hi--;
			}
		}
		lo--;hi++;
		foodMenusSort(low,lo);
		foodMenusSort(hi,high);
		
		for (int i=0; i<foodMenusArr.length; i++) {
			foodMenusArr[i].setId(i+1); // 排序后更改菜谱序号
		}	
	}
	
}