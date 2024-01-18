package com.accenture.academy.leader;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class LeaderDto {

    @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$",
            message = "Name must be of 6 to 12 length with no special characters")
    private String name;
    private Integer age;
}
