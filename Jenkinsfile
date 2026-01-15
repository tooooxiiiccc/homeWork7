pipeline {
    agent any
    
    parameters {
        choice(
            name: 'TAG',
            choices: ['smoke', 'regress', 'all'],
            description: 'Выберите набор тестов для запуска'
        )
        string(
            name: 'SELENOID_URL',
            defaultValue: 'http://host.docker.internal:4444/wd/hub',
            description: 'URL Selenoid сервера'
        )
        string(
            name: 'BROWSER',
            defaultValue: 'chrome',
            description: 'Браузер для запуска тестов'
        )
        string(
            name: 'BROWSER_VERSION',
            defaultValue: '128.0',
            description: 'Версия браузера'
        )
        string(
            name: 'PARALLEL_THREADS',
            defaultValue: '4',
            description: 'Количество параллельных потоков'
        )
    }
    
    environment {
        SELENOID_URL = "${params.SELENOID_URL}"
        BROWSER = "${params.BROWSER}"
        BROWSER_VERSION = "${params.BROWSER_VERSION}"
        PARALLEL_THREADS = "${params.PARALLEL_THREADS}"
    }
    
    stages {
        stage('Checkout') {
            steps {
                script {
                    if (env.GIT_BRANCH) {
                        checkout scm
                    } else {
                        echo 'Используется текущая рабочая директория'
                    }
                }
            }
        }
        
        stage('Build') {
            steps {
                sh './gradlew clean build -x test'
            }
        }
        
        stage('Tests') {
            steps {
                script {
                    def tagFilter = params.TAG == 'all' ? '' : "-Ptag=${params.TAG}"
                    
                    echo "Запуск тестов с параметрами:"
                    echo "  TAG: ${params.TAG}"
                    echo "  SELENOID_URL: ${SELENOID_URL}"
                    echo "  BROWSER: ${BROWSER}"
                    echo "  BROWSER_VERSION: ${BROWSER_VERSION}"
                    echo "  PARALLEL_THREADS: ${PARALLEL_THREADS}"
                    
                    sh """
                        echo "Проверка доступности Selenoid..."
                        curl -f ${SELENOID_URL}/status || echo "WARNING: Selenoid может быть недоступен"
                    """
                    
                    sh """
                        ./gradlew test ${tagFilter} \
                            -Dselenoid.url=${SELENOID_URL} \
                            -Dselenide.remote=${SELENOID_URL} \
                            -Dbrowser=${BROWSER} \
                            -Dbrowser.version=${BROWSER_VERSION} \
                            -Dparallel.threads=${PARALLEL_THREADS} \
                            --info
                    """
                }
            }
        }
        
        stage('Allure Report') {
            steps {
                script {
                    sh './gradlew allureReport'
                }
            }
            post {
                always {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'build/allure-results']]
                    ])
                }
            }
        }
    }
    
    post {
        always {
            archiveArtifacts artifacts: 'build/allure-results/**/*', allowEmptyArchive: true
            archiveArtifacts artifacts: 'build/reports/**/*', allowEmptyArchive: true
        }
        failure {
            echo 'Тесты завершились с ошибками'
        }
        success {
            echo 'Все тесты прошли успешно'
        }
    }
}


