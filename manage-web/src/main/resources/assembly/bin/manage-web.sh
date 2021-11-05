#!/bin/sh

## service name(TODO-需要替换为自己服务名称)
APP_NAME=manage-web
## 启动等待最长时间
MAX_START_WAIT_SEC=60
## 当前等待时间
WAIT_SEC=1


## 服务所在路径(TODO-需要替换为自己的路径)
SERVICE_DIR=/Users/wukong/Desktop/tool/$APP_NAME
APP_DIR=$HOME
JAVA_JDK=jdk1.8.0_144
SERVICE_NAME=$APP_NAME
JAR_NAME=$SERVICE_NAME.jar
PID=$SERVICE_NAME.pid
PID_BAK=$PID.bak
## heap dump路径(TODO-需要替换为自己的路径)
HEAP_DUMP_PATH=/Users/wukong/Desktop/tool/logs/$APP_NAME/

cd $SERVICE_DIR

#使用说明，用来提示输入参数
usage() {
echo "Usage: sh 脚本名.sh [start|stop|restart|status]"
exit 1
}

#启动方法
start(){
nohup java -Djava.security.egd=file:/dev/./urandom -server -Xms1024m -Xmx1024m -Xmn512m -Xss256k -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m -XX:+UseConcMarkSweepGC -XX:+CMSIncrementalMode -XX:CMSFullGCsBeforeCompaction=5 -XX:+UseCMSCompactAtFullCollection -Xloggc:gc.log -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$HEAP_DUMP_PATH -jar $JAR_NAME >/dev/null 2>&1 &
        echo $! > $SERVICE_DIR/$PID
        echo "================================================== start $SERVICE_NAME begin... please wait $MAX_START_WAIT_SEC sec"
        while((WAIT_SEC < MAX_START_WAIT_SEC))
        do
     P_ID=`ps -ef | grep -w "$JAR_NAME" | grep -w "java" | grep -v "grep" | awk '{print $2}'`
            P_ID_COUNT=`ps -ef | grep -w "$JAR_NAME" | grep -w "java" | grep -v "grep" | wc -l`
            if [ $P_ID_COUNT = 0 ];then
                echo "================================================== start $SERVICE_NAME begin... wait time :$WAIT_SEC / $MAX_START_WAIT_SEC | P_ID_COUNT=$P_ID_COUNT"
  sleep 1
            else
                echo "================================================== start $SERVICE_NAME succeeded. pid=$P_ID,  costTime:$WAIT_SEC"
                let "WAIT_SEC = MAX_START_WAIT_SEC"
            fi
            let "WAIT_SEC += 1"
        done
}

#停止方法
stop(){
is_exist
if [ $? -eq "0" ]; then
echo "=== stop $SERVICE_NAME begin... please wait $MAX_START_WAIT_SEC sec"
        kill -15 `cat $SERVICE_DIR/$PID`
        mv $SERVICE_DIR/$PID $SERVICE_DIR/$PID_BAK
        rm -rf $SERVICE_DIR/$PID

  while((WAIT_SEC < MAX_START_WAIT_SEC))
        do
   P_ID=`ps -ef | grep -w "$JAR_NAME" | grep -w "java" | grep -v "grep" | awk '{print $2}'`
            P_ID_COUNT=`ps -ef | grep -w "$JAR_NAME" | grep -w "java" | grep -v "grep" | wc -l`
            if [ $P_ID_COUNT != 0 ]; then
                echo "=== stop $SERVICE_NAME begin by (kill -15)... wait time :$WAIT_SEC / $MAX_START_WAIT_SEC | P_ID_COUNT=$P_ID_COUNT"
    sleep 1
            else
                echo "=== stop $SERVICE_NAME succeeded by (kill -15). costTime:$WAIT_SEC"
                let "WAIT_SEC = MAX_START_WAIT_SEC"
            fi
            let "WAIT_SEC += 1"
        done

  P_ID=`ps -ef | grep -w "$JAR_NAME" | grep -w "java" | grep -v "grep" | awk '{print $2}'`
        P_ID_COUNT=`ps -ef | grep -w "$JAR_NAME" | grep -w "java" | grep -v "grep" | wc -l`
  if [ $P_ID_COUNT != 0 ];then
   echo "=== stop $SERVICE_NAME begin by (kill -15) failed. begin kill -9 $SERVICE_NAME process, pid is:$P_ID"
            kill -9 $P_ID
            echo "${APP_NAME} is not running"
  fi
else
echo "${APP_NAME} is not running"
fi
}


#检查程序是否在运行
is_exist(){
pid=`ps -ef | grep -w "$JAR_NAME" | grep -w "java" | grep -v "grep" | awk '{print $2}'`
#如果不存在返回1，存在返回0
if [ -z "${pid}" ]; then
return 1
else
return 0
fi
}

#输出运行状态
status(){
is_exist
if [ $? -eq "0" ]; then
echo "${APP_NAME} is running. Pid is ${pid}"
else
echo "${APP_NAME} is NOT running."
fi
}

#重启
restart(){
stop
start
}


#根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
"start")
start
;;
"stop")
stop
;;
"status")
status
;;
"restart")
restart
;;
*)
usage
;;
esac