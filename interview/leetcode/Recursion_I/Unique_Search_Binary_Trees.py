# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        def generate_tree(start, end):
            if start > end:
                return [None,]
            
            all_trees = []
            for i in range(start, end+1):
                left = generate_tree(start,i-1)
                right = generate_tree(i+1, end)
            
                for l in left:
                    for r in right:
                        curr = TreeNode(i)
                        curr.left = l
                        curr.right = r
                        all_trees.append(curr)
                    
            return all_trees
        
        return generate_tree(1, n) if n else []

