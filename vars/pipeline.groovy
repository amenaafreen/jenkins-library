def call(Map pipelineParams) {
  
    pipeline {
        agent any
        stages {
            stage('checkout git') {
                steps {
                    git branch: pipelineParams.branch, url: pipelineParams.scmUrl
                }
            }

            stage('build') {
                steps {
                    def mvn_inst = 'Maven'
                    withEnv( ["PATH+MAVEN=${tool mvn_inst}/bin"]
                    sh 'mvn clean package -DskipTests=true'
                }
            }
    }
  }
}
