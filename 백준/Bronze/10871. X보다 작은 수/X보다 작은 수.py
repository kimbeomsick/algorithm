a,b = map(int,input().split())

nlist = list(map(int,input().split()))

for x in range(0,a):
    if nlist[x]<b:
        print(nlist[x],end=" ")