package org.patsimas.pagination.services;

import org.patsimas.pagination.dto.NoteDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface NoteService {

    Page<NoteDto> findNoteByCondition(String orderBy, String direction, int page, int size);
}
