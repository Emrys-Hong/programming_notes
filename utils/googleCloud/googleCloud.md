Setting up Google Cloud:
- [setting up google cloud platform in 15 mins](https://towardsdatascience.com/running-jupyter-notebook-in-google-cloud-platform-in-15-min-61e16da34d52)
- [setting up Google Cloud GPU for Fast Ai](https://medium.com/google-cloud/set-up-google-cloud-gpu-for-fast-ai-45a77fa0cb48)

transfering large data to google cloud storage:
1. gsutil config -b
1. click on the url, and get the verfication code
1. paste it on terminal

transfer data from bucket to instance:
```gsutil cp -r gs://inclusive-image-kaggle/half_512.zip .```
