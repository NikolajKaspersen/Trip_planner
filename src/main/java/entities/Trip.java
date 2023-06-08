package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    //    @Temporal(TemporalType.DATE)
    private String date; //TODO: Change to Date java.util.Date
    //    @Temporal(TemporalType.TIME)
    private String time; //TODO: Change to Time java.util.Time
    private String location;
    private String duration;
    private String packinglist;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Guide guide;
    private Long guideId;

//    @JoinTable(name = "trip_user", joinColumns = {
//            @JoinColumn(name = "trip_id", referencedColumnName = "id"),
//            @JoinColumn(name = "guide_id", referencedColumnName = "guide_id")}, inverseJoinColumns = {
//            @JoinColumn(name = "user_name", referencedColumnName = "user_name")})

    @ManyToMany(mappedBy = "trips", cascade = CascadeType.PERSIST)
    private List<User> users;

//    public void addUser(User user) {
//        if (user != null) {
//            this.users.add(user);
//            user.addTrip(this);
//        }
//    }

    public List<String> usersOnTrip() {
        if (users.isEmpty()) {
            return null;
        }
        List<String> usersByName = new ArrayList<>();
        users.forEach((user) -> {
            usersByName.add(user.getUserName());
        });
        return usersByName;
    }

    public Trip() {
    }

    public Trip(String name, String date, String time, String location, String duration, String packinglist, Long guideId) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.duration = duration;
        this.packinglist = packinglist;
        this.guideId = guideId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPackinglist() {
        return packinglist;
    }
    public void setPackinglist(String packinglist) {
        this.packinglist = packinglist;
    }

    public Guide getGuide() {
        return guide;
    }
    public void addGuide(Long guideid) {
        this.guideId = guideid;
    }

    public List<User> getUsers() {
        return users;
    }
    public void setUserList(List<User> users) {
        this.users = users;
    }
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", duration='" + duration + '\'' +
                ", packinglist='" + packinglist + '\'' +
                ", guideId=" + guideId +
                '}';
    }
}