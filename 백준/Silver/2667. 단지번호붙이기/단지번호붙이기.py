from queue import Queue

n = int(input())
ans = []
dx = [-1,0,1,0]
dy = [0,-1,0,1]
grp = []
vis = []
bfs = Queue() #queue
node = list()
for i in range(n):
    grp.append(list(map(int, input())))
    vis.append([0 for _ in range(n)])    
ans.append(0)
for i in range(n):
    for j in range(n):
        if vis[i][j] or (not grp[i][j]):
            continue
        bfs.put([i,j])
        vis[i][j] = 1
        ans[0] += 1
        cnt = 1
        while(not bfs.empty()):
            node = bfs.get()
            for k in range(4):
                tx = node[1] + dx[k]
                ty = node[0] + dy[k]
                if (tx < 0) or (ty < 0) or (tx == n) or (ty == n):
                    continue
                if vis[ty][tx]:
                    continue
                if not grp[ty][tx]:
                    vis[ty][tx] = 1
                    continue
                vis[ty][tx] = 1
                bfs.put([ty,tx])
                cnt += 1
        ans.append(cnt)
print(ans[0])
del ans[0]
ans.sort()
for i in ans:
    print(i)