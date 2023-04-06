str = input().split()

num = int(str[0])
sum = int(str[1])

dp = [0] * (sum + 1)
dp[0] = 1
for i in range(num):
    coi = int(input())
    tmpdp = [0] * (sum+1)
    tmpdp[0] = 1
    for j in range(1, sum + 1):
        if (j - coi) < 0:
            tmpdp[j] = dp[j]
        else:
            tmpdp[j] = tmpdp[j-coi] + dp[j]
        
    dp = tmpdp    
print(dp[sum])