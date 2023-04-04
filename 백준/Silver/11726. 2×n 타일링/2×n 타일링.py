#아이디어
#최대한 길쭉하게(적은 개수의 타일로) 완성하고
#그걸 하나씩 쪼개보자
import itertools
from fractions import Fraction
def aCb(a, b):
    m = 1
    n = 1
    for i in range(b, 0, -1):
        m = Fraction(i) * Fraction(m)
        n = Fraction(a) * Fraction(n)
        a -= 1

    return Fraction(n/m)

def combinations_2(array, r):
    for i in range(len(array)):
        if r == 1: # 종료 조건
            yield [array[i]]
        else:
            for next in combinations_2(array[i+1:], r-1):
                yield [array[i]] + next

n = int(input())

row = int(n / 2)
col = n % 2
ans = 0
while(row != 0):
    #구하는 방식 nCcol
    ans += aCb(col+row, col)
    #ans += len(list(map(list,itertools.combinations(range(col+row),col))))
    #ans += combinations_2(col+row, col)
    row -= 1
    col += 2

print((ans+1) % 10007)