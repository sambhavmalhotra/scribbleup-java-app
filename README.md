# `Scribble Up` — a demo application

This project is a Java application. It is only for demo and analysis purpose.

This application is used for users to sign up of login and add posts about what they have in mind. Its like an personal online diary.

It is the backend application for ScribbleUpApp which has UI for this app written in AngularJS.
You can get the UI app here:
```
https://github.com/sambhavmalhotra/scribbleUpApp.git
```

## Getting Started

To get you started you can simply clone the repository and install the dependencies:

### Prerequisites

You need git to clone the 'scribbleup-java-app' repository.
You can get it from here: 
```
https://github.com/sambhavmalhotra/scribbleup-java-app.git
```

Also, you need to have Java 1.8 installed in you local system.
You can get it from here: 
```
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
```

### Clone `scribbleup-java-app`

Clone the `scribbleup-java-app` repository using git:

```
https://github.com/sambhavmalhotra/scribbleup-java-app.git

```

### Install Dependencies

This app has only java and maven dependency. So you can install them by using the following command:

```
mvn clean install
```
If all imports are not made, enable 'Auto Import' in your IDE.

### Run the Application

The app is preconfigured with a simple Spring Boot Server.
To run the app, run the 'ScribbleUpJavaApp' in configurations.
The java application will be running on port 7070.
To view the app, run the UI application for this app as mentioned above.

This Java app runs on h2 DB, each time the java app is rerun, it will clear the DB.