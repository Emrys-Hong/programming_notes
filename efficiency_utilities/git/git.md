# Resources
Git and Github are two different things.

Git is a revision control system, a tool to manage your source code history.

Github is for Sharing code oneline, a service hosting Git repositories.

To learn git, you need to learn version control concepts as well as Git command lines.

## Installation
Install from [official website](https://git-scm.com/downloads)

## Tutorials(Recommend Reading)
Long tutorials: Watch English video tutorial from [Corey Schafer](https://www.youtube.com/watch?v=HVsySz-h9r4&t=1093s) for concepts

Long tutorials: Watch Chinese video tutorial from [morvan python git](https://morvanzhou.github.io/tutorials/others/git/) for concepts

Short tutorials: [a minimal tutorial](http://kbroman.org/github_tutorial/) to start on Git

## Cheetsheets
Read [Git cheetsheet 1](https://github.com/llSourcell/How-to-Use-GitHub) from Siraj Raval's [how to use Git](https://www.youtube.com/watch?v=Loav1kbA640) for all basic commands for Git. 

Print [Git cheetsheet2](https://services.github.com/on-demand/downloads/github-git-cheat-sheet.pdf) for official cheetsheet

[Table of contents of Git](https://git-scm.com/book/en/v2/) from official website

[Table of contents of Git](http://www.vogella.com/tutorials/Git/article.html) to learn about Git


# Useful commands
## Git remote
```
## add new origin to push
git remote add origin <url>

## remove the origin
git remote rm origin

## pull origin
git pull origin master

## push origin
git push -u origin master

## Check current remote
git remote -v
expected outputs:
origin  https://github.com/user/repo.git (fetch)
origin  https://github.com/user/repo.git (push)
```
for click [here](http://www.ruanyifeng.com/blog/2014/06/git_remote.html) for more info

## first time git setup
```
git config --global user.name <Username>

git config --global user.email <email>
```

## add  and commit file
```
## add all files
git add .
OR
## add specific file
git add <name>

## git commit
git commit -m "some comments here"
OR for shorter commands
git commit -am "some comments here"         # this one must have the files already added and modified
```
![git flow pipline](https://github.com/Emrys-Hong/programming_notes/blob/master/efficiency_utilities/git/pipline.png)

## git log
```
## see commited activities
git log
git log --oneline # shorter version

## git stages
git status
git status -s # 's' for short

# see the difference between unstaged status(modified files) and the last commited file
git diff

# see the difference between staged file (after git add) and last commited file
git diff --cached

# see the difference between last commited file and staged and unstaged
git diff HEAD
```

## git change log
```
## merge the new commit and this commit without changing git log
git commit --amend --no-edit    # but it will result in the git id change

## if the file is added to the staged status and want to go back to previous version
git reset <filename>            # this will make modify the staged status

####### git reset --hard
"""all of these will change log"""
git reset --hard HEAD           # if the file is added, and want the head to go to previous state
# go back to a certain commit
git reset --hard HEAD^          # go back to the previous commit
git reset --hard HEAD~1         # go back to the previous one commit, the number means which previous state
git reset --hard <commit_id>    # go back to the commit 
####### 


####### change to prevous log, go back to the future
git refflog
output:

'''c6762a1 HEAD@{0}: reset: moving to c6762a1
904e1ba HEAD@{1}: commit (amend): change 2
0107760 HEAD@{2}: commit: change 2
c6762a1 HEAD@{3}: commit: change 1
13be9a7 HEAD@{4}: commit (initial): create 1.py'''

# if want to go to "c6762a1 HEAD@{3}: commit: change 1"
git reset --hard c6762a1
OR
git reset --hard HEAD@{3}
#######


####### git checkout
""" this will not change the log line, but will only let single file go back to past"""
git checkout <commit_id> -- 1.py          # remember the space between -- and 1.py
#######
```
![reset-1](https://github.com/Emrys-Hong/programming_notes/blob/master/efficiency_utilities/git/reset-1.png)
![reset-2](https://github.com/Emrys-Hong/programming_notes/blob/master/efficiency_utilities/git/reset-2.png)
![reset-3](https://github.com/Emrys-Hong/programming_notes/blob/master/efficiency_utilities/git/reset-3.png)
![reset-4](https://github.com/Emrys-Hong/programming_notes/blob/master/efficiency_utilities/git/reset-4.png)

## git branch
```
## see the graph
git log --oneline --graph

## create a new branch
git branch <branch_name>
OR
git checkout -b <branch_name>         # create a new branch and move the name to the branch

## see which branch you are at
git branch

## go to a branch
git checkout <branch_name>

## delete a branch
git branch -d <branch_name>
```

## git merge
```
####### merge two branches
# go to main file first
git merge --no-ff -m "some merge info"  <branch_name-u-want-to-merge>   
# --no faster forward can make you see the merge info in log
#this will merge under recursion rule, like some file is bigger and some file is smaller and then the bigger file will replace the small file
#######

## conflict solving, sometimes there will be conflicts when merging the two
basically it will tell you where the conflict is and then you do inside the file, solve conflict and then commit the conflict you solved
```

# advanced topics
## git rebase
```
!! danger !!
""" this can change the log in the branch and add the only edit in the dev branch in the master history for the dev branch"""
git rebase dev          # if both of them have some edits

######## solving conflicts 
When you have resolved this problem, run "git rebase --continue".
If you prefer to skip this patch, run "git rebase --skip" instead.
To check out the original branch and stop rebasing, run "git rebase --abort".

solved the conflicts in 1.py
git add <conflict_file>
git rebase --continue
```
![rebase-1](https://github.com/Emrys-Hong/programming_notes/blob/master/efficiency_utilities/git/rebase-1.png)
![rebase-2](https://github.com/Emrys-Hong/programming_notes/blob/master/efficiency_utilities/git/rebase-2.png)
![rebase-3](https://github.com/Emrys-Hong/programming_notes/blob/master/efficiency_utilities/git/rebase-3.png)
![rebase-4](https://github.com/Emrys-Hong/programming_notes/blob/master/efficiency_utilities/git/rebase-4.png)
![rebase-5](https://github.com/Emrys-Hong/programming_notes/blob/master/efficiency_utilities/git/rebase-5.png)


## git stash
''' save the work and clean up the workspace'''
```
## clean up workspace
git stash               # your work space will be cleaned and nothing to commit

## make a new branch using the clean work space, it will have exactly one in the work space
## finish the job and merge to wherever you want to merge
## go back to the stash branch and:
git stash list          ## see what are stashes
git stash pop           ## pop the first stash
```

## remove all the files from .gitignore that has been cached
```git rm --cached 'git ls-files -i --exclude-from=.gitignore'```

## git submodule
http://www.vogella.com/tutorials/GitSubmodules/article.html
