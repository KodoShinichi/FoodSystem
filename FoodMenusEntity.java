
/**
*�������� ���̳б�����
*@author ��ܾ
*@since jdk1.8
*@version 5.0
*/

public class FoodMenusEntity extends TableFather{
	/**
	*�����û�ѡ��ƥ������з���
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
	*��ʾ���׷���
	*/
	public void foodMenusShow() {
		foodMenusSort(0,foodMenusArr.length-1); // �������򷽷�
		System.out.println("\n=====================�˵�=====================\n");
		System.out.println("���\t����\t\t����\t������");
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
	*���׸��ݵ��������򷽷�
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
			foodMenusArr[i].setId(i+1); // �������Ĳ������
		}	
	}
	
}