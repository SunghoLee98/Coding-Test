def solution(n, s, a, b, fares):
    
    grp = []
    for i in range(n+1):
        grp.append([1000010 for _ in range(n+1)])
        
    for f in fares:
        grp[f[0]][f[1]] = f[2]
        grp[f[1]][f[0]] = f[2]
        
    for i in range(1, n+1):
        grp[i][i] = 0
        
    for k in range(1, n+1):
        for st in range(1, n+1):
            for t in range(1, n+1):
                grp[st][t] = min(grp[st][t], grp[st][k] + grp[k][t])
                
    ans = 30000500
    for k in range(1, n+1):
        ans = min(ans, grp[s][k] + grp[k][a] + grp[k][b])
        
    return ans