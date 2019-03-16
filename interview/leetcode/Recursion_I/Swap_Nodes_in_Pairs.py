# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def swapPairs_recursion(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if (head == None or head.next == None):
            return head

        temp = head.next
        head.next = self.swapPairs(head.next.next)
        temp.next = head
        return temp
    
    def swapPairs_iteration(self, head):
        ret = ListNode(0)
        prev = ret
        if (head==None or head.next == None):
            return head
        
        while (head!=None and head.next!=None):
            prev.next = head.next
            head.next = head.next.next
            prev.next.next = head
            prev = head
            head = prev.next
        return ret.next
            