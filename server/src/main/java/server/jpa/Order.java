package server.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "orderSeq", sequenceName = "orders_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSeq")
    private long id;
    @Column(name = "client_mark")
    private double clientMark;
    @Column(name = "worker_mark")
    private double workerMark;
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "service_type")
    private String serviceType;
    @Column(name = "total_price")
    private int totalPrice;
    @Column(name = "status")
    private int status;
    @ManyToOne
    @JsonIgnore
    private Client client;
    @ManyToOne
    @JsonIgnore
    private Worker worker;
    @ManyToOne
    @JsonIgnore
    private Car car;

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getClientMark() {
        return clientMark;
    }

    public void setClientMark(double clientMark) {
        this.clientMark = clientMark;
    }

    public double getWorkerMark() {
        return workerMark;
    }

    public void setWorkerMark(double workerMark) {
        this.workerMark = workerMark;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientMark=" + clientMark +
                ", workerMark=" + workerMark +
                ", orderDate=" + orderDate +
                ", serviceType='" + serviceType + '\'' +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", client=" + client.getLogin() +
                ", worker=" + worker.getLogin() +
                ", car=" + car.getId() +
                '}';
    }
}