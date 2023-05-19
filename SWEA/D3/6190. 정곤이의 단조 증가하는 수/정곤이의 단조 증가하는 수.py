T = int(input())
global n
nums = []
done = []
def check(num):
    if num < 0:
        return True
    temp = list(map(int, list(str(num))))
    pre = 0
    
    for t in temp:
        if t < pre:
            return False
        pre = t
    return True
    
def dfs(node):
    global n
    for i in range(node+1, n):
        done.append(nums[node] * nums[i])
for test_case in range(1,T+1):
    n = int(input())
    nums = list(map(int, input().split()))
    done.append(-1)
    for i in range(n-1):
        dfs(i)
    
    done.sort(reverse = True)
    
    for i in done:
        if check(i):
            print(f"#{test_case} {i}")
            break
   
    done.clear()
        
    