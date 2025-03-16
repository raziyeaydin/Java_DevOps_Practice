# Java_DevOps_Practice
I'm practicing on DevOps with Java and planning to improve the code varieties and my skills through this work.

Let's start stage by stage!!

I started by creating really basic a spring boot project and then have developed two different services that are exposed externally.
Then,
`mvn clean` and `mvn install` in terminal.(If you don't see the jar file of your project, you should `mvn package`) and we run the springboot project

So now, we can see our services are up and accessible via http://localhost:8080/info and http://localhost:8080/warn
***
## How we deploy our project to Docker system
_I assume that you have Docker on your computer._
Firstly, we need to add a `Dockerfile` to the main directory, it means this file should be in the same hierarchy with src folder
We have a jar file within target directory as versioned.

We are able to deploy our jar file to Docker system with this command.

```docker buildx build --build-arg JAR_FILE=target/devops-practicing-1.0.1.jar --tag devops-app:v1 . ```

--tag operator helps us to give a name to our project in Docker system.
with : sign, we can specify which version our application has currently, thereby we can hold every version of our project in Docker system.

And one more note: Once you deploy your versioned jar to Docker system, you should additionally deploy the same jar as latest. Thus, if it is not specified a version, still it can be used.

for **devops-practicing-1.0.2.jar**

```docker buildx build --build-arg JAR_FILE=target/devops-practicing-1.0.2.jar --tag devops-app:v2 . ```

```docker buildx build --build-arg JAR_FILE=target/devops-practicing-1.0.2.jar --tag devops-app:latest . ```

### What are Image and Container
Now, We can see our application in Docker system inside Image folder. Because every jar is an image that is runnable. 
Let's start to use Docker to run our application without IDE.
Stop the running app in IDE and then run the app in Docker.(I gave 8081 as the host port), and now we can test the link whether is work or not http://localhost:8081/info and http://localhost:8081/warn
Likewise, we can create lots of container of the same app through different port number.

*I have some changes on the services and updated the version of the app. Because of the changes in pom.xml, don't forget to do `mvn clean` and `mvn install`. If you have only changes in your class, `mvn package` is enough.

After this commit, you can see that you have 3 images(v1, v2 and latest) and 2 containers which one of them works on 8081(for v1), the other one works on 8082(for v2)
***