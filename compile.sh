
cfg=$PWD/out/ni
mkdir -p $cfg

groovyc src/sh-test.groovy -d=target/classes


$HOME/prg/graalvm/bin/java \
-agentlib:native-image-agent=config-output-dir=$cfg \
-cp ./target/classes:/home/dz/prg/groovy-4.0.18/lib/groovy-4.0.18.jar TestSh \



$HOME/prg/graalvm/bin/native-image \
 --no-fallback --no-server \
 -Djava.awt.headless=true -Dgroovy.grape.enable=false \
 --report-unsupported-elements-at-runtime \
    --initialize-at-build-time \
 -H:ConfigurationFileDirectories=$cfg -cp ./target/classes:/home/dz/prg/groovy-4.0.18/lib/groovy-4.0.18.jar \
 TestSh
