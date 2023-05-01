n, v = map(int, input().split())
grp = []
vis = []
for i in range(n+1):
    grp.append([-1])
    vis.append(0)
    
for i in range(v):
    s, d = map(int, input().split())
    grp[s].append(d)
    grp[d].append(s)

dfs = []
ans = 0
for i in range(1, n+1):
    if vis[i]:
        continue
    dfs.append(i)
    while(len(dfs)):
        node = dfs.pop()
        vis[node] = 1
        for j in grp[node]:
            if vis[j] or (j == -1):
                continue
            dfs.append(j)
    ans += 1

print(ans)
    