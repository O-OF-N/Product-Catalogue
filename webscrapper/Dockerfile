#BUILD docker build -f Dockerfile -t oofn/java .
#RUN docker run -it oofn/java


FROM java:8
MAINTAINER O_OF_N
COPY /build/libs/ /var/www
WORKDIR /var/www
ENTRYPOINT ["java","-jar","webscrapper-1.0.jar"]