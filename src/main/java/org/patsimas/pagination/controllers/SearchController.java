package org.patsimas.pagination.controllers;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.patsimas.pagination.domain.NoteDocument;
import org.patsimas.pagination.dto.SearchResultDto;
import org.patsimas.pagination.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping(value = "/search/{prefix}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Set<SearchResultDto> autoSearch(@PathVariable String prefix) {
        log.info("Autocomplete begins");

        if (StringUtils.isEmpty(prefix)) {
            return Collections.emptySet();
        }
        String[] searchTerms = prefix.split(" ");

        List<String> terms = Arrays.stream(searchTerms).collect(Collectors.toList());

        List<NoteDocument> result = searchService.search(terms);

        Set<SearchResultDto> titles = new LinkedHashSet<>();

        if (!ObjectUtils.isEmpty(result)) {

            result.stream().map(noteDocument -> titles.add(buildSearchResultDto(noteDocument.getId(),
                    noteDocument.getUserId(), noteDocument.getTitle(), noteDocument.getBody())))
                    .collect(Collectors.toSet());
        }
        log.info("Autocomplete ends");
        return titles;
    }

    private SearchResultDto buildSearchResultDto(String id, String userId, String title,
                                                             String body) {
        return SearchResultDto
                .builder()
                .id(id)
                .userId(userId)
                .title(title)
                .body(body)
                .build();
    }
}
