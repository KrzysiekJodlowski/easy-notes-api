package com.jodlowski.easynotesapi.model;

import org.hibernate.annotations.Type;
import javax.persistence.*;


@Entity
@Table(name = "image_content")
public class ImageContent implements NoteContent<byte[]> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long contentId;
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "image_content")
    private byte[] content;
    @Transient
    private final ContentType CONTENT_TYPE = ContentType.IMAGE_CONTENT;
    @OneToOne
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

    public ImageContent() {};

    public ImageContent(Long contentId, byte[] content, Note note) {
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
    public byte[] getContent() {
        return this.content;
    }

    @Override
    public void setContent(byte[] content) {
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