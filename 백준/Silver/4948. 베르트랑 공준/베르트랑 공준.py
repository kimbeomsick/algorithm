def getPrimary_Eratos(N):
    nums = [True] * (N)  #n개의 True가 있는 list만들기 n-1까지 있음
    for i in range(2, int(N**0.5)+1):
        if nums[i] == True:
            for  j in range(i+i, N, i): # i의 배수가 되는걸 다 false로 바굼
                nums[j] = False
    return [i for i in range(2,N) if nums[i] == True]
    # 이코드를 통해 0 1 은 제외된다. 2는 무조건 포함되고

print_list = []
while True:
    num = int(input())

    if num == 0:
        break
    prime_list = getPrimary_Eratos(2*num+1)
    answer_list = [n for n in prime_list if n > num]
    print_list.append(len(answer_list))

for i in print_list:
    print(i)