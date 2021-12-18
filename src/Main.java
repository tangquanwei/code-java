import java.io.*;
import java.util.*;

/**
 * 
 * @param args
 * @throws IOException
 * 
 *                     while (in.nextToken() != StreamTokenizer.TT_EOF) { //
 *                     in.nextToken(); int a = (int) in.nval; in.nextToken();
 *                     String s = in.sval; //只能读字母 out.println(a);
 *                     out.println(s); out.flush();
 */
public class Main {

	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		int m, n;
		in.nextToken();
		in.nextToken();
		m = (int) in.nval;
		n = (int) in.nval;
		Integer[] a = new Integer[m];
		for (Integer i = 0; i < m; i++) {
			a[i] = i + 1;
		}
		Arrays.sort(a, (x, y) -> x - y);
		Arrays.sort(a, Comparator.reverseOrder());
		Arrays.sort(a, Collections.reverseOrder());
		out.println(Arrays.toString(a));
		// while(n--!=0) {
		// in.nextToken();
		// int p=(int) in.nval;
		// in.nextToken();
		// int i=(int)in.nval;
		// if(p==0)
		// // Arrays.sort(a, 0, i,new Comparator<Integer>() {
		// // @Override
		// // public int compare(Integer o1, Integer o2) {
		// // return o1-o2;
		// // }
		// // } );
		// Arrays.sort(a, 0, i,(a,b)->b-a);

		// }

	}

}
