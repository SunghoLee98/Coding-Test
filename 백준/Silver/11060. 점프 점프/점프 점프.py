MAX = 1001

n = int(input())
str = input().split()
dp = [MAX] * (n+1)
dp[0] = 0
dp[1] = 0
for i in range(1, n):
    num = int(str[i-1])
    for j in range(1, num+1):
        if (i+j) > n:
            continue
        dp[i+j] = min(dp[i+j], dp[i] + 1)

if dp[n] == MAX:
    print(-1)
else:
    print(dp[n])