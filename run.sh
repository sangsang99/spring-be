#!/bin/bash

JAR_PATH="build/libs/spring-be-0.0.1-SNAPSHOT.jar"
PID_FILE="logs/spring-be.pid"

case "$1" in
    run)
        echo "Building the project..."
        ./gradlew clean bootJar > logs/runtime.log 2>&1 &
        echo "Running the application..."
        nohup java -jar $JAR_PATH > logs/runtime.log 2>&1 &
        echo $! > $PID_FILE
        echo "Application started with PID $(cat $PID_FILE)"
        ;;
    status)
        if [ -f $PID_FILE ]; then
            PID=$(cat $PID_FILE)
            if ps -p $PID > /dev/null; then
                echo "Application is running with PID $PID"
            else
                echo "Application is not running, but PID file exists"
            fi
        else
            echo "Application is not running"
        fi
        ;;
    stop)
        if [ -f $PID_FILE ]; then
            PID=$(cat $PID_FILE)
            echo "Stopping the application with PID $PID..."
            kill $PID
            rm $PID_FILE
            echo "Application stopped"
        else
            echo "Application is not running"
        fi
        ;;
    *)
        echo "Usage: $0 {run|status|stop}"
        exit 1
        ;;
esac
