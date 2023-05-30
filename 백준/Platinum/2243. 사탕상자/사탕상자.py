import sys

input = sys.stdin.readline

def init(node, start, end, target, val):

    #node가 없는 구간
    if target < start or end < target:
        return tree[node]

    #target node를 찾음
    if start == target == end:
        tree[node] += val
        arr[node] = target
        return tree[node]

    mid = (start + end) // 2
    #현 구간의 합은, 왼쪽구간 합 + 오른쪽 구간 합
    tree[node] = init(node * 2, start, mid, target, val) + init(node * 2 + 1, mid + 1, end, target, val)

    return tree[node]

#트리에서 원하는 맛의 순위가 있는 index를 찾아, arr배열에서 해당 맛 번호를 출력
def get(node, start, end, grade):
    #원하는 등수의 사탕 발견
    if start == end:
        tree[node] -= 1
        print(arr[node])
        return tree[node]

    left = tree[node*2]
    mid = (start + end) // 2
    #왼쪽에 있을수록 grade가 작다(맛있다)
    if left >= grade:
        get(node*2, start, mid, grade)
    else:
        #오른쪽으로 가는 경우, 오른쪽에서의 순위를 다시 구해야 함
        #구하는 법: 현 순위 - 왼쪽 서브 트리의 개수
        get(node*2 + 1, mid+1, end, grade-tree[node*2])

    tree[node] = tree[node*2] + tree[node*2 + 1]

    return tree[node]

n = int(input())
#세그먼트 트리
tree = [0] * (1000000 * 4)

#index -> 트리에서의 인덱스, value -> 무슨 맛인지
arr = [0] * (1000000 * 4)

for i in range(n):
    str = list(map(int, input().split()))
    if str[0] == 1:
        get(1, 1, 1000000, str[1])
    elif str[0] == 2:
        init(1, 1, 1000000, str[1], str[2])