package com.jodlowski.easynotesapi.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "list_content")
public class ListContent implements NoteContent<List<String>> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long contentId;
    @ElementCollection
    @CollectionTable(name="list_items", joinColumns=@JoinColumn(name="content_id"))
    @Column(name="list_content")
    private List<String> content;
    @Transient
    private final ContentType CONTENT_TYPE = ContentType.LIST_CONTENT;
    @OneToOne
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

    public ListContent() {};

    public ListContent(Long contentId, List<String> content, Note note) {
        this.contentId = contentId;
        this.content = content;
        this.note = note;
    }

    @Override
    public Long getContentId() {
        return this.contentId;
    }

    @Override
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }
    @Override

    public List<String> getContent() {
        return this.content;
    }

    @Override
    public void setContent(List<String> content) {
        this.content = content;
    }

    @Override
    public ContentType getContentType() {
        return this.CONTENT_TYPE;
    }

    @Override
    public Note getNote() {
        return note;
    }

    @Override
    public void setNote(Note note) {
        this.note = note;
    }
}