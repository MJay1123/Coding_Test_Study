def solution(players, callings):
    playerDictionary = {players[i] : i for i in range(len(players))}
    
    def passPlayer(name, playerDictionary, players):
        rightIndex = playerDictionary.get(name)
        leftIndex = rightIndex - 1
        leftName = players[leftIndex]
        players[leftIndex] = name
        players[rightIndex] = leftName
        playerDictionary[leftName] = rightIndex
        playerDictionary[name] = leftIndex
        return (playerDictionary, players)
    
    for name in callings:
        playerDictionary, players = passPlayer(name, playerDictionary, players)

    return players