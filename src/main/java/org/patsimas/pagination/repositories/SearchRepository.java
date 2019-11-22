package org.patsimas.pagination.repositories;

import org.patsimas.pagination.domain.NoteDocument;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends SolrCrudRepository<NoteDocument, String> {

    List<NoteDocument> findByTitleStartingWith(List<String> title);
}
