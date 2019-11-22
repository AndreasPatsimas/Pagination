package org.patsimas.pagination.services;

import lombok.extern.slf4j.Slf4j;
import org.patsimas.pagination.domain.NoteDocument;
import org.patsimas.pagination.repositories.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Override
    public List<NoteDocument> search(List<String> prefix) {

        if (StringUtils.isEmpty(prefix)) {
            return null;
        }

        return searchRepository.findByTitleStartingWith(prefix);
    }
}
