### set cuda devices
```
export CUDA_VISIBLE_DEVICES=0
OR in ipython notebook
import os
os.environ["CUDA_VISIBLE_DEVICES"]="0"
```

### check who is using gpu
```
nvidia-smi 
first to get their PID
then
./checkGPUUsageByProcessID.sh 16957
get their i-number
```

### use the exact amount of gpu i need
```
tfconfig = tf.ConfigProto(allow_soft_placement=True)
tfconfig.gpu_options.allow_growth=True
and on the session
sess = tf.Session(graph=detection_graph, config=tfconfig)
```

### kill cuda session
sudo kill -9 PID

### get cuda version
nvcc --version
