package br.com.location.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {

    @Id
    private Long id;

    @Column(length = 50)
    private String name;

    private Long population;

}
