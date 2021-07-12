@Library('jenkins-library@master') _  // This is used to tell the pipeline to use this shared library , but this library should be configured in jenkins under shared library section.

pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
            gitCheckout(    // Now We use gitCheckout func from above shared library and provide two parameters to the func, func generally means the file name of groovy under vars directory
            
                branch: "main",
                url: "https://github.com/spring-projects/spring-petclinic.git"
            )
            }
    }
    }
}
