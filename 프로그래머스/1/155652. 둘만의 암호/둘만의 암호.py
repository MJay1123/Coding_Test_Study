def solution(s, skip, index):
    answer = ''
    isSkip = [False] * 26
    for i in range(len(skip)):
        isSkip[ord(skip[i]) - ord('a')] = True
    for i in range(len(s)):
        alphabetIndex = ord(s[i]) - ord('a')
        move = 0
        while move < index:
            if isSkip[alphabetIndex]:
                alphabetIndex = (alphabetIndex + 1) % 26
            else:
                alphabetIndex = (alphabetIndex + 1) % 26
                move += 1
        while isSkip[alphabetIndex]:
            alphabetIndex = (alphabetIndex + 1) % 26
        answer += chr(alphabetIndex + ord('a'))
    return answer