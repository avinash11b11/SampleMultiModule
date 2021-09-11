pipeline{
    agent any
    stages{
        stage('Clean'){
            steps{
                cleanWs()
            }
        }
        stage('Checkout'){
            steps{
                  checkout poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'github_pat', url: 'https://github.com/avinash11b11/SampleMultiModule.git']]]
            }
        }
        stage('Build'){
            steps{
                   bat '''
                       mvn clean install
                       '''
            }
        }
    }
}
