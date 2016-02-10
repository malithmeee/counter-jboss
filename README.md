# library
Example for EJB3 + Jboss 5.1.0 GA + Maven + Mysql + JSF 2 + AJAX

1 Make full build of the maven project

2 Start two jboss instance
Start JBOSS two instances with below commands

Instance 1 with port 8080
    ./run.sh -c default
Instance 2 with port 8180
    ./run.sh -c standard -Djboss.service.binding.set=ports-01 -Djboss.messaging.ServerPeerID=1

3 Initiate queue call "CountQueue" on jboss instance 1

4 Deploy counter.ear ear with EJBs to instance 1
counter-jboss/ear/target/counter.ear

5 Deploy the ear with client to instance 2
counter-jboss/counter-ear/target/counter-client.ear

6 Access the UI of instance 1 by below URL
http://localhost:8080/counter.web/
Click on RUN button - will start to send request to EJB Queue
Click on Count button - will update current count
Click on Stop - will stop sending queue requests.

7 Access the UI of instance 2 by below ERL
http://localhost:8180/counter.client/
Click on Count button - will update current count

Remote server-clint
===================
# Start the remote server (Instance 1) in separate machine
./run.sh -c default -Djboss.service.binding.set=ports-01 -Djboss.messaging.ServerPeerID=1 -b 0.0.0.0 (For port 8180)
./run.sh -c default -b 0.0.0.0 (For port 8080)

# Start the client server as usual