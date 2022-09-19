package com.emmanuela.newecommerce.entities;

import com.emmanuela.newecommerce.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tasks")
public class Task extends BaseClass{

    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private  LocalDateTime completedAt;
    @JsonIgnore
    @ManyToOne
    private Users user1;
}
