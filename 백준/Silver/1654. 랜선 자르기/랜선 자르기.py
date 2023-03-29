str = input().split()
k = int(str[0])
n = int(str[1])
lines = []

for i in range(k):
    lines.append(int(input()))

st = 1
ed = max(lines) + 1

def calLine(le, lines):
    num = 0
    for i in lines:
        num += int(i/le)
    return num

while(True):
    num = 0
    le = int((st+ed) / 2)
    num = calLine(le, lines)

    if num >= n:
        if(calLine(le+1, lines) < n):
            break
        st = le
    else:
        ed = le


print(le)