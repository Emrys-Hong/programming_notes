class Solution:
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        len_string = len(s)
        ret = ""
        ## the first node

        for i in range(0, len_string, 2*(numRows-1)):
            ret += s[i]

        for j in range(1, numRows-1):
            for i in range(0, len_string, 2*(numRows-1)):
                k1 = j + i
                if k1<len_string:
                    ret+=s[k1]
                k2 = i + 2*(numRows-1) - j

                if k2<len_string:
                    ret+=s[k2]
        ## the middle node
        for i in range(numRows-1, len_string, 2*(numRows-1)):
            ret += s[i]
            
        return ret

solution = Solution()
print(solution.convert("PAYPALISHIRING", 3)) # "PAHNAPLSIIGYIR"