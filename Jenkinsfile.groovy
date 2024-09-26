pipeline {
    agent any

    stages{
        stage("Checking out the code"){
            steps{
                checkout scm
            }
        }

        stage("Setting up Node.js"){
            steps{
                tool name: 'NodeJS', type: 'nodejs'
            }
        }


        stage("installing dependencies"){
            steps{
               sh 'npm install'
            }
        }


        stage("starting the app"){
            steps{
                sh  'npm start &' 
            }
        }

        stage("running tests"){
            steps{
                npm test
            }
        }
    }
}