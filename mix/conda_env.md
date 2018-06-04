to check envs information:
conda info --envs

activate new environment:
conda create -n  <package_name>  pip (OR anaconda) python=3.6

to enter a environment:
source activate tensorflow

to deactivate certain envrionment:
source deactivate

to delete an environment:
conda-env remove -n tensorflow

to uninstall a package:
conda uninstall package

to update a package:
conda update package OR
conda update --all

see more at this website
https://conda.io/docs/user-guide/tasks/manage-environments.html
