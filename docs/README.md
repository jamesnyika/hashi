# Exercise : Hashicorp

by *James Nyika*


### Consul – connect services with mutual TLS

A prospect is interested in establishing mutual TLS between applications or services

* Demonstrate consul connect establishing connectivity and service segmentation between a Tomcat app or another app and a database.
* Demonstrate denying access from the app to the database using intentions toggle approval or denial of connectivity (live demo)
* Describe the solution, slides, Consul UI, etc
* Be ready to answer technical questions about the solution, compared to GTM, etc

### Plan of Action

 - [X] Read and understand instructions
 - [X] Prepare the requisite applications in place to support the exercise.
   - [X] Web Server: HTTPKIT
   - [X] Apache Derby Database (Network Mode)
   - [X] Simple API - Create, List, Drop, Sort by Col, Find by ID
   - [X] Verify ability run from localhost and remotely

- [X] Install and Configure Consul services
  - [X] Verify the services are seen and monitored as being up and running
  - [ ] Configure the TLS connectivity between them
  - [ ] Validate encryption between the links
  - [ ] Add monitoring checks 20s apart for both server and client

- [ ] Configure deny intents
  - [ ] Verify working intentions

- [ ] Prepare Slides
    [ ] Demonstrate value of the solution
    [ ] Draw up list of possible objections to the solution
    [ ] Draw up list of possible questions
    [ ] Capture/Learn the Raft Algorithm

 - [ ] Practice
 - [ ] Screen Captures


### Challenges Encountered

 #### Technical Challenges
 ---

 * General Network Connectivity for Derby [#2](https://github.com/jamesnyika/hashi/issues/2)
 * Configuring database driver loading [#1](https://github.com/jamesnyika/hashi/issues/1)
