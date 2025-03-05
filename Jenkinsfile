pipeline {
    agent any

    environment {
        // Define environment variables
        REPO_URL = 'https://github.com/Abdelouahed-SENANE/surveyit-api.git'
        BRANCH = 'main' // Change this to your default branch
        ARTIFACT_NAME = 'surveyit-api.jar' // Name of the built artifact
        DEPLOY_ENV = 'production' // Deployment environment (customize as needed)
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the Git repository
                git branch: "${BRANCH}", url: "${REPO_URL}"
            }
        }

        stage('Build') {
            steps {
                // Build the Maven project
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Run tests
                sh 'mvn test'
            }
            post {
                // Archive test results
                success {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Deploy') {
            when {
                // Only deploy if the branch is 'main' and tests pass
                expression { BRANCH == 'main' }
            }
            steps {
                // Deploy the artifact (this is just an example)
                echo "Deploying ${ARTIFACT_NAME} to ${DEPLOY_ENV}"
                // Add deployment steps here, such as copying the artifact to a server
                // or using a deployment tool like Ansible, Kubernetes, etc.
                // Example: scp or kubectl commands
            }
        }
    }

    post {
        always {
            // Clean up workspace after the build
            cleanWs()
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
