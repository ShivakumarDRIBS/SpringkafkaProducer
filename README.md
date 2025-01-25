This was tested using Opensource apache kafka
You can download apache kafka from below link
https://kafka.apache.org/downloads

You can download zip file, copy to local folder
You can use below commands which was tested in windows
1. command to start zookeeper from kafka root folder, default port it runs in 2181
   .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
2. command to start kafka server from kafka root folder, default port is 9092
   .\bin\windows\kafka-server-start.bat .\config\server.properties
3. command to create topics from console
   kafka-topics.bat --bootstrap-server <<kafkaserverhostmachine:kafkaserverport>> --create --topic <<giveurtopicname>> --partitions 3 --replication-factor 1
   kafka-topics.bat --bootstrap-server localhost:9092 --create --topic shiva-topic --partitions 3 --replication-factor 1

4. Below command can be used to send messages using CLI without any code
   kafka-console-producer.bat --broker-list localhost:9092 --topic shiva-topic

5. Below command can be used to check messages coming to topic without any code
   kafka-console-producer.bat --broker-list localhost:9092 --topic shiva-topic
