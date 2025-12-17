import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String text = br.readLine();
		int n = text.length();
		
		int idx = 0;
		int[] pi = new int[n];
		for(int i=1; i<n; i++) {
			while(idx > 0 && text.charAt(i) != text.charAt(idx)) {
				idx = pi[idx-1];
			}
			if(text.charAt(i) == text.charAt(idx)) {
				pi[i] = ++idx;
			}
		}
		
		String pattern = "";
		int len = pi[n-1];
		out: while(len > 0) {
			for(int i=1; i<n-1; i++) {
				if(pi[i] == len) {
					pattern = text.substring(i-len+1, i+1);
					break out;
				}
			}
			len = pi[len-1];
		}
		
		if(pattern.isEmpty()) {
			System.out.println("-1");
			return;
		}
	
		System.out.println(pattern);
	}
}