# jenkins-shared-library-structure
A template structure for Jenkins Shared Library 
---

- Jenkins Shared Library repo should be configured in jenkins before using below functionality 
- Sample Pipeline Calling mail-send using shared library function.

```
@Library('jenkins-library@master') _  // This is calling Library configured in jenkins with the name of "jenkins-library"

pipeline {
agent any
stages {
stage('Ok') {
steps {
echo "Ok"
sh 'touch test.txt'
sh 'echo "hello,this is test from Prasoon"> test.txt'
sh 'cat test.txt'
}
}
}
post {
always {

    //Calling of Groovy Method
    DisplayName()
 
 // This mailsend method is a groovy method and it is coming from shared library i.e you can reuse this snippet in other project    
mailsend(
    body: "This is from Shared Library",
    sub: "This is Library Subject",
    to: "prassonmishra330@gmail.com",
    attachmentsPattern: 'test.txt'
    
    )
  
  // Below is direct snippet for sending mail without using shared library .  
    
    /*emailext(
    to: 'prassonmishra330@gmail.com',
    body: "Test From Prasoon (${env.BUILD_URL})", 
    mimeType: 'text/html',
    subject: "[Jenkins] '${env.JOB_NAME}'",
    replyTo: '$DEFAULT_REPLYTO' ,
    attachmentsPattern: 'test.txt'  // Used for attachments of file
    )*/
    
}
}

}

// Groovy Method 

def DisplayName() {
    
      println("This is how methods work in groovy");
      println("This is an example of a simple method");
   } ```
