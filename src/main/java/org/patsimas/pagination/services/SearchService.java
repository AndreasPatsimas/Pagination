package org.patsimas.pagination.services;

import org.patsimas.pagination.domain.NoteDocument;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchService {

    List<NoteDocument> search(List<String> prefix);
}
