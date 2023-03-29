num = int(input())
ans = int(num/2)
st = 0
ed = num

if(num == 0) or (num==1) or (num==2):
    print(num)
else:
    while(True):
        if(ans**2 >= num):
            if((ans-1)**2 < num):
                break
            ed = ans
            ans = int((st + ed) / 2)
        else:
            st = ans
            ans = int((st + ed) / 2)
        
    print(ans)
        
    