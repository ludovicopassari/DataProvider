package com.core.DataProvider.device;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends MongoRepository<Device, String> {
    public  Optional<Device> findByDeviceId(String deviceId);
    public  Optional<List<Device>> findDeviceByUserId(String userId);

    @Query(value = "{ 'userId' : ?0 }", fields = "{ 'name' : 1, '_id' : 0 }")
    public  Optional<List<Device>> findByUserIdAndType(String userId);

}
