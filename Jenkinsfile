pipeline {
    agent any
    parameters {
  string defaultValue: 'main', name: 'BRANCH', trim: true
}

    

    stages {
        stage('Git checkout') {
            steps {
                git branch: '${BRANCH}', url: 'https://github.com/DamChol/Rest1.git'
            }
        }
		
		stage('Run API tests') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Build App') {
            steps {
                echo 'Compile code'
                
                echo 'Run unit tests'
            }
        }
        stage('Deploy to test env') {
            steps {
                echo 'Deploying to test env'
            }
        }
        stage('Run UI tests on test env') {
            steps {
                echo 'Run UI tests'
            }
        }


    }
}
