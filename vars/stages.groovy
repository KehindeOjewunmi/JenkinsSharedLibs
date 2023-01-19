def call(String stageName){
  
  if ("${stageName}" == "Build")
     {
       sh "echo code is being built"
       sh "mvn clean package"
     }
  else if ("${stageName}" == "SonarQube Report")
     {
       sh "echo codequality is being checked"
       sh "mvn clean sonar:sonar"
     }
  else if ("${stageName}" == "Upload Into Nexus")
     {
       sh "echo performing artifact back up to nexus"
       sh "mvn clean deploy"
     }
}
