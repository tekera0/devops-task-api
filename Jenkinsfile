pipeline {
    agent any
    tools {
        maven 'Maven 3.9' // Ensure this matches your Jenkins tool configuration name
        jdk 'JDK 17'      // Ensure this matches your Jenkins tool configuration name
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build & Test') {
            steps {
                sh './mvnw clean package'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}