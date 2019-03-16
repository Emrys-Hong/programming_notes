# Input: 5
# Output:
# [
#      [1],
#     [1,1],
#    [1,2,1],
#   [1,3,3,1],
#  [1,4,6,4,1]
# ]
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        if numRows == 0:
            return []
        elif numRows == 1:
            return [[1]]
        else:
            prev = self.generate(numRows-1)
            newList = [1]
            for i in range(numRows-2):
                newList.append( prev[-1][i] + prev[-1][i+1])
            newList.append(1)
        prev.append(newList)
        return prev