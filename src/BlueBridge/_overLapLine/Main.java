package BlueBridge._overLapLine;

import java.util.Arrays;
import java.util.Comparator;

class Line implements Comparable<Line>{
	double k,b;
	public Line(double k,double b) {
		this.k = k;
		this.b = b;
	}
	@Override
	public int compareTo(Line o) {
		// TODO Auto-generated method stub
		//如果k不同的话，使用k来进行排序。否则使用b来排序
		if(k!=o.k) {
			int k_res = (int)o.k - (int)k;
			if(k_res>0) return 1;
			if(k_res==0)return 0;
			if(k_res<0)return -1;
		}
		int b_res = (int)o.b - (int)b;
		if(b_res>0)return 1;
		if(b_res==0)return 0;
		if(b_res<0)return -1;
		return 0;
	}
	
}

public class Main {
	private static final int N = 200000;
	private static int n=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//给出x和y的取值范围，求范围之内的整数点能够构成多少条不同的直线
		//解题方法是直接模拟
		Line[] lines = new Line[N];
		for(int x1=0;x1<20;x1++) {
			for(int y1=0;y1<21;y1++) {
				for(int x2=0;x2<20;x2++) {
					for(int y2=0;y2<21;y2++) {
						if(x1!=x2) {
							double k = (double)(y2-y1)/(x2-x1);
							double b = y1 - k*x1;
							lines[n++] = new Line(k,b);
						}
					}
				}
			}
		}
		
		//排序直线数组，默认使用升序排序？，然后去掉
		Arrays.sort(lines);
		int res = 1;
		for(int i = 1;i<n;i++) {
			if(Math.abs(lines[i].k - lines[i-1].k)>1e-8 || Math.abs(lines[i].b-lines[i-1].b)>1e-8	) {
				res++;
			}
		}
		System.out.println(res+20);
		
	}

}

