def solution(video_len, pos, op_start, op_end, commands):
    def timeToNumber(time):
        minute = int(time[0:2])
        second = int(time[3:5])
        return minute * 60 + second;
    def numberToTime(number):
        minute = number // 60
        second = number % 60
        minuteString = str(minute).zfill(2)
        secondString = str(second).zfill(2)
        result = minuteString + ":" + secondString
        return result
            
    def moveTime(command, posNumber, videoLengthNumber):
        if command == "prev":
            posNumber -= 10
            if posNumber < 0:
                posNumber = 0
        if command == "next":
            posNumber += 10
            if posNumber > videoLengthNumber:
                posNumber = videoLengthNumber
        return posNumber
            
    videoLengthNumber = timeToNumber(video_len)
    posNumber = timeToNumber(pos)
    opStartNumber = timeToNumber(op_start)
    opEndNumber = timeToNumber(op_end)
    if posNumber >= opStartNumber and posNumber <= opEndNumber:
        posNumber = opEndNumber
    for i in range(len(commands)):
        command = commands[i]
        posNumber = moveTime(command, posNumber, videoLengthNumber)
        if posNumber >= opStartNumber and posNumber <= opEndNumber:
            posNumber = opEndNumber
    answer = numberToTime(posNumber)
    return answer