FROM tomcat:10.1-jdk17

# Clean default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Add PostgreSQL JDBC driver
COPY webapp/WEB-INF/lib/postgresql-42.7.3.jar /usr/local/tomcat/lib/

# Deploy WAR file (replace YOUR_APP.war with actual name)
COPY target/JSP-ASS-01-LoginPage_warexploded.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]