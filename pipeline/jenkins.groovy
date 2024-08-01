pipeline {
    agent any
    parameters {
        choice(name: 'OS', choices: ['linux', 'darwin', 'windows', 'all'], description: 'Pick OS', defaultValue: 'linux')
        choice(name: 'ARCH', choices: ['amd64', 'arm64'], description: 'Pick architecture', defaultValue: 'amd64')
    }
    stages {
        stage('Example') {
            steps {
                echo "Build for platform ${params.OS}"
                echo "Build for arch: ${params.ARCH}"
            }
        }
    }
}
