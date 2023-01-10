package org.example.domain.menu;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Menu {
    @Id
    @Column(length = 30, nullable = false)
    private String menu_name;

    @Column
    private int price;
}
