## downloading images from csv
```python
import urllib.request
import pandas as pd 

df = pd.read_excel("target.xlsx")
urls = df.ix[:,'Photo']

for i,url in enumerate(urls):
    urllib.request.urlretrieve(url,'images/'+str(i)+'.png') # the place you want to store your photo
```