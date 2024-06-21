package com.core.DataProvider.measurement;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MeasuramentRepository extends MongoRepository<Measurement,String>{
    List<Measurement> findByFromDeviceOrderByTimestampDesc(String fromDevice);
}
