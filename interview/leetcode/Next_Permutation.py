class Solution:
    def nextPermutation(self, nums: list) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) <= 1:
            return
        
        for i in range(len(nums)-2, -1, -1):
            if nums[i]<nums[i+1]:
                i+=1
                break
        i -= 1
        if i==-1:
            self.reverse(nums, 0)
        
        else:
            for j in range(i+1, len(nums)):
                if nums[j] <= nums[i]:
                    j -= 1 # previous larger one
                    break
            self.swap(nums, i, j)
            self.reverse(nums, i+1)

        return nums
    
            
    # inplace
    def reverse(self, nums, start):
        for i in range((len(nums)-start)//2):
            self.swap(nums, i+start, len(nums)-1-i)
    
    # swap node
    def swap(self, nums, i, j):
        temp = nums[j]
        nums[j] = nums[i]
        nums[i] = temp

print(Solution().nextPermutation([3,2,1]))