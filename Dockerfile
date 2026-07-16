# Stage 1: Build & Compile Java Code (JDK 17)
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

# Copy project source files
COPY . .

# Create class destination directory
RUN mkdir -p WEB-INF/classes

# Install wget and compile using Jakarta Servlet API 5.0.0
RUN apt-get update && apt-get install -y wget && \
    wget https://repo1.maven.org/maven2/jakarta/servlet/jakarta.servlet-api/5.0.0/jakarta.servlet-api-5.0.0.jar -O /tmp/jakarta-servlet.jar && \
    find . -name "*.java" > sources.txt && \
    javac -cp "/tmp/jakarta-servlet.jar:WEB-INF/lib/*" -d WEB-INF/classes @sources.txt

# Optional: create a WAR-like layout if your app expects /WEB-INF, /META-INF etc.
RUN mkdir -p target/WEB-INF && cp -r WEB-INF/classes target/WEB-INF/classes && \
    if [ -d WEB-INF/lib ]; then cp -r WEB-INF/lib target/WEB-INF/lib; fi

# Stage 2: Runtime Environment with Apache Tomcat 10 (Jakarta)
FROM tomcat:10.1-jdk17-temurin
# Remove default ROOT app
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy compiled app into Tomcat ROOT
COPY --from=builder /app/target /usr/local/tomcat/webapps/ROOT

EXPOSE 8080
CMD ["catalina.sh", "run"]
