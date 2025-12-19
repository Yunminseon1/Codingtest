import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] NArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        NArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            NArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(NArr); // 배열 정렬

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            if(sortSearch(Integer.parseInt(st.nextToken())) != 0){
                sb.append("1").append("\n");
            }else{
                sb.append("0").append("\n");
            }
        }
        br.close();

        System.out.println(sb);
    }

    static int sortSearch(int num){
        int start = 0;
        int end = NArr.length-1;
        int middle;

        while(start <= end){

            middle = (start+end)/2;

            if(NArr[middle] > num){
                end = middle-1;

            }else if(NArr[middle] < num){
                start = middle+1;

            }else if(NArr[middle] == num){
                return NArr[middle];
            }
        }
        return 0;
    }
}