pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                bat 'mvnw.cmd clean package'
            }
        }

    }

    post {
        success {
            echo 'Build Successful!'
        }
    }
}