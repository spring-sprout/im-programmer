from fractions import Fraction

def solve(N,PD,PG):
    if PG == 100 and PD < 100: return False
    if PG == 0 and PD > 0: return False
    if Fraction(PD, 100).denominator > N: return False
    return True

if __name__ == '__main__':
    import sys
    it = iter(sys.stdin)
    next(it)
    for i, line in enumerate(it, 1):
        N,PD,PG = map(int, line.split())
        print 'Case #{}: {}'.format(i, 'Possible' if solve(N,PD,PG) else 'Broken')
