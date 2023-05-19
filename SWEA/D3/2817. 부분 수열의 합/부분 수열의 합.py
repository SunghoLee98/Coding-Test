T = int(input())
nums = []
global n, cnt, k

def dfs(s, node):
    global n, cnt, k
    #print(s, node)
    if s > k:
        return
    if s == k:
        cnt += 1
        return
    
    for i in range(node+1, n):
        dfs(s + nums[i], i)
    
for test_case in range(1, T+1):
    n, k = map(int, input().split())
    
    nums = list(map(int, input().split()))
    
    cnt = 0
    dfs(0, -1)
    
    print(f"#{test_case} {cnt}")