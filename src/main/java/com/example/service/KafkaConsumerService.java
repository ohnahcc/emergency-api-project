package com.example.service;

import com.example.entity.HospitalBedAvailability;
import com.example.secondrepository.SecondHospitalBedAvailabilityRepository;
import com.example.secondrepository.SecondHospitalBedAvailabilityRateRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class KafkaConsumerService {

    private final SecondHospitalBedAvailabilityRepository repository;

    public KafkaConsumerService(SecondHospitalBedAvailabilityRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "hospital-bed-availability", groupId = "hospital-group")
    @Transactional("secondTransactionManager")
    public void consume(HospitalBedAvailability data) {
        int utilizationRate = calculateUtilizationRate(data);
        repository.saveOrUpdate(
                data.getHospitalId(),
                data.getHvec(),
                data.getHvoc(),
                data.getHvcc(),
                data.getHvncc(),
                data.getHvccc(),
                data.getHvicc(),
                data.getHvgc(),
                data.getHv2(),
                data.getHv3(),
                data.getHv4(),
                data.getHv5(),
                data.getHv6(),
                data.getHv7(),
                data.getHv8(),
                data.getHv9(),
                data.getHv10(),
                data.getHv11(),
                data.getHv13(),
                data.getHv14(),
                data.getHv15(),
                data.getHv16(),
                data.getHv17(),
                data.getHv18(),
                data.getHv19(),
                data.getHv21(),
                data.getHv22(),
                data.getHv23(),
                data.getHv24(),
                data.getHv25(),
                data.getHv26(),
                data.getHv27(),
                data.getHv28(),
                data.getHv29(),
                data.getHv30(),
                data.getHv31(),
                data.getHv32(),
                data.getHv33(),
                data.getHv34(),
                data.getHv35(),
                data.getHv36(),
                data.getHv37(),
                data.getHv38(),
                data.getHv39(),
                data.getHv40(),
                data.getHv41(),
                data.getHv42(),
                data.getHv43(),
                data.getHvctayn(),
                data.getHvmriayn(),
                data.getHvangioayn(),
                data.getHvventiayn(),
                data.getHvventisoayn(),
                data.getHvincuayn(),
                data.getHvcrrtayn(),
                data.getHvecmoayn(),
                data.getHvoxyayn(),
                data.getHvhypoayn(),
                data.getHvamyn(),
                utilizationRate,       // 일반 병상 기준
                data.getHvidate() != null ? data.getHvidate().toString() : null,
                LocalDateTime.now()
        );
    }

    private int calculateUtilizationRate(HospitalBedAvailability data) {
        if (data.getHvs01() != null && data.getHvs01() > 0) {
            return (int) (((data.getHvs01() - data.getHvec()) / data.getHvs01().floatValue()) * 100);
        }
        return 0;
    }
}

