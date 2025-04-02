package kr.co.kwonshzzang.sensordatacollector.kafka;

import kr.co.kwonshzzang.model.avro.SensorData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class KafkaRepository {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(String topic, SensorData sensorData) {
        String key = sensorData.getSensorId() + "|" + sensorData.getTime() + "|" +
                sensorData.getDataType()  + "|" + sensorData.getStatus();

        kafkaTemplate.send(topic, key,sensorData);
        writeLog(topic, key, sensorData);
    }

    private void writeLog(String topic, String key, Object value) {
        log.info("Produced event to topic = {}: key = {} value = {}", topic , key, value);
    }
}
