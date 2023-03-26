num = int(input())

#[5,7] [6,7,8] [8,9]
#4      9       0
#[9,11,10,11,12]  [
if num==1:
    str = input().split()
    tmp = []
    for i in str:
        tmp.append(int(i))
    print(max(tmp), min(tmp))

else:
    str = input().split()
    tmp = []
    tmp2 = []
    for i in str:
        tmp.append(int(i))

    str = input().split()
    for i in str:
        tmp2.append(int(i))

    Lnode = [tmp[0] + tmp2[0], tmp[1] + tmp2[0]]
    Mnode = [tmp2[1] + tmp[0], tmp2[1] + tmp[1], tmp2[1] + tmp[2]]
    Rnode = [tmp2[2] + tmp[1], tmp2[2] + tmp[2]]

    nodes = [Lnode, Mnode, Rnode]

    for n in range(num-2):
     #   print(nodes)
        str = input().split()
        tmp.clear()

        for i in str:
            tmp.append(int(i))

        Lnode = []
        for j in nodes[0]+nodes[1]:
            Lnode.append(j + tmp[0])
        Mnode = []
        for k in nodes[0]+nodes[1]+nodes[2]:
            Mnode.append(k + tmp[1])
        Rnode = []
        for l in nodes[1]+nodes[2]:
            Rnode.append(l + tmp[2])

        Lnode = [min(Lnode), max(Lnode)]
        Mnode = [min(Mnode), max(Mnode)]
        Rnode = [min(Rnode), max(Rnode)]
        nodes = [Lnode, Mnode, Rnode]

    #print(nodes)
    minum = min(nodes[0] + nodes[1] + nodes[2])
    maxnum = max(nodes[0] + nodes[1] + nodes[2])
    print(maxnum, minum)