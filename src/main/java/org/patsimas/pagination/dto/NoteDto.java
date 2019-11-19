package org.patsimas.pagination.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {

    private Integer id;

    private Integer userId;

    private String title;

    private String body;
}
