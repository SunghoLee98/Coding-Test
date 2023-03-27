sn = int(input())
sstr = input().split()

tn = int(input())
tstr = input().split()

numbers = dict()
for i in sstr:
    numbers[i] = True

for i in tstr:
    if i in numbers:
        print(1)
    else:
        print(0)