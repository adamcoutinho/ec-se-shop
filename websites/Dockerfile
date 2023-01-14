FROM tomcat:jdk11-corretto

COPY build/libs/websites-1.0-SNAPSHOT.war website.war

ADD website.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD chmod +x /usr/local/tomcat/bin/catalina.sh
CMD ["catalina.sh", "run"]