package org.patsimas.pagination.controllers;


import lombok.extern.slf4j.Slf4j;
import org.patsimas.pagination.dto.NoteDto;
import org.patsimas.pagination.enums.Direction;
import org.patsimas.pagination.enums.OrderBy;
import org.patsimas.pagination.exceptions.PaginationSortingException;
import org.patsimas.pagination.exceptions.PagingSortingErrorResponse;
import org.patsimas.pagination.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class NoteController {

    @Autowired
    NoteService noteService;


    @GetMapping(value = "/conditionalPagination", params = { "orderBy", "direction", "page",
            "size" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<NoteDto> findNotesByPageAndSize(@RequestParam("orderBy") String orderBy,
                                                   @RequestParam("direction") String direction, @RequestParam("page") int page,
                                                   @RequestParam("size") int size) {

        log.info("Getting all notes");

        if (!(direction.equals(Direction.ASCENDING.code())
                || direction.equals(Direction.DESCENDING.code()))) {
            throw new PaginationSortingException("Invalid sort direction");
        }
        if (!(orderBy.equals(OrderBy.ID.code()) || orderBy.equals(OrderBy.USERID.code()))) {
            throw new PaginationSortingException("Invalid orderBy condition");
        }

        return noteService.findNoteByCondition(orderBy, direction, page, size);
    }
    @ExceptionHandler(PaginationSortingException.class)
    public ResponseEntity<PagingSortingErrorResponse> exceptionHandler(Exception ex) {

        PagingSortingErrorResponse pagingSortingErrorResponse = new PagingSortingErrorResponse();

        pagingSortingErrorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());

        pagingSortingErrorResponse.setMessage(ex.getMessage());

        return new ResponseEntity<PagingSortingErrorResponse>(pagingSortingErrorResponse, HttpStatus.OK);
    }
}
