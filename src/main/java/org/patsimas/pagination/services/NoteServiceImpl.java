package org.patsimas.pagination.services;

import lombok.extern.slf4j.Slf4j;
import org.patsimas.pagination.domain.Note;
import org.patsimas.pagination.dto.NoteDto;
import org.patsimas.pagination.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NoteServiceImpl implements NoteService {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    NoteRepository noteRepository;

    @Override
    public Page<NoteDto> findNoteByCondition(String orderBy, String direction, int page, int size) {

        log.info("Get all notes process start");

        Sort sort = null;

        if (direction.equals("ASC")) {
            sort = Sort.by(new Sort.Order(Direction.ASC, orderBy));
        }

        if (direction.equals("DESC")) {
            sort = Sort.by(new Sort.Order(Direction.DESC, orderBy));
        }

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Note> notes = noteRepository.findAll(pageable);

        List<NoteDto> noteDtos = new ArrayList<>(pageable.getPageSize());

        notes.stream()
                .map(note -> noteDtos.add(conversionService.convert(note, NoteDto.class)))
                .collect(Collectors.toList());

        Page<NoteDto> noteDtosPage = new PageImpl<>(noteDtos, pageable, noteDtos.size());

        log.info("Get all notes process end");

        return noteDtosPage;
    }
}
