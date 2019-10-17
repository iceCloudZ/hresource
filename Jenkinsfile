pipeline {
  agent 
    {
    docker {
          image 'ccr.ccs.tencentyun.com/tsf_100000778480/hresource'
          registryUrl 'ccr.ccs.tencentyun.com'
          registryCredentialsId '100000778480'
      }
  }
  stages {
    stage('检出') {
      steps {
        checkout([$class: 'GitSCM', branches: [[name: env.GIT_BUILD_REF]], 
                                                                                            userRemoteConfigs: [[url: env.GIT_REPO_URL, credentialsId: env.CREDENTIALS_ID]]])
      }
    }
    stage('编译') {
      steps {
        sh 'mvn clean install -U -Dmaven.test.skip'
      }
    }
    stage('打包镜像') {
      steps {
        sh "docker build -t ${ARTIFACT_IMAGE}:${env.GIT_BUILD_REF} ."
        sh "docker tag ${ARTIFACT_IMAGE}:${env.GIT_BUILD_REF} ${ARTIFACT_IMAGE}:latest"
      }
    }
    stage('推送到制品库') {
      steps {
        script {
          docker.withRegistry("https://ccr.ccs.tencentyun.com/tsf_100000778480/hresource", "100000778480") {
            docker.image("${TKE_REPO}:${env.GIT_BUILD_REF}").push()
            docker.image("${TKE_REPO}:latest").push()
          }
        }

      }
    }
  }
  environment {
    ENTERPRISE = 'jiujiuhouse'
    PROJECT = 'hresource'
    ARTIFACT = 'hresource'
    CODE_DEPOT = 'hresource'
    ARTIFACT_BASE = "${ENTERPRISE}-docker.pkg.coding.net"
    ARTIFACT_IMAGE = "${ARTIFACT_BASE}/${PROJECT}/${ARTIFACT}/${CODE_DEPOT}"
    TKE_REPO = 'ccr.ccs.tencentyun.com/tsf_100000778480/hresource'
  }
}