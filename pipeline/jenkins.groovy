pipeline {
    agent any
    parameters {
        choice(name: 'OS', choices: ['linux', 'darwin', 'windows', 'all'], description: 'Pick OS', defaultValue: 'linux')
        choice(name: 'ARCH', choices: ['amd64', 'arm64'], description: 'Pick architecture', defaultValue: 'amd64')
    }
    stages {
        stage("clone") {
            steps {
                echo 'Clone Repository'
                git branch: 'main', url: 'https://github.com/ashcherbatyi/kbot.git'
            }
        }
        stage("test") {
            steps {
                echo 'Tests Started'
                sh 'make test'
            }
        }
        stage("build") {
            steps {
                echo 'BUILD STARTED'
                sh 'make build'
            }
        }
        stage("image") {
            steps {
                echo 'Image Execution Started'
                sh 'make image'
            }
        }
        stage("push") {
            steps {
                script {
                docker.withRegistry('', 'dockerhub') {
                    sh 'make push'
                    }               
                }  
            }
        }
    }
}
