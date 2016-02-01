mvn clean install -DskipTests
rm -rf $tom/library*
cp web/target/library.war $tom
