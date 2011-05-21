def match(word1, word2, ch):
    for a, b in zip(word1, word2):
        if ch == a and ch != b:
            return False
        if ch == b and ch != a:
            return False
    return True

def guess(dic, word, order):
    #print 'guess:',dic,word,order
    failure = 0
    d = [x for x in dic if len(word) == len(x)]

    order = iter(order)
    alphabets = set(''.join(d))
    try:
        while len(d) > 1:
            #print d
            a = next(order)
            if a not in alphabets:
                continue
            if a not in word:
                failure += 1
            d = [x for x in d if match(word,x,a)]
            alphabets = set(''.join(d))
    except StopIteration:
        pass
    return failure

def solve1(dic, order):
    #print 'solve1:',dic,order
    guesses = [guess(dic, word, order) for word in dic]
    idx = max(range(len(dic)), key=lambda i: (guesses[i], -i))
    return dic[idx]

def solve(dic, orders):
    return [solve1(dic, order) for order in orders]

if __name__ == '__main__':
    import sys
    it = iter(sys.stdin)
    T = int(next(it))
    for i in range(1, T+1):
        N,M = map(int, next(it).split())
        dic = [next(it).strip() for _ in range(N)]
        orders = [next(it).strip() for _ in range(M)]
        print 'Case #{}: {}'.format(i, ' '.join(solve(dic, orders)))
