# set some attribute name for python
class S(object):

    __slots__ = ['val']

    def __init__(self, v):
        self.val = v
