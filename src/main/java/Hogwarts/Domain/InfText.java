package Hogwarts.Domain;

import javax.persistence.*;

@Entity
@Table(name = "INF_TEXT")
public class InfText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "menu_tab_name")
    private String menuTabName;
    @Column(name = "inf_text")
    private String infText;

    public InfText(String menuTabName, String infText) {
        this.menuTabName = menuTabName;
        this.infText = infText;
    }

    public InfText() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuTabName() {
        return menuTabName;
    }

    public void setMenuTabName(String menuTabName) {
        this.menuTabName = menuTabName;
    }

    public String getInfText() {
        return infText;
    }

    public void setInfText(String infText) {
        this.infText = infText;
    }
}
