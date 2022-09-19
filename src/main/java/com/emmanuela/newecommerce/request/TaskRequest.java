package com.emmanuela.newecommerce.request;

import com.emmanuela.newecommerce.enums.TaskStatus;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class TaskRequest {
    private String title;
    private String description;
    private TaskStatus status;
}
