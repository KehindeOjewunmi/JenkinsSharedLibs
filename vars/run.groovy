def call(String stageName){
  
  if ("${stageName}" == "Build")
     {
       sh "mvn clean package"
     }
  else if ("${stageName}" == "SonarQube Report")
     {
       sh "mvn clean sonar:sonar"
     }
  else if ("${stageName}" == "Upload Into Nexus")
     {
       sh "mvn clean deploy"
     }
  else if ("${stageName}" == "Approval")
     {
       sh "echo This stage requires manual approval to proceed"
        timeout(time:2, unit:'DAYS'){
        input message: 'Approval for Prod Env'
     }
     }
  else if ("${stageName}" == "SlackAlert")
     {
       sh "echo This stage provides pipeline status on slack channel"
        slackSend channel: 'c9-devsquad-group-4', message: 'Build Successful'
     }
  else if ("${stageName}" == "EmailAlert")
     {
       sh "echo This stage provides pipeline status by email"
        emailext body: 'Build Success', subject: 'Build Status', to: 'kaydevopslearning@gmail.com'
     }
}