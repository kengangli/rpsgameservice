package com.rpsgame.rpsrestservice.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String player;

    @NonNull private String result;
    @NonNull private String playerChoice;
    @NonNull private String hostChoice;

}
