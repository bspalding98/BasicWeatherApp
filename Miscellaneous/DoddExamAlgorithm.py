lst =[1,2,3,4,5,3,4]
stairs = 0
stairSize = 0

for x in range(len(lst)-2):
    if lst[x+1] - lst[x] == lst[x+2] - lst[x+1]:
        stairSize += 1
    else:
        if stairSize >= 1:
            stairs +=1
        stairSize = 0

if stairSize >= 1:
    stairs +=1
print(stairs)