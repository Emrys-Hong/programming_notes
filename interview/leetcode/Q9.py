import math
class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        else:
            pos = math.floor(math.log(x, 10)) + 1
            for i in range(pos):
                a = int(x/pow(10, i))%10
                b = int(x/pow(10, pos-i-1))%10
                if not (a == b):
                    return False
            return True

print(Solution().isPalindrome(121))