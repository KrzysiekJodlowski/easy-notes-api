package com.jodlowski.easynotesapi.model;


public interface NoteContent<E> {

    Long getContentId();
    void setContentId(Long contentId);
    E getContent();
    void setContent(E content);
    ContentType getContentType();
    Note getNote();
    void setNote(Note note);
}