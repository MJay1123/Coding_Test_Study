def solution(schedules, timelogs, startday):
    answer = 0
    
    def changeTime(time) :
        hour = time // 100;
        minute = time % 100;
        return hour * 60 + minute;
    
    def check(time, timelog, startday) :
        needTime = changeTime(time) + 10;
        for i in range(7) :
            commuteTime = changeTime(timelog[i]);
            if startday == 6 or startday == 7 :
                startday += 1;
                if startday > 7 :
                    startday -= 7;
                continue;
            if(commuteTime > needTime) :
                return False;
            startday += 1;
            if startday > 7 :
                startday -= 7;
        return True;
    
    for i in range(len(schedules)) :
        if(check(schedules[i], timelogs[i], startday)):
            answer += 1;
    return answer