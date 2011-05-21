import itertools
from multiprocessing.pool import Pool


def _count_failures(result, words, letters, failure):
    if not words: return
    if len(words) == 1:
        result[words[0]] = failure
    else:
        candidates = frozenset(''.join(words))
        for i, ch in enumerate(letters):
            if ch in candidates:
                break
        p = lambda word: tuple(i for i, a in enumerate(word) if a == ch)
        g = itertools.groupby(sorted(words, key=p), key=p)
        for ps, grp in g:
            _count_failures(result, tuple(grp), letters[i+1:],
                    failure + (ps==()))

def count_failures(words, letters):
    result = {}
    g = itertools.groupby(sorted(words, key=len), key=len)
    for _, grp in g:
        _count_failures(result, list(grp), letters, 0)
    return result

def solve1(dic, order):
    r = count_failures(dic, order)
    #return max(dic, key=lambda word: r[word])
    return max(dic, key=lambda word: (r[word],-dic.index(word)))

def solve(dic, orders):
    return [solve1(dic, order) for order in orders]

def msolve(_): return solve(*_)


if __name__ == '__main__':
    def iter_problems():
        import sys
        it = iter(sys.stdin)
        T = int(next(it))
        for i in range(1, T+1):
            N,M = map(int, next(it).split())
            dic = [next(it).strip() for _ in range(N)]
            orders = [next(it).strip() for _ in range(M)]
            yield dic,orders
    p = Pool()
    for i, result in enumerate(p.map(msolve, iter_problems()), 1):
    #print 'Case #{}: {}'.format(i, ' '.join(solve(dic, orders)))
        print 'Case #{}: {}'.format(i, ' '.join(result))
