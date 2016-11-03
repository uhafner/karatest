node {
    step([$class: 'WsCleanup'])

    def mvnHome = tool 'mvn-default'
    sh "${mvnHome}/bin/mvn -Dmaven.test.failure.ignore=true test site"
}
