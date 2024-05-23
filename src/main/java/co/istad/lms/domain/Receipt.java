package co.istad.lms.domain;

import co.istad.lms.config.jpa.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "receipts")
public class Receipt extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column( columnDefinition = "TEXT")
    private String remarks;

    @Column( nullable = false)
    private Boolean isDeleted;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
