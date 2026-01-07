T = int(input())

for test_case in range(1, T + 1):
    arr = list(map(int, input().split()))
    sum = 0
    for i in range(len(arr)):
        if arr[i] % 2 == 1:
            sum += arr[i]
    print(f'#{test_case} {sum}')