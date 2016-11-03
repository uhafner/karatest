node {
    def mvnHome = tool 'mvn-default'
    sh "${mvnHome}/bin/mvn test -Dmaven.test.failure.ignore=true site
}
