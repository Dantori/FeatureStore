pipeline {
    agent any

    tools {
        jdk 'jdk_21.0.6_7'
        maven 'Maven_3.9.9'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Клонируем проект из GitHub'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Сборка Maven проекта'
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                echo 'Запуск тестов'
                sh 'mvn test'
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo 'Архивирование артефактов'
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            }
        }
    }

    post {
        success {
            echo '✅ Сборка завершена успешно!'
        }
        failure {
            echo '❌ Сборка завершилась с ошибками!'
        }
    }
}
