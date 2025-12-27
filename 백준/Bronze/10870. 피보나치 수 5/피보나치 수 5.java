import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());

        br.close();
        System.out.println(fibonacciNumbers(N));
    }


    static int fibonacciNumbers(int n){
        if(n == 0) return 0; //0일때 0
        if(n == 1) return 1; //1일때 1

        return fibonacciNumbers(n-1) + fibonacciNumbers(n-2);
    }
}