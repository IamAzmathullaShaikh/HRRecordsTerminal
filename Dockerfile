# Stage 1: compile with Temurin 17 (javax servlet)
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

# Copy project
COPY . .

# Prepare classes dir
RUN mkdir -p WEB-INF/classes

# Install wget and download javax servlet API for compilation
RUN apt-get update && apt-get install -y wget && \
    wget -q https://repo1.maven.org/maven2/javax/servlet/javax.servlet-api/4.0.1/javax.servlet-api-4.0.1.jar -O /tmp/servlet-api.jar

# Compile all .java sources into WEB-INF/classes
RUN find . -name "*.java" > sources.txt && \
    javac -cp "/tmp/servlet-api.jar:WEB-INF/lib/*" -d WEB-INF/classes @sources.txt

# Create exploded webapp layout under target/
RUN mkdir -p target/WEB-INF && cp -r WEB-INF/classes target/WEB-INF/classes && \
    if [ -d WEB-INF/lib ]; then cp -r WEB-INF/lib target/WEB-INF/lib; fi

# Stage 2: runtime with Tomcat 9 (javax)
FROM tomcat:9.0-jdk17-temurin
# Remove default ROOT
RUN rm -rf /usr/local/tomcat/webapps/ROOT
# Copy exploded webapp into ROOT
COPY --from=builder /app/target /usr/local/tomcat/webapps/ROOT

EXPOSE 8080
CMD ["catalina.sh", "run"]
