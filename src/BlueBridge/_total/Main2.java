package BlueBridge._total;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//背包问题，应该是01背包。
		//求一共可以称出多少种不同的重量。
		//假设背包的容量为天平的一半，即所有物品总重量的一半
		int objs[] = new int[] {1,4,6};
		int len = objs.length;
		int[] dp = new int[len+1];
		dp[0]=0;
		for(int i=0;i<len+1;i++) {
			for(int j=objs[i];j>=0;j--) {
				if(j-objs[i]>=0)
				dp[j] = Math.max(dp[j], dp[j-objs[i]]+1);
			}
		}
		List<Integer> resultIntegers = new ArrayList<>();
		resultIntegers.remove(resultIntegers.size()-1);
		
	}

}
