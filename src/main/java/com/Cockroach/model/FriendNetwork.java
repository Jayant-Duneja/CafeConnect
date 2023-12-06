package com.Cockroach.model;

import javax.persistence.*;
import com.Cockroach.RequestStatus;

@Entity
@Table(name = "friend_network")
public class FriendNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "student_id")
    private Student sender;

    @ManyToOne
    @JoinColumn(name = "recipient_id", referencedColumnName = "student_id")
    private Student recipient;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    public FriendNetwork() {}

    public FriendNetwork(Student sender, Student recipient, RequestStatus status) {
        this.sender = sender;
        this.recipient = recipient;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getSender() {
        return sender;
    }

    public void setSender(Student sender) {
        this.sender = sender;
    }

    public Student getRecipient() {
        return recipient;
    }

    public void setRecipient(Student recipient) {
        this.recipient = recipient;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
