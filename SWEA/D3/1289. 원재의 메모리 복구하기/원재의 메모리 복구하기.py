T = int(input())

for test_case in range(1, T+1):
    codes = list(map(int, list(input())))
    value = 0
    pre = 1
    for bit in codes:
        if pre == bit:
            value += 1
            if pre:
                pre = 0
            else:
                pre = 1
    print(f"#{test_case} {value}")