package org.patsimas.pagination.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchResultDto {

    private String id;

    private String userId;

    private String title;

    private String body;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResultDto that = (SearchResultDto) o;
        return title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
