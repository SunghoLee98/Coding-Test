T = int(input())
boards = []
global ans
ans = 0
n = 0
def newBoards(x, y, b):
    #십자
    for i in range(n):
        boards[x][i] += b
    for i in range(n):
        boards[i][y] += b
    
    #대각선
    tx = x
    ty = y
    while tx < n and ty < n:
        boards[tx][ty] += b
        tx += 1
        ty += 1
    
    tx = x
    ty = y
    while tx > -1 and ty < n:
        boards[tx][ty] += b
        tx += -1
        ty += 1
        

    tx = x
    ty = y
    while tx < n and ty > -1:
        boards[tx][ty] += b
        tx += 1
        ty += -1
    
    tx = x
    ty = y
    while tx > -1 and ty > -1:
        boards[tx][ty] += b
        tx += -1
        ty += -1
    
    boards[x][y] -= 5 * b
    
def dfs(qs, x, y):
    global ans
    
    if qs == n:
        ans += 1
        return
    for i in range(x, n):
        for j in range(0, n):
            if boards[i][j] == 0:
                newBoards(i, j, 1)
                #boards 배열 최신화
                dfs(qs+1, i, j)
                newBoards(i, j, -1)
                
    
for test_case in range(1, T+1):
    
    n = int(input())
    #백트레킹
    if n == 1:
        print(f"#{test_case} 1")
        continue
    
    for i in range(n):
        boards.append([0 for _ in range(n)])
        
    dfs(0, 0, 0)
    print(f"#{test_case} {ans}")
    boards = []
    ans = 0