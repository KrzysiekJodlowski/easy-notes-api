package com.jodlowski.easynotesapi.model;

import javax.persistence.*;


@Entity
@Table(name = "text_content")
public class TextContent implements NoteContent<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long contentId;
    @Column(name = "text_content")
    private String content;
    @Transient
    private final ContentType CONTENT_TYPE = ContentType.TEXT_CONTENT;
    @OneToOne
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

    public TextContent() {};

    public TextContent(Long noteContentId, String content, Note note) {
        this.contentId = noteContentId;
        this.content = content;
        this.note = note;
    }

    @Override
    public Long getContentId() {
        return contentId;
    }

    @Override
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public void setContent(String content) {
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
