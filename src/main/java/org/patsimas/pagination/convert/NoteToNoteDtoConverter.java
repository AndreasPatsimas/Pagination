package org.patsimas.pagination.convert;

import org.patsimas.pagination.domain.Note;
import org.patsimas.pagination.dto.NoteDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NoteToNoteDtoConverter implements Converter<Note, NoteDto> {

    @Override
    public NoteDto convert(Note note) {

        return NoteDto.builder()
                .id(note.getId())
                .userId(note.getUserId())
                .title(note.getTitle())
                .body(note.getBody())
                .build();
    }
}
