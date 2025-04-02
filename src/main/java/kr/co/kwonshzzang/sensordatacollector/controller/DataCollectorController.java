package kr.co.kwonshzzang.sensordatacollector.controller;

import kr.co.kwonshzzang.sensordatacollector.dto.SensorDataDto;
import kr.co.kwonshzzang.sensordatacollector.service.DataCollectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DataCollectorController {
    private final DataCollectService dataCollectService;

    @PostMapping("/sensordata")
    public void addSensorData(@RequestBody SensorDataDto sensorDataDto) {
        dataCollectService.doService(sensorDataDto);
    }

}
