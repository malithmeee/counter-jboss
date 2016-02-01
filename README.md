# library
Example for EJB3 + Jboss 5.1.0 GA + Maven + Mysql + JSF 2

# Try out URLs

Send jms message to queue
curl -i -X GET http://localhost:8080/library.api/message

Send rest API call with Json
curl -i -H "Content-type: application/json" -X POST -d '{"name":"JSON"}' http://localhost:8080/library.api/library/book

Try out UI with JSF (In web browser)
http://localhost:8080/library.web/home.jsf
