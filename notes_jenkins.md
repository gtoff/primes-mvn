# Primes-mvn in Jenkins

- used helm to deploy Jenkins on Kube

```helm install jenkins-0.1.8.tgz```

Follow instructions on getting admin account and pwd

- logged in, updated jenkins to latest

- configured in global options maven to install from apache

- global options: configure kubernetes plugin to have right limits of memory
 Maven used >300MB locally

- setup my own project, pulled from git and used the configured maven to launch test goal
