package uz.developers.appwarehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.appwarehouse.entity.Measurement;
import uz.developers.appwarehouse.payload.InputDto;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.repository.MeasurementRepository;
import uz.developers.appwarehouse.service.MeasurementService;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementServiceImpl implements MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    @Override
    public List<Measurement> getMeasurements() {
       return measurementRepository.findAll();
    }

    @Override
    public Measurement getMeasurement(Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()) {
            return optionalMeasurement.get();
        }
        return new Measurement();
    }
    @Override
    public Result addMeasurement(Measurement measurement) {
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName) {
            return new Result("This measurement already exist",false);
        }
        measurementRepository.save(measurement);
        return new Result("Measurement is saved successly",true);
    }

    @Override
    public Result editMeasurement(Integer id, Measurement measurement) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isEmpty()) {
            return new Result("There is not such measurement",false);
        }
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName) {
            return new Result("This measurement already exist",false);
        }
        Measurement savedMeasurement = optionalMeasurement.get();
        savedMeasurement.setName(measurement.getName());
        measurementRepository.save(savedMeasurement);
        return new Result("Measurement is saved",true);
    }

    @Override
    public Result deleteMeasurement(Integer id) {
        measurementRepository.deleteById(id);
        return new Result("Measurement is deleted",true);
    }
}
