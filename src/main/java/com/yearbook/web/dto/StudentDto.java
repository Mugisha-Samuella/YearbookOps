package com.yearbook.web.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder

public class StudentDto {
    private Long id;
    private String photourl;
    private String name;
    private String quote;
    private LocalDateTime createdon;
    private LocalDateTime updatedon;
}
