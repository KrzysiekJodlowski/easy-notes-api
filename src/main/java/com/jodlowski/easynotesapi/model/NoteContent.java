package com.jodlowski.easynotesapi.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "note_content")
public class NoteContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_content_id")
    private Long noteContentId;
    @Column(name = "text_content")
    private String textContent;
    @ElementCollection
    @CollectionTable(name="List_content", joinColumns=@JoinColumn(name="note_content_id"))
    @Column(name="list_content")
    private List<String> listContent;
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "image_content")
    private byte[] imageContent;
    @Enumerated(EnumType.STRING)
    @Column(name = "content_type")
    private ContentType contentType;
    @OneToOne
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

    public NoteContent() {};

    public NoteContent(Long noteContentId, String textContent, List<String> listContent, byte[] imageContent, ContentType contentType, Note note) {
        this.noteContentId = noteContentId;
        this.textContent = textContent;
        this.listContent = listContent;
        this.imageContent = imageContent;
        this.contentType = contentType;
        this.note = note;
    }

    public Long getNoteContentId() {
        return noteContentId;
    }

    public void setNoteContentId(Long noteContentId) {
        this.noteContentId = noteContentId;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public List<String> getListContent() { return listContent; }

    public void setListContent(List<String> listContent) {
        this.listContent = listContent;
    }

    public byte[] getImageContent() {
        return imageContent;
    }

    public void setImageContent(byte[] imageContent) {
        this.imageContent = imageContent;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
