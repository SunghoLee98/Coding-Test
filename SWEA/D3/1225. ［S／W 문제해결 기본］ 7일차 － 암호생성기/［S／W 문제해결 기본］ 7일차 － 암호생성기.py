from collections import deque
T = 10

for test_case in range(1, T+1):
    n = int(input())
    
    code = deque(map(int, input().split()))
    i = 1
    while(code[-1] > 0):
        code.append(code.popleft() - i)
        if i < 5:
            i += 1
        else:
            i = 1
    code[-1] = 0
    print(f"#{test_case}", end = " ")
    for i in code:
        print(i, end = " ")
    print()
