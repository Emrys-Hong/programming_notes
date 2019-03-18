import itertools
class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        memo = {}
        for i in range(len(nums)-1):
            for j in range(i+1, len(nums)):
                value = -nums[i]-nums[j]
                value_set = [i, j]
                if value in memo:
                    memo[value].append(value_set)
                else:
                    memo[value] = [value_set]
        
        ret = []
        for k in range(len(nums)):
            if nums[k] in memo:
                for alist in memo[nums[k]]:
                    if k!=alist[0] and k!=alist[1]:
                        anolist = [nums[alist[0]], nums[alist[1]], nums[k]]
                        anolist = sorted(anolist)
                        ret.append(anolist)
        ret.sort()
        return [k for k, _ in itertools.groupby(ret)]

testList = [-1, 0, 1, 2, -1, -4]
print(Solution().threeSum(testList))