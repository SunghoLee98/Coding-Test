T = int(input())

for test_case in range(1, T+1):
    mh, mc = map(int, input().split())
    dp = []
    for i in range(mh+1):
        dp.append([0 for _ in range(mc+1)])
    
    for i in range(1, mh+1):
        h, c = map(int, input().split())
        for j in range(mc):
            if c > j:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j-c] + h, dp[i-1][j])
    print(f"#{test_case} {max(dp[mh])}")