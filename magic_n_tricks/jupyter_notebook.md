some of the magic functions come from: [this website](https://www.dataquest.io/blog/jupyter-notebook-tips-tricks-shortcuts/) 

# put these at the top of every notebook, to get automatic reloading and inline plotting
```
%reload_ext autoreload
%autoreload 2
%matplotlib inline // this can plot without plt.show() and can plot inline

# important tricks
```
press H for more shortcuts
press tab for auto fill in
press shift + tab for arg help
press shift + tab twice for documentation help
press ?string search for documentation and have the same effect as shift + tab

```
# uncommon tricks
```
%env OMP_NUM_THREADS=4 set environment variables

%run ./two-histograms.ipynb run python code

%who list all variables of global scope

%%time show running time after executing each block

pass data between different notebooks
data = 'this is the string I want to pass to different notebook'
%store data
del data # This has deleted the variable
%store -r data
print(data)

%who -- see all the variables of global scope
one = "for the money"
two = "for the show"
three = "to get ready now go cat go" 
%who str
one	 three	 two

Using the %%writefile magic saves the contents of that cell to an external file. %pycat does the opposite, and shows you (in a popup) the syntax highlighted contents of an external file.
%%writefile pythoncode.py
import numpy
def append_if_not_exists(arr, x):
    if x not in arr:
        arr.append(x)
def some_useless_slow_function():
    arr = list()
    for i in range(10000):
        x = numpy.random.randint(0, 10000)
        append_if_not_exists(arr, x)
Writing pythoncode.py
%pycat pythoncode.py
python
import numpy
def append_if_not_exists(arr, x):
    if x not in arr:
        arr.append(x)
def some_useless_slow_function():
    arr = list()
    for i in range(10000):
        x = numpy.random.randint(0, 10000)
        append_if_not_exists(arr, x)
        
```
