this is copied from hackjutsu
# Vim Cheatsheet

>Disclaimer: This cheatsheet is summarized from personal experience and other online tutorials. It should not be considered as an official advice.
## handy comes first
ctrl + ( # go to the definition of the function
ctrl + t # go back

*        # to jump to next place it is used

## Global
```bash
:help keyword # open help for keyword
:o file       # open file
:saveas file  # save file as
:close        # close current pane
```

## Cursor movement
```bash

30 + cursor down OR 30<Enter>    #moves to next 30 lines
30<space>       # enter 30 times

H        # move to top of screen
M        # move to middle of screen
L        # move to bottom of screen

0        # jump to the start of the line

$        # jump to the end of the line

gg       # go to the first line of the document
G        # go to the last line of the document
5G       # go to line 5

fx       # jump to next occurrence of character x
tx       # jump to before next occurrence of character x

}        # jump to next paragraph (or function/block, when editing code)
{        # jump to previous paragraph (or function/block, when editing code)


Ctrl + b # move back
Ctrl + f # move forward

Ctrl + d # move forward 1/2 a screen
Ctrl + u # move back 1/2 a screen
```

## Insert mode - inserting/appending text
```bash
i        # insert before the cursor

a        # insert after this line

o        # append (open) a new line below the current line

r        # replace the word

Esc      # exit insert mode
```


## Cut and paste
```bash
yy       # yank (copy) a line
2yy      # yank (copy) 2 lines
yw       # yank (copy) the characters of the word from the cursor position to the start of the next word
y$       # yank (copy) to end of line
p        # put (paste) the clipboard after cursor
P        # put (paste) before cursor
dd       # delete (cut) a line
2dd      # delete (cut) 2 lines
dw       # delete (cut) the characters of the word from the cursor position to the start of the next word
D        # delete (cut) to the end of the line
d$       # delete (cut) to the end of the line
d^       # delete (cut) to the first non-blank character of the line
d0       # delete (cut) to the begining of the line
x        # delete (cut) character
```

## Editing
```bash
r        # replace a single character
J        # join line below to the current one
cc       # change (replace) entire line

s        # delete character and substitute text
S        # delete line and substitute text (same as cc)

.        # repeat last command

u        # undo

Ctrl + r # redo
```

## Marking text (visual mode)
```bash
v        # start visual mode, mark lines, then do a command (like y-yank)
V        # start linewise visual mode

o        # move to other end of marked area
O        # move to other corner of block

aw       # mark a word
ab       # a block with ()
aB       # a block with {}

ib       # inner block with ()
iB       # inner block with {}

Esc      # exit visual mode
Ctrl + v # start visual block mode
```

## Visual commands
```bash
>       # shift text right

<       # shift text left

y       # yank (copy) marked text

d       # delete marked text

~       # switch case
```


## Search and replace
```bash
/pattern       # search for pattern
?pattern       # search backward for pattern

\vpattern      # 'very magic' pattern: non-alphanumeric characters are interpreted as special regex symbols (no escaping needed)

n              # repeat search in same direction
N              # repeat search in opposite direction

:%s/old/new/g  # replace all old with new throughout file
:%s/old/new/gc # replace all old with new throughout file with confirmations
```

## Command
```bash
:w              # write (save) the file, but don't exit
:w!             # write out the current file using sudo
:wq             # write (save) and quit

:q              # quit (fails if there are unsaved changes)
:q!             # quit and throw away unsaved changes

:w[filename]    # save as another file name

:r[filename]    # read another file and add it after the cursor

:! command      # command like :! ls /home is list all the files in the home directory
:w n1,n2 w [filename] # save n1 line to n2 line as a file name
```

## set environment
```
:set nu         # show line number
:set nonu       # unshow the line number
```

#### Working with multiple files
```bash
:e file       # edit a file in a new buffer
:bnext or :bn # go to the next buffer
:bprev or :bp # go to the previous buffer
:bd           # delete a buffer (close a file)
:ls           # list all open buffers
:sp file      # open a file in a new buffer and split window
:vsp file     # open a file in a new buffer and vertically split window
Ctrl + ws     # split window
Ctrl + ww     # switch windows
Ctrl + wq     # quit a window
Ctrl + wv     # split window vertically
Ctrl + wh     # move cursor to the left window (vertical split)
Ctrl + wl     # move cursor to the right window (vertical split)
Ctrl + wj     # move cursor to the window below (horizontal split)
Ctrl + wk     # move cursor to the window above (horizontal split)
```

#### Tabs
```bash
:tabnew or :tabnew file # open a file in a new tab
Ctrl + wT               # move the current split window into its own tab
gt or :tabnext or :tabn # move to the next tab
gT or :tabprev or :tabp # move to the previous tab
<number>gt              # move to tab <number>
:tabmove <number>       # move current tab to the <number>th position (indexed from 0)
:tabclose or :tabc      # close the current tab and all its windows
:tabonly or :tabo       # close all tabs except for the current one
:tabdo command          # run the command on all tabs (e.g. :tabdo q - closes all opened tabs)
```

#### Search in multiple files
```bash
:vimgrep /pattern/ {file} # search for pattern in multiple files
:cn                       # jump to the next match
:cp                       # jump to the previous match
:copen                    # open a window containing the list of matches
```
