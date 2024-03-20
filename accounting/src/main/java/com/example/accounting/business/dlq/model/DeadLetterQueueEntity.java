package com.example.accounting.business.dlq.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dead_letter_queue")
@Data
public class DeadLetterQueueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "topic")
    private String topic;
    @Column(name = "consumer_record")
    private byte[] consumerRecord;
    @Column(name = "json", length = 4056)
    private String json;
}
