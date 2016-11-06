node {
    checkout scm

    def mvnHome = tool 'mvn-default'
    sh "${mvnHome}/bin/mvn -Dmaven.test.failure.ignore=true clean test site"
}
