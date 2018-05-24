# core commands from https://www.youtube.com/watch?v=U2ZN104hIcc
```
pip install <package>
pip uninstall <package>
pip install --upgrade <package> OR pip install -U <package>
pip list # list out all the packages
pip list --outdated OR pip list -o # list out outdated packages
pip help # get help
pip search packages 

pip freeze > requirements.txt # outputs a requirements.txt file that have all the packages you using
pip install -r <anyname.txt> # install all the packages in the requirements.txt file

pip freeze --local | grep -v '^\-e' | cut -d = -f 1  | xargs -n1 pip install -U # update all the outdated packages
```
