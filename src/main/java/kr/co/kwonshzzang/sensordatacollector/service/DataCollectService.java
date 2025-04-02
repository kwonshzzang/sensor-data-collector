package kr.co.kwonshzzang.sensordatacollector.service;

import kr.co.kwonshzzang.sensordatacollector.dto.SensorDataDto;
import kr.co.kwonshzzang.sensordatacollector.kafka.KafkaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataCollectService {
    private final KafkaRepository kafkaRepository;

    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;

    public void doService(SensorDataDto sensorDataDto) {
        kafkaRepository.send(defaultTopic, sensorDataDto.toConverseData());
    }
}
