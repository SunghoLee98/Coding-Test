T = 10

for test_case in range(1, T+1):
    n = int(input())
    
    ans = []
    cnt = 0
    check = [0 for _ in range(100)]
    for i in range(n):
        col = list(map(int, input().split()))
        for j in range(n):
            if col[j] == 0:
                continue
            if check[j] == 0 and col[j] == 2:
                continue
            if check[j] == 0 and col[j] == 1:
                check[j] = 1
            if check[j] == col[j]:
                continue
            if check[j] == 1 and col[j] == 2:
                cnt += 1
                check[j] = 2
            if check[j] == 2 and col[j] == 1:
                check[j] = 1
            
    print(f"#{test_case} {cnt}")
                
        
