\# Ansible



Ansible configuration for DevOps Lab.



\## Control node



devops-control



\## Managed nodes



\- devops-lab01



\## Structure



\- `inventories/` - managed hosts

\- `playbooks/` - playbooks

\- `roles/` - reusable roles

\- `group\_vars/` - variables for groups

\- `host\_vars/` - variables for individual hosts



\## Production inventory



Current inventory uses the SSH alias `devops-lab01`.



The real server address and SSH private key are stored outside Git

in the SSH configuration of the control node.

