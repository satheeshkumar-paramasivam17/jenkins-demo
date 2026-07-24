pipeline {
    agent any

    // polling SCM
    // Jenkins checks GitHub approximately every one minutes.

    //Jenkins checks GitHub
      //        ↓
      //Is there a new commit?
      //        ↓
      //Yes → Start pipeline
      //No  → Do nothing
      //
      //H allows Jenkins to choose a suitable second/minute instead of every job checking at exactly the same moment.
    triggers {
        pollSCM('H/2 * * * *')
    }

    stages {
        stage('Compile') {
            steps {
                bat 'call mvnw.cmd clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'call mvnw.cmd test'
            }
        }

        stage('Package') {
            steps {
                bat 'call mvnw.cmd package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t jenkins-demo:%BUILD_NUMBER% -t jenkins-demo:latest .'
            }
        }
    }

    post {
        success {
            echo 'Build, tests and packaging completed successfully!'
        }

        failure {
            echo 'Pipeline failed. Check the failed stage and Console Output.'
        }

        always {
            junit testResults: 'target/surefire-reports/*.xml',
                  allowEmptyResults: true

            archiveArtifacts artifacts: 'target/*.jar',
                             fingerprint: true,
                             allowEmptyArchive: true
        }
    }
}