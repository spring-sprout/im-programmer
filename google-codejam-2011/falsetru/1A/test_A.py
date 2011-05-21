from A import solve
import unittest

class TestSolve(unittest.TestCase):
    def test_solve(self):
        self.assertTrue(solve(1,100,50))
        self.assertFalse(solve(10,10,100))
        self.assertTrue(solve(1,100,50))

        self.assertTrue(solve(100,3,50))
        self.assertFalse(solve(1,98,50))

        self.assertTrue(solve(2,50,50))
        self.assertTrue(solve(2,50,49))
        self.assertTrue(solve(2,50,51))
        self.assertFalse(solve(2,50,0))

if __name__ == '__main__':
    unittest.main()
