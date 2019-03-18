class Solution:
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        dtoa = {2:"abc", 3:"def", 4:"ghi", 5:"jkl", 6:"mno", 7:"pqrs", 8:"tuv", 9:"wxyz"}
        memo = [0 for i in range(len(digits))]
        ret = []
        index = 0
        temp = 0
        while memo != [len(dtoa[int(c)])-1 for c in digits]:
            strg = "".join([dtoa[int(digits[i])][memo[i]] for i in range(len(digits))])
            ret.append(strg)
            while memo[index] >= len(dtoa[int(digits[index])])-1:
                if index < len(digits)-1:
                    index += 1
            memo[index] += 1
            if temp < index:
                for m in range(index):
                    memo[m] = 0
                index = 0
                temp = 0
            temp = index
            
        return ret

print(Solution().letterCombinations("567"))