pipeline {
    
    environment {
        registry = "ankd21/spe_calculator"
        registryCredential = 'dockerhub_id'
        dockerImage = ''
    }
    
		agent any
    stages {
        stage('Git Pull') {
            steps {
                // Get code from a GitHub repository
                
								git url: 'https://github.com/AnkD21-me/SPE_Mini_Calculator.git', branch: 'main'

            }
        }
        stage('Maven Build') {
            steps {
                // Maven build, 'sh' specifies it is a shell command
                sh 'mvn clean install'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build 'ankd21/spe_calculator:latest'
                }
            }
        }
        
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        
        
        stage('Ansible Deploy') {
            steps {
                ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'playbook.yml', sudoUser: null

            }
        }
    }
}
