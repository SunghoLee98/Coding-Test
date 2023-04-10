from sys import stdin

maxN, M = map(int, stdin.readline().split())
dp = [[0] * (1+maxN) for k in range(1+maxN)]
#누적 합을 기록하는 2차원 배열

arr = []
for i in range(maxN):
    a = list(map(int, stdin.readline().split()))
    arr.append(a)
    
for i in range(1, 1+maxN):
    for j in range(1, 1+maxN):
        dp[i][j] += dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i-1][j-1]


for i in range(M):
    x1, y1, x2, y2 = map(int, stdin.readline().split())
    print(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1])
