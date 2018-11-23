# Use this class to create linked lists.
class Node:
    def __init__(self, value, child=None):
        self.value = value
        self.child = child

    # The string representation of this node.
    # Will be used for testing.
    def __str__(self):
        return str(self.value)


# Implement your function below.
def nth_from_last(head, n):
    left = head
    right = head
    for i in range(n):
        if right == None:
            return None
        right = right.child
    while right:
        right = right.child
        left = left.child
    return left


# NOTE: Feel free to use the following function for testing.
# It converts the given linked list into an easy-to-read string format.
# Example: 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (None)
def linked_list_to_string(head):
    current = head
    str_list = []
    while current:
        str_list.append(str(current.value))
        current = current.child
    str_list.append('(None)')
    return ' -> '.join(str_list)


# NOTE: The following input values will be used for testing your solution.
current = Node(1)
for i in range(2, 8):
    current = Node(i, current)
head = current
# head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (None)

current2 = Node(4)
for i in range(3, 0, -1):
    current2 = Node(i, current2)
head2 = current2
# head2 = 1 -> 2 -> 3 -> 4 -> (None)


# nth_from_last(head, 1) should return 1.
# nth_from_last(head, 5) should return 5.
# nth_from_last(head2, 2) should return 3.
# nth_from_last(head2, 4) should return 1.
# nth_from_last(head2, 5) should return None.
# nth_from_last(None, 1) should return None.
