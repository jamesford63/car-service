package server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UriComponentsBuilder;
import server.jpa.Order;
import server.jpa.OrderRepository;

import java.util.List;

@Controller
@CrossOrigin(origins = {"http://localhost:4200"})
public class OrderController extends WebMvcConfigurerAdapter {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = (List<Order>) orderRepository.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<Void> postOrder(@RequestBody Order order, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/order").build().toUri());
        orderRepository.save(order);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/orderbyclient", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getOrderByClientLogin(@RequestParam("login") String login) {
        List<Order> orders = (List<Order>) orderRepository.findOrderByClientLogin(login);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @RequestMapping(value = "/orderbyworker", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getOrderByWorkerLogin(@RequestParam("login") String login) {
        List<Order> orders = (List<Order>) orderRepository.findOrderByWorkerLogin(login);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @RequestMapping(value = "/orderbycarid", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getOrderByCarId(@RequestParam("id") long id) {
        List<Order> orders = (List<Order>) orderRepository.findOrderByCarId(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping(value = "/orderupdate")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        Order sourceOrder;
        sourceOrder = orderRepository.findOne(order.getId());
        if(sourceOrder == order)
            return new ResponseEntity<Order>(HttpStatus.CONFLICT);
        orderRepository.save(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteorder")
    public ResponseEntity<Void> deleteOrder(@RequestParam long id){
        orderRepository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}