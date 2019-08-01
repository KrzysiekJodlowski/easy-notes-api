package com.jodlowski.easynotesapi.model;

import javax.persistence.*;

@Entity
@Table(name = "notes_tab")
public class NotesTab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tab_id")
    private Long tabId;
    private String title;
    private String color;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public NotesTab() {};

    public NotesTab(Long tabId, String title, String color, User user) {
        this.tabId = tabId;
        this.title = title;
        this.color = color;
        this.user = user;
    }

    public Long getTabId() { return tabId; }

    public void setTabId(Long tabId) {
        this.tabId = tabId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
