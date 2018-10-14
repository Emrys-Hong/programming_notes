#suppose you now have a number of choice of coins [1,2,5,10,20,50,100] if give you a number n, try to give all the combination of change that you can give


def change(n, coins_available, coins_so_far):
    if sum(coins_so_far) == n:
        yield coins_so_far
    elif sum(coins_so_far) > n:
        pass
    elif coins_available == []:
        pass
    else:
        for c in change(n, coins_available[:], coins_so_far+[coins_available[0]]):
            yield c
        for c in change(n, coins_available[1:], coins_so_far):
            yield c

n = 7
coins = [1,2,4,8,16,32]
print(len([i for i in change(n, coins, [])]))