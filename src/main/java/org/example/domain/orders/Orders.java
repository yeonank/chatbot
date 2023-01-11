package org.example.domain.orders;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.menu.Menu;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int count;

    @Column
    private Boolean delivery;

    @Column(length = 50)
    private String address;

    /*@Column(length = 30)
    private String menu_intent;*/
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_NAME")
    private Menu menu;

    @Builder
    public Orders(int count, Boolean delivery, String address, Menu menu){
        this.count = count;
        this.delivery = delivery;
        this.address = address;
        this.menu = menu;
    }

    public void updateMenu(Menu menu) {
        this.menu = menu;
    }
}
