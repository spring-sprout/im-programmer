from B import *
import unittest
import subprocess

class TestSolve(unittest.TestCase):
    def test_solve(self):
        self.assertEqual(solve(
            ['banana','caravan','pajamas'],
            ['abcdefghijklmnopqrstuvwxyz', 'etaoisnhrdlcumwfgypbvkjxqz']
        ), ['pajamas', 'caravan'])
        self.assertEqual(solve(
            ['potato','tomato','garlic', 'pepper'],
            ['zyxwvutsrqponmlkjihgfedcba']
        ), ['garlic'])
        solve('abcd abdc acbd acdb adbc adcb bacd badc bcad bcda cabd cadb cbad cbda cdab cdba bcd cdb dbc bdc dcb cbd ade afz afy'.split(),
'abcdefghijklmnopqrstuvwxzy vclgderqhtspyimxfbujwoakzn rjgholtxnsmapfczvdwkqiyueb fioglbtcdkxspjvaqewmyrzhun rwabopeysuqhlivztdnkgxmjfc'.split())

    def test_solve1(self):
        self.assertEqual(solve1(
            ['banana','caravan','pajamas'],
            'abcdefghijklmnopqrstuvwxyz'
        ), 'pajamas')
    def test_guess(self):
        self.assertEqual(guess(['banana','caravan','pajamas'], 'pajamas', 'abcdefghijklmnopqrstuvwxyz'), 1)
    def test_sample(self):
        p = subprocess.Popen(['python', 'B.py'], stdin=subprocess.PIPE, stdout=subprocess.PIPE)
        with open('/home/falsetru/Downloads/B-small-attempt3.in') as f:
            p.stdin.write(f.read())
            p.stdin.close()
            got = p.stdout.read()
        with open('B.3.correct') as f:
            expected = f.read()
        self.assertEqual(got, expected)

if __name__ == '__main__':
    unittest.main()
