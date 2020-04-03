#!groovy
import groovy.json.JsonBuilder

def attachmentPayload = [[
    fallback: "execution #${env.BUILD_NUMBER}",
    color: "#2eb886",
    pretext: "${env.JOB_NAME}",
    text: "TEST DONE #${env.BUILD_NUMBER}",
]]

pipeline {
    agent {
        label 'master'
    }
    environment {
        mysqlserver = ${MYSQL_SERVER}
        mysqlpassword = ${MYSQL_PASSWORD}
    }
    agent {
        docker {
            image 'osdn/slash-build'
            args '-e MYSQL_SERVER=${mysqlserver} -e MYSQL_PASSWORD=${mysqlpassword}'
        }
    }
    stages {
        stage('Test') {
            steps {
                //sh 'rm -rf RestServiceSample'
                //sh 'git clone https://github.com/cutem-0104/RestServiceSample.git'
                //sh 'cd RestServiceSample && gradle clean test'
                sh 'gradle clean test'
            }
        }
    }
    post {
        always {
            echo 'TEST DONE'
            script {// ここだけscripted pipeline のsyntaxを適用する
                slackSend(channel: '#sugaya_github_bot', color: "#2eb886", attachments: new JsonBuilder(attachmentPayload).toString())
            }
        }
    }
}
