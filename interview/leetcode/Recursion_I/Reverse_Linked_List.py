# Input: 1->2->3->4->5->NULL
# Output: 5->4->3->2->1->NULL

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # iteration
    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        current = head
        
        while(current!=None):
            temp = current.next
            current.next = prev
            prev = current
            current = temp
        return prev

    # recursion
    def reverseList(self, head):
        if (head == None or head.next == None): return head;
        p = self.reverseList(head.next);
        head.next.next = head;
        head.next = None;
        return p;