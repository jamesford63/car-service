package server.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "workerSeq", sequenceName = "workers_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workerSeq")
    private long id;
    @NotNull
    @Column(name = "login")
    private String login;
    @NotNull
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "fname")
    private String fname;
    @Column(name = "phone_number")
    private long pnumber;
    @Column(name = "city")
    private String city;
    @Column(name = "rating")
    private int rating;
    @Column(name = "status")
    private int status;
    @JsonIgnore
    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private Set<Service> serviceSet;
    @JsonIgnore
    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private Set<Passport> passportSet;
    @JsonIgnore
    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private Set<Order> orderSet;

    public Worker() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public long getPnumber() {
        return pnumber;
    }

    public void setPnumber(long number) {
        this.pnumber = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<Service> getServiceSet() {
        return serviceSet;
    }

    public void setServiceSet(Set<Service> serviceSet) {
        this.serviceSet = serviceSet;
    }

    public Set<Passport> getPassportSet() {
        return passportSet;
    }

    public void setPassportSet(Set<Passport> passportSet) {
        this.passportSet = passportSet;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", fname='" + fname + '\'' +
                ", number=" + pnumber +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return id == worker.id &&
                pnumber == worker.pnumber &&
                rating == worker.rating &&
                status == worker.status &&
                Objects.equals(login, worker.login) &&
                Objects.equals(password, worker.password) &&
                Objects.equals(name, worker.name) &&
                Objects.equals(fname, worker.fname) &&
                Objects.equals(city, worker.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password, name, fname, pnumber, city, rating, status);
    }
}