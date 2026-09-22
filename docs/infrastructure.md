# Infrastructure

## Permanent hosts

### devops-control

Role:
- application host
- automation control node

Operating system:
- Debian 12

Resources:
- 1 vCPU
- 2 GB RAM
- 30 GB NVMe

Responsibilities:
- frontend
- backend
- Ansible control node
- Docker
- PostgreSQL

### devops-lab01

Role:
- managed laboratory host

Operating system:
- Debian 12

Resources:
- 1 vCPU
- 1 GB RAM
- 10 GB NVMe

Responsibilities:
- Ansible experiments
- Nginx experiments
- Docker experiments
- Linux configuration experiments

## SSH model

Windows
→ devops-control

Automation:

devops-control
→ devops-lab01

Automation user:
ansible