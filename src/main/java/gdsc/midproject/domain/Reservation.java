package gdsc.midproject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_name")
    private User user;

    @Column(nullable = false)
    private LocalDateTime start;

    @Column(nullable = false)
    private LocalDateTime end;

    @Column(nullable = false)
    private int userCnt;

    @OneToOne
    @JoinColumn(name = "Studyroom_id")
    private Studyroom studyroom;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public Reservation(Long id, User username, LocalDateTime start, LocalDateTime end, int userCnt, Studyroom studyroom, Status status) {
        this.id = id;
        this.user = username;
        this.start = start;
        this.end = end;
        this.studyroom = studyroom;
        this.status = status;
    }
}
