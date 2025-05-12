pipeline {
    agent { label 'cc-slave' }

    environment {
        GOOGLE_CHAT_WEBHOOK_ID = 'google-chat-webhook-cc'
        AWS_REGION = 'us-east-1'
        S3_BUCKET_NAME = 'glr-dev-artifact-cc-core'
        S3_ARTIFACT_KEY = 'greenlight-rct-core-0.0.1-SNAPSHOT.jar'
    }
    stages {

        stage('Notify Build Start') {
            steps {
                script {
                    def buildStartMessage = """🚀 Build Started:
*Build Name:* ${env.JOB_NAME} [${env.BUILD_NUMBER}]
*Build Status:* Started
*Build URL:* ${env.BUILD_URL}
                    """
                    sendMessageToGoogleChat(buildStartMessage)
                }
            }
        }

        stage('Checkout Code') {
            steps {
                script {
                    git credentialsId: 'Github', 
                        url: 'https://github.com/Greenlight-Recruitment/cc-core.git',
                        branch: 'dev'
                }
            }
        }

        stage('Clean & Build') {
            steps {
                echo "Running gradle clean build..."
                sh './gradlew clean build -x test'
            }
        }
        stage('Publish Artifact to Slave Directory') {
            steps {
                script {
                    sh '''
                        mkdir -p /home/ubuntu/core-artifact
                        cp build/libs/*.jar /home/ubuntu/core-artifact/greenlight-rct-core-0.0.1-SNAPSHOT.jar
                    '''
                }
            }
        }

        stage('Publish Artifact to S3') {
            steps {
                withAWS(region: "${env.AWS_REGION}") {
                    script {
                        sh '''
                            aws s3 cp build/libs/*.jar s3://${S3_BUCKET_NAME}/${S3_ARTIFACT_KEY}
                        '''
                    }
                }
            }
        }
    }

    post {
        always {
            echo "Cleaning up the workspace..."
            cleanWs()
        }

        success {
            script {
                def successMessage = """✅ Build Success:
*Build Name:* ${env.JOB_NAME} [${env.BUILD_NUMBER}]
*Build Status:* Success
*Build URL:* ${env.BUILD_URL}
                """
                sendMessageToGoogleChat(successMessage)
            }
        }

        failure {
            script {
                def failureMessage = """❌ Build Failure:
*Build Name:* ${env.JOB_NAME} [${env.BUILD_NUMBER}]
*Build Status:* Failure
*Build URL:* ${env.BUILD_URL}
                """
                sendMessageToGoogleChat(failureMessage)
            }
        }
    }
}

def sendMessageToGoogleChat(String message) {
    withCredentials([string(credentialsId: GOOGLE_CHAT_WEBHOOK_ID, variable: 'GOOGLE_CHAT_WEBHOOK_URL')]) {
        def payloadGoogleChat = [
            "text": message
        ]
        httpRequest httpMode: 'POST',
                    acceptType: 'APPLICATION_JSON',
                    contentType: 'APPLICATION_JSON',
                    requestBody: groovy.json.JsonOutput.toJson(payloadGoogleChat),
                    url: GOOGLE_CHAT_WEBHOOK_URL
    }
}
