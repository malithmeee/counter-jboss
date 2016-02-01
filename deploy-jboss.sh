JBOSS_HOME=/home/malith/usr/jboss-5.1.0.GA/
#JBOSS_HOME=/home/malith/usr/jboss-6.1.0.Final/
mvn clean install -DskipTests
rm -rf $JBOSS_HOME/server/default/deploy/counter*
cp ear/target/*.ear $JBOSS_HOME/server/default/deploy/
cp counter-ear/target/*.ear $JBOSS_HOME/server/default/deploy/
