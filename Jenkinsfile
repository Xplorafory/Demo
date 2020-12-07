pipeline {
    
    agent {
        node { label 'remote2' }
    }

    tools {
      maven 'M3'
      
    }

    stages {
        stage("build") {
            steps {

                sh "mvn -B clean"
            }
        }

        stage("test") {
            steps {
                echo 'testing the application...'
                sh "mvn integration-test"
            }
        }
        
        stage("deploy") {
            steps{
                echo 'deploying the application...'
            }
        }
    }
    post {
        always {
            echo 'This will always run'
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            junit '**/target/surefire-reports/TEST-*.xml'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
       /*     mail to: 'jonas.breisel@xploraforytest.se',
                subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                body: "Something is wrong with ${env.BUILD_URL}"*/
        }
        unstable {
            echo 'This will run only if the run was unstable'
        }
        changed {
            echo 'This will run only if the state of the pipeline has changed'
        }
    }
}