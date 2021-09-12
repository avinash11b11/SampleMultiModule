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
        stage('Build and deploy'){
          
            steps{
                  withCredentials([usernamePassword(credentialsId: 'nexus-user', passwordVariable: 'nexuspass', usernameVariable: 'nexususer')]) {
                   bat '''
                       mvn --settings settings.xml clean deploy -Dserver.username=${nexususer} -Dserver.password=${nexuspass}
                       '''
                }
            }
             
        }
         stage('Release'){
          
            steps{
                checkout poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'github_pat', url: 'https://github.com/avinash11b11/SampleMultiModule.git']]]
                  withCredentials([usernamePassword(credentialsId: 'nexus-user', passwordVariable: 'nexuspass', usernameVariable: 'nexususer')]) {
                   bat '''
                
                       mvn --settings settings.xml release:clean release:prepare -Dserver.username=${nexususer} -Dserver.password=${nexuspass}
                       '''
                }
            }
             
        }
    }
}
