class Solution(object):
    def lengthLongestPath(self, input):
        """
        :type input: str
        :rtype: int
        """
        stack = [(-1, 0)] # 目录的深度，当前总的字符串长度
        max_len = 0
        for p in input.split("\n"):
            depth = p.count('\t')
            p = p.replace('\t', '')
            while stack and depth <= stack[-1][0]: # 一样深，或者当前目录更浅
                stack.pop()
            if '.' not in p: # 目录
                stack.append((depth, len(p) + stack[-1][1] + 1))
            else: # 文件
                max_len = max(max_len, len(p) + stack[-1][1])
        return max_len

# solution from https://blog.csdn.net/fuxuemingzhu/article/details/82841402 