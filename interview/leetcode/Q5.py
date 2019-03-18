import math
class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        max_length = 0
        # for two char
        i = 0
        ret = ""
        while i <= len(s)-0.5:
            k = 0
            length = 0
            floor = math.floor(i-k)
            ceil = math.ceil(i+k)

            while floor>=0 and ceil<=len(s)-1:
                if s[ceil] == s[floor]:
                    if ceil == floor:length += 1
                    else: length+=2
                else:
                    break
                k += 1
                floor = math.floor(i-k)
                ceil = math.ceil(i+k)
            if length > max_length:
                ret = s[floor+1: ceil]
                max_length = length
            i += 0.5
        return ret