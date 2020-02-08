![Hashicorp](./resources/images/hclogo.png)

## Hashicorp SC Exercise

### Getting Started

#### Prerequisites
---

* Install [Clojure](www.clojure.org)
* Install [Leiningen](www.leiningen.org).
* [Apache Derby](http://db.apache.org/derby/) is the database used but is included in this exercise.
* Install [Hashicorp's Consul](https://www.consul.io/) to handle your service discovery, segmentation and configuration.


#### Running The Code
---

1. Start Derby. From a terminal, change into the hashi directory and run the startdb.sh script

````bash  
$ cd hashi
$ ./startup.sh
````

2. Start the web application server

````bash  
$ lein run
````

3. Start Consul
