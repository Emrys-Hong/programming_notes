panda documentation
https://pandas.pydata.org/pandas-docs/stable/10min.html

# input/output data from excel
```
# input data
data = pd.read_csv('student.csv')

# output data
data.to_excel('path/to/excel')
```
# convert dataframe to dictionary and convert back
```
# convert df to dictionary
dict = df.to_dict()

# convert dict to dataframe
df = pd.DataFrame(dict,index=[list of index])
```

# concat df
```
# concat vertically
df = pd.concat([df1, df2], axis = 0) # default zero to let them concat along
```

# get value
```
df.get_value(index, column)
```
