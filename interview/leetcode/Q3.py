class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        lnums1, lnums2 = len(nums1), len(nums2)
        if lnums1 > lnums2: lnums1, lnums2, nums1, nums2 = lnums2, lnums1, nums2, nums1
        if lnums2 == 0: raise ValueError
        imin, imax, half_len = 0, lnums1-1, int((lnums1+lnums2-1)/2)
        while imin <= imax:
            i = int((imin + imax)/2)
            j = half_len - i
            if i < lnums1 and nums1[i] < nums2[j]: imin=i+1
            elif i > 0 and nums1[i-1] > nums2[j]: imax=i-1
            else:
                if i==0: 
                    max_of_left = nums2[j]
                elif j==0: 
                    max_of_left = nums1[i-1]
                else: 
                    max_of_left = max(nums1[i-1], nums2[j])
                if (lnums1+lnums2)%2 == 1:
                    return max_of_left


                if i==lnums1: 
                    min_of_right = nums2[j+1]
                elif j==lnums2: 
                    min_of_right = nums1[i]
                else: 
                    min_of_right = min(nums1[i], nums2[j+1])
                return (max_of_left+min_of_right) / 2

list1 = [1,2,3,4,]
list2 = [5,6,7,8]

class1 = Solution()
print(class1.findMedianSortedArrays(list1, list2))
