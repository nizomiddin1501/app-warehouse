package uz.developers.appwarehouse.service;

import uz.developers.appwarehouse.entity.Measurement;
import uz.developers.appwarehouse.payload.InputDto;
import uz.developers.appwarehouse.payload.Result;

import java.util.List;

public interface MeasurementService {

    List<Measurement> getMeasurements();

    Measurement getMeasurement(Integer id);

    Result addMeasurement(Measurement measurement);

    Result editMeasurement(Integer id, Measurement measurement);

    Result deleteMeasurement(Integer id);
}
