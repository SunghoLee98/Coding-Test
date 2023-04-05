str = input().split()

n = int(str[0])
maxW = int(str[1])

dp = [[0] * (maxW+1)]
for i in range(n):
    tmp = input().split()
    wei = int(tmp[0])
    val = int(tmp[1])
    
    newdp = [0] * (maxW+1)
    for j in range(1, maxW+1):
        if (j-wei) < 0:
            newdp[j] = dp[i][j]
        else:
            newdp[j] = max(dp[i][j - wei] + val, dp[i][j])

    dp.append(newdp)

print(dp[n][maxW])