JBOSS_HOME=/home/malith/usr/jboss-5.1.0.GA/
mvn clean install -DskipTests
rm -rf $JBOSS_HOME/server/default/deploy/library*
cp target/library.ear $JBOSS_HOME/server/default/deploy/
