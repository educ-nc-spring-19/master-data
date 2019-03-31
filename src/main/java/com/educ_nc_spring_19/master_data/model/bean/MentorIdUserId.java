package com.educ_nc_spring_19.master_data.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor

public class MentorIdUserId {
    private UUID id;
    private UUID userId;
}
