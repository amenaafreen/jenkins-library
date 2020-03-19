String basePath = 'Jenkins-Pipeline'
folder(basePath) {
    description('Folder containing all jobs for folder')
}

pipelineJob('jenkins-build-job') {
    definition {
        cps {
            scriptPath("Jenkinsfile")
        }
    }

}
