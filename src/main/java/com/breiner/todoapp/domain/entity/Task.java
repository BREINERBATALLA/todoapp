package com.breiner.todoapp.domain.entity;

import com.breiner.todoapp.domain.enumeration.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "task")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status state;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    public Task() {
        this.state = Status.PENDING;
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.state = Status.PENDING;
    }

}
