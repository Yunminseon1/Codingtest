import java.util.*;
import java.io.*;
public class Main{
    static String numMap [][] = new String[5][5]; 
    static int dx[] = {0, 0, 1, -1}; // 상하좌우 이동
    static int dy[] = {1, -1, 0, 0}; // 상하좌우 이동
    static HashSet<String> answer = new HashSet<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int i =0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                numMap[i][j] = st.nextToken();
            }
        }
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                dfs(i, j, numMap[i][j], 0);
            }
        }
        System.out.println(answer.size());
    }
    
    public static void dfs(int x, int y, String route, int count){
        if(count == 5){
            answer.add(route);
            return;
        }
        
        for(int i =0; i<4; i++){
            int nowX = x + dx[i];
            int nowY = y + dy[i];
            if(0 <= nowX && nowX < 5 && 0 <= nowY && nowY < 5){
                dfs(nowX,nowY,route + numMap[nowX][nowY],count+1);
            }
        }
    }
}