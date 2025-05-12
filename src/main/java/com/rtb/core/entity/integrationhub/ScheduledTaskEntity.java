package com.rtb.core.entity.integrationhub;

import com.rtb.core.enums.TaskStatus;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;

@Document(collection = "scheduled_tasks")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScheduledTaskEntity {

    @Id
    private String id;

    private String taskId;

    private String taskName;

    private Instant startTime;

    @Nullable
    private Instant endTime;

    private TaskStatus status;

    private Map<String, Object> metadata;

    @Nullable
    private Map<String, Object> nextMetadata;

    public ScheduledTaskEntity(String taskId, String taskName, Instant startTime, Instant endTime,
                               TaskStatus status, Map<String, Object> metadata) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.metadata = metadata;
    }
}

