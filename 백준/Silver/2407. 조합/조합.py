from fractions import Fraction as fr
str = input().split()

n = int(str[0])
m = int(str[1])

mom = fr(1)
son = fr(1)
for i in range(1, m+1):
    mom = fr(mom) * fr(i)
    son = fr(son) * fr(n)
    n -= 1

print(int(fr(son) / fr(mom)))
