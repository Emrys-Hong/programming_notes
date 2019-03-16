# Input: 3
# Output: [1,3,3,1]
class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        ret = [0]*(rowIndex+1)
        ret[0] = 1
        for i in range(1, rowIndex+1):
            ret[i] = 1
            for j in range(i-1, 0, -1):
                ret[j] += ret[j-1]
            
        return ret