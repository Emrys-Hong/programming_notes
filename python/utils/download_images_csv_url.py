
import urllib.request
import pandas as pd 

df = pd.read_excel("parcel_data.xlsx")
urls = df.ix[:,'Parcel Label Photo']

for i,url in enumerate(urls):
    urllib.request.urlretrieve(url,'images/'+str(i)+'.png')
