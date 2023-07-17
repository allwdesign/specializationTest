FROM openjdk:11

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp

ENV CLASSPATH=$CLASSPATH:/usr/src/myapp

CMD javac Main.java && java Main
 
VOLUME /usr/src/myapp
