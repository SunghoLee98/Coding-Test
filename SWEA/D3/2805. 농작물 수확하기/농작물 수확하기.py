T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    mid = int(n/2)
    scan = 0
    value = 0
    for i in range(n):
        farm = list(map(int, list(input())))
        
        for j in range(mid-scan, mid+scan+1):
            value += farm[j]
        
        if i < mid:
            scan += 1
        else:
            scan -= 1
    print(f"#{test_case} {value}")