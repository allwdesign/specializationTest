FROM openjdk:11
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp

# Executes a Linux command during image build
RUN javac Main.java

# Describes the command and arguments to be executed immediately after the 
# container is started.
CMD ["java", "Main"]