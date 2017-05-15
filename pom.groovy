project {
  modelVersion '4.0.0'

  groupId 'net.selfdotlearn.example'
  artifactId 'polygot-groovy-example'
  version '1.0.0-SNAPSHOT'

  properties {
    'project.build.sourceEncoding' 'UTF-8'
    'java.version' '1.8'
  }

  dependencies {
    dependency {
      groupId 'junit'
      artifactId 'junit'
      version '4.12'
      scope 'test'
    }
    dependency {
      groupId 'org.assertj'
      artifactId 'assertj-core'
      version '3.7.0'
    }
  }

  build {
    plugins {
      plugin {
        artifactId 'maven-compiler-plugin'
        version '3.3'
        configuration {
          compilerVersion '${java.version}'
          source '${java.version}'
          target '${java.version}'
        }
      }
      plugin {
        artifactId 'maven-shade-plugin'
        version '2.3'
        executions {
          execution {
            phase 'package'
            goals {
              goal 'shade'
            }
            configuration {
              transformers {
                transformer(implementation:'org.apache.maven.plugins.shade.resource.ServicesResourceTransformer') {}
                transformer(implementation:'org.apache.maven.plugins.shade.resource.ManifestResourceTransformer') {
                  mainClass 'net.selfdotlearn.example.Main'
                }
              }
            }
          }
        }
        configuration {
          createDependencyReducedPom 'false'
          filters {
            filter {
              artifact '*:*'
              excludes {
                exclude 'META-INF/*.SF'
                exclude 'META-INF/*.DSA'
                exclude 'META-INF/*.RSA'
              }
            }
          }
        }
      }
    }
  }
}
