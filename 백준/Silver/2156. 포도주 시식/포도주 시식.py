n = int(input())
if n == 1:
    print(int(input()))

elif n == 2:
    a = int(input())
    b = int(input())
    print(a+b)
else:
    arr = []
    dp = []
    for i in range(n):
        arr.append(int(input()))

    #dp.append(0)
    dp.append(arr[0])
    dp.append(arr[1] + arr[0])
    dp.append(max(arr[0], arr[1]) + arr[2])
    dp[2] = max(dp[1], dp[2])

    for i in range(3,n):
        tmp = max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i]
        dp.append(max(dp[i-1], tmp))

    print(dp[n-1])


