package org.patsimas.pagination.domain;

import lombok.*;
import org.apache.solr.client.solrj.beans.Field;
import org.patsimas.pagination.services.SearchableNoteDefinition;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Getter
@Setter
@SolrDocument(collection = "notes")
public class NoteDocument {

    @Id
    @Indexed(name = SearchableNoteDefinition.ID, type = "string")
    @Field
    private String id;

    @Indexed(name = SearchableNoteDefinition.USER_ID, type = "string", stored = false)
    @Field
    private String userId;

    @Indexed(name = SearchableNoteDefinition.TITLE, type = "string", stored = false)
    @Field
    private String title;

    @Indexed(name = SearchableNoteDefinition.BODY, type = "string", stored = false)
    @Field
    private String body;
}
