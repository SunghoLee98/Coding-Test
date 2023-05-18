from collections import deque 

T = 10
row = deque()

global n

def check(str):
    global n
    if n==1:
        return True
        
    mid = int(n/2)
    for i in range(mid):
        if str[i] != str[n-i-1]:
            return False
    return True

for test_case in range(1, T+1):
    n = int(input())
    col = []
    for i in range(8):
        col.append(deque())
    ans = 0
    
    for i in range(n):
        board = list(input())
        row.clear()
        for j in range(n):
            col[j].append(board[j])
            row.append(board[j])
        
        if check(row):
            ans += 1
        
        for j in range(n, 8):
            col[j].append(board[j])
            row.popleft()
            row.append(board[j])
            if check(row):
                ans+=1
    for i in col:
        if check(i):
            ans += 1
    
    for i in range(n, 8):
        board = list(input())
        
        row.clear()
        for j in range(n):
            col[j].popleft()
            col[j].append(board[j])
            if check(col[j]):
                ans += 1
            row.append(board[j])
        
        if check(row):
            ans += 1
        
        for j in range(n, 8):
            col[j].popleft()
            col[j].append(board[j])
            if check(col[j]):
                ans += 1
            row.popleft()
            row.append(board[j])
            if check(row):
                ans+=1
    
    print(f"#{test_case} {ans}")