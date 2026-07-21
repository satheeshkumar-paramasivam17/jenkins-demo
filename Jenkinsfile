pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'call mvnw.cmd clean package'
            }
        }
    }

    post {
        success {
            echo 'Build Successful!'
        }

        always {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}