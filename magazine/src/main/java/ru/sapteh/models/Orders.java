package ru.sapteh.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "orders")
public class Orders {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String cost;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "client_id")
    private Client client;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "product_id")
    private Product product;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", cost='" + cost + '\'' +
                ", client=" + client +
                ", product=" + product +
                '}';
    }
}
