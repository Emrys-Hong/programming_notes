class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) - sum(cost) < 0:
            return -1
        
        curr_gas = 0
        index = -1
        for i in range(len(gas)):
            if (curr_gas + (gas[i] - cost[i]) < 0):
                index = i
                curr_gas = 0
            else:
                curr_gas += (gas[i] - cost[i])
        return (index+1)%len(gas)