# Examples:
# Input: N = 1, K = 1
# Output: 0

# Input: N = 2, K = 1
# Output: 0

# Input: N = 2, K = 2
# Output: 1

# Input: N = 4, K = 5
# Output: 1

# Explanation:
# row 1: 0
# row 2: 01
# row 3: 0110
# row 4: 01101001

class Solution:
    def kthGrammar(self, N, K):
        if N == 1: return 0
        if K <= (2**(N-2)):
            return self.kthGrammar(N-1, K)
        return self.kthGrammar(N-1, K - 2**(N-2)) ^ 1
    
    def kthGrammar(self, N, K):
        return bin(K - 1).count('1') % 2