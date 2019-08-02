package com.jodlowski.easynotesapi.model;

import javax.persistence.*;


@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long noteId;
    private String title;
    private String color;
    @ManyToOne
    @JoinColumn(name = "tab_id", nullable = false)
    private NotesTab notesTab;

    public Note() {}

    public Note(Long noteId, String title, String color, NotesTab notesTab) {
        this.noteId = noteId;
        this.title = title;
        this.color = color;
        this.notesTab = notesTab;
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public NotesTab getNotesTab() { return notesTab; }

    public void setNotesTab(NotesTab notesTab) {
        this.notesTab = notesTab;
    }
}
