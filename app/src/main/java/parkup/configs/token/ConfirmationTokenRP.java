package parkup.configs.token;

import parkup.entities.RegistriranParkirac;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ConfirmationTokenRP {

    @Id
    @Column(name = "confirmation_token_id")
    @SequenceGenerator(
            name="confirmation_token_sequence_generator_RP",
            sequenceName = "confirmation_token_sequence_RP",
            allocationSize = 1,
            initialValue = 1100
    )
    @GeneratedValue(    //za postgres treba sequence da se namesti i ime na generator mi ga davamo kako od gore sto e
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence_generator_RP"
    )
    private int id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(nullable = false, name = "registriranParkirac_id")
    //many confirmation tokens to one registriranParkirac
    private RegistriranParkirac registriranParkirac;

    public ConfirmationTokenRP() {}

    public ConfirmationTokenRP(int id, String token, LocalDateTime createdAt, LocalDateTime expiresAt, RegistriranParkirac registriranParkirac) {
        this.id = id;
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.registriranParkirac = registriranParkirac;
    }

    public ConfirmationTokenRP(String token, LocalDateTime createdAt, LocalDateTime expiresAt, RegistriranParkirac registriranParkirac) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.registriranParkirac = registriranParkirac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public LocalDateTime getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(LocalDateTime confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public RegistriranParkirac getRegistriranParkirac() {
        return registriranParkirac;
    }

    public void setRegistriranParkirac(RegistriranParkirac registriranParkirac) {
        this.registriranParkirac = registriranParkirac;
    }
}
