package lld.urbancompany;

import java.util.Date;
import java.util.List;

public class UrbanCompany {
}

// Need to implement ://
// 1. createOrder(Service service, Customer customer)
// 2. getAllPreviousServices(Customer)
// Cleaning, Salon, Dishes => concrete services
/*
Entities:
1. Customer
2. ServiceProvider
3. Service
4. enum ServiceType
5. Orders
 */

enum ServiceType {
    CLEANING, SALON, DISHES;
}

class Address {
    private String addressLine1;
    private String city;
    private String state;
    private String country;
    private String pinCode;
}

class Contact {
    private int contactId;
    private String mobileNumber;
    private String alternateNumber;
    private String email;
}

class Comment {
    private int commentId;
    private String description;
    private ServiceProvider serviceProvider;
    private Customer customer;
    private Date date;
}

class ServiceProvider {
    private int providerId;
    private ServiceType serviceType;
    private Address address;
    private Contact contact;
    private double costPerHour;
    private double costPerDay;
    private double rating;
}

abstract class Service {
    private int serviceId;
    private ServiceType serviceType;
    private List<ServiceProvider> serviceProviders;

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}

class CleaningService extends Service {

}

class Customer {
    private int customerId;
    private String name;
    private String email;
    private Contact contact;
    private Address address;
}

enum OrderStatus {
    REQUESTED, ON_SERVICE, COMPLETED;
}

class Order {
    private int orderId;
    private Customer customer;
    private ServiceProvider serviceProvider;
    private Service service;
    private Date orderDate;
    private OrderStatus status;
}

class OrderService {
    private Order createOrder(Customer customer, ServiceType serviceType) {
        return null;
    }
}