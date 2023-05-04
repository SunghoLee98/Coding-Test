class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int olen = 0;
        int xlen = 0;
        //실수한 경우: o개수 == x 개수 -> o가 승리한 경우
        //            o개수 > x개수 -> x가 승리한 경우
        //              x개수가 더 많은 경우
        
        for(int i = 0; i < 3; i++){
            for(int j=0; j < 3; j++){
                if(board[i].charAt(j) == 'O')
                    olen++;
                else if(board[i].charAt(j) == 'X')
                    xlen++;
            }
        }
        
        int cnt;
        int[] col = new int[3];
        boolean left = true;
        boolean right = true;
        if ((xlen > olen) || (olen-xlen > 1))
            return 0;
        else if(olen > xlen){
            if(xlen >= 3){
                for(int i = 0; i < 3; i++){
                    cnt = 0;
                    for(int j = 0; j< 3; j++){
                        if(board[i].charAt(j) == 'X'){
                            cnt++;
                            col[j]++;
                        }
                        if((i == j) && (board[i].charAt(j) != 'X'))
                            left = false;
                        if(((i+j) == 2) && (board[i].charAt(j) != 'X'))
                            right = false;
                        
                    }
                    if(cnt == 3)
                        return 0;   
                }
                for(int e: col){
                    if (e == 3)
                        return 0;
                }
                if(right || left)
                    return 0;
            }
            return 1;
        }
        else{
            if(olen >= 3){
                for(int i = 0; i < 3; i++){
                    cnt = 0;
                    for(int j = 0; j< 3; j++){
                        if(board[i].charAt(j) == 'O'){
                            cnt++;
                            col[j]++;
                        }
                        if((i == j) && (board[i].charAt(j) != 'O'))
                            left = false;
                        if(((i+j) == 2) && (board[i].charAt(j) != 'O'))
                            right = false;
                        
                    }
                    if(cnt == 3)
                        return 0;   
                }
                for(int e: col){
                    if (e == 3)
                        return 0;
                }
                if(right || left)
                    return 0;
            }
            return 1;
        }
    }
}