package com.rtb.core.repository;

import com.rtb.core.entity.integrationhub.ScheduledTaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ScheduledTaskRepository extends MongoRepository<ScheduledTaskEntity, String> {

    @Query(value = "{'taskId': ?0, 'status': 'SUCCESS'}", sort = "{'endTime': -1}")
    ScheduledTaskEntity findTopByTaskIdAndStatusSuccess(String taskId);
}
