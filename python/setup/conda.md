to check envs information:
conda info --envs

to activate new environment:
conda create -n  <package_name>  pip (OR anaconda) python=3.6

to enter a environment:
source activate tensorflow

to deactivate certain envrionment:
source deactivate

### conda env, [see more](https://conda.io/docs/commands/env/conda-env-update.html)
to update a package:
conda-env update -f environment.yml

to output the conda environment as environment.yml
conda env export | grep -v "^prefix: " > environment.yml
conda env create -f environment.yml

to create a new environment from environment.yml file:
conda env create -f environment.yml

to delete an environment:
conda-env remove -n tensorflow

to uninstall a package:
conda uninstall <package_name>

see more at this website
https://conda.io/docs/user-guide/tasks/manage-environments.html
