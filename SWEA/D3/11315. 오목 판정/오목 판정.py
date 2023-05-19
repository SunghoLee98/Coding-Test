T = int(input())
global n

def omok():
    global n
    for i in range(n):
        for j in range(n):
            if boards[i][j] == '.':
                #print("hi")
                continue
            #오른쪽 가로
            check = True
            if j + 4 < n:
                for k in range(1, 5):
                    if boards[i][j+k] == '.':
                        check = False
                        break
                
                if check:
                    #print(i, j, -1)
                    return True
            
            #오른쪽 아래 대각
            check = True
            if j + 4 < n and i + 4 < n:
                for k in range(1,5):
                    if boards[i+k][j+k] == '.':
                        check = False
                        break
                
                if check:
                    #print(i, j, -2)
                    return True
            
            #왼쪽 아래 대각선
            check = True
            if j - 4 > -1 and i + 4 < n:
                for k in range(1,5):
                    if boards[i+k][j-k] == '.':
                        check = False
                        break
                
                if check:
                    #print(i, j, -3)
                    return True
                    
            #아래
            check = True
            if i + 4 < n:
                for k in range(1,5):
                    if boards[i+k][j] == '.':
                        check = False
                        break
                if check:
                    #print(i, j, -4)
                    return True
    
    return False
for test_case in range(1, T+1):
    n = int(input())
    ans = 0
    boards = []
    for i in range(n):
        boards.append(list(input()))
    ans = omok()
    
    if ans:
        print(f"#{test_case} YES")
    else:
        print(f"#{test_case} NO")
    
    
    