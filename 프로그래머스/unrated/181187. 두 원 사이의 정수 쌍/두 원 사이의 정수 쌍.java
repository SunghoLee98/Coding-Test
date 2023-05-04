class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long num, top, btm;
        long rr2 = (long)Math.pow(r2, 2);
        long rr1 = (long)Math.pow(r1, 2);
        double tempb;
        for(int x = 1; x <= r2; x++){
            top = (long)Math.sqrt(rr2 - (long)Math.pow(x, 2));
            
            btm = 0;
            if(x < r1){
                tempb = Math.sqrt(rr1 - (long)Math.pow(x, 2));
                if((tempb % 1) != 0)
                    btm = (long)(tempb + 1);
                else
                    btm = (long)tempb;
            }
            
            answer += top - btm + 1;
        }
        return 4 * answer;
    }
    
}