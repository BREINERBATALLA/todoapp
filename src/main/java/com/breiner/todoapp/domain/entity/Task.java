package com.breiner.todoapp.domain.entity;

import com.breiner.todoapp.domain.enumeration.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "description", nullable = true, length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status state;

    public Task() {
        this.state = Status.PENDING;
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.state = Status.PENDING;
    }

}
