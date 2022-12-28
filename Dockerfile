FROM openjdk
ARG JAR_PATH=./target/*.jar
ARG WORK_DIR=/usr/app
ARG DB_URL=jdbc:mysql://db:3306/demo
ARG DB_USER_NAME=demo
ARG DB_PASSWORD=demo
EXPOSE 8087
COPY ${JAR_PATH} ${WORK_DIR}/app.jar
WORKDIR ${WORK_DIR}
ENTRYPOINT ["java","-jar","app.jar"]
