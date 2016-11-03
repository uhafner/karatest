node {
    stage 'Checkout'
  
    git url: 'https://github.com/jenkinsci/analysis-suite-plugin.git'

    sh 'git submodule init'
    sh 'git submodule update'
    
    stage 'Build'
    
    def mvnHome = tool 'mvn-default'
    sh "${mvnHome}/bin/mvn -B verify"
}
