package Hogwarts.Domain;

import javax.persistence.*;

@Entity
@Table(name = "ROOM_PASS")
public class RoomPass {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Integer id;
        private String name;
        @Column(name = "room_password")
        private String roomPassword;

        public RoomPass(String name, String room_password){
            this.name = name;
            this.roomPassword = room_password;
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomPassword() {
        return roomPassword;
    }

    public void setRoomPassword(String roomPassword) {
        this.roomPassword = roomPassword;
    }
}
