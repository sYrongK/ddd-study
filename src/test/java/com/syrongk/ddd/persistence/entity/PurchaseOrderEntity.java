package com.syrongk.ddd.persistence.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrderEntity {
    @Id
    @Column(name = "order_number")
    private String orderNumber;
    
    @Column(name = "version")
    private Long version;
    
    @Column(name = "orderer_id")
    private String ordererId;
    
    @Column(name = "orderer_name")
    private String ordererName;
    
    @Column(name = "total_amounts")
    private Integer totalAmounts;
    
    @Column(name = "shipping_zip_code")
    private String shippingZipCode;
    
    @Column(name = "shipping_addr1")
    private String shippingAddr1;
    
    @Column(name = "shipping_addr2")
    private String shippingAddr2;
    
    @Column(name = "shipping_message")
    private String shippingMessage;
    
    @Column(name = "receiver_name")
    private String receiverName;
    
    @Column(name = "receiver_phone")
    private String receiverPhone;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "order_date")
    private Timestamp orderDate;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getOrdererId() {
        return ordererId;
    }

    public void setOrdererId(String ordererId) {
        this.ordererId = ordererId;
    }

    public String getOrdererName() {
        return ordererName;
    }

    public void setOrdererName(String ordererName) {
        this.ordererName = ordererName;
    }

    public Integer getTotalAmounts() {
        return totalAmounts;
    }

    public void setTotalAmounts(Integer totalAmounts) {
        this.totalAmounts = totalAmounts;
    }

    public String getShippingZipCode() {
        return shippingZipCode;
    }

    public void setShippingZipCode(String shippingZipCode) {
        this.shippingZipCode = shippingZipCode;
    }

    public String getShippingAddr1() {
        return shippingAddr1;
    }

    public void setShippingAddr1(String shippingAddr1) {
        this.shippingAddr1 = shippingAddr1;
    }

    public String getShippingAddr2() {
        return shippingAddr2;
    }

    public void setShippingAddr2(String shippingAddr2) {
        this.shippingAddr2 = shippingAddr2;
    }

    public String getShippingMessage() {
        return shippingMessage;
    }

    public void setShippingMessage(String shippingMessage) {
        this.shippingMessage = shippingMessage;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseOrderEntity that = (PurchaseOrderEntity) o;
        return Objects.equals(orderNumber, that.orderNumber) && Objects.equals(version, that.version) && Objects.equals(ordererId, that.ordererId) && Objects.equals(ordererName, that.ordererName) && Objects.equals(totalAmounts, that.totalAmounts) && Objects.equals(shippingZipCode, that.shippingZipCode) && Objects.equals(shippingAddr1, that.shippingAddr1) && Objects.equals(shippingAddr2, that.shippingAddr2) && Objects.equals(shippingMessage, that.shippingMessage) && Objects.equals(receiverName, that.receiverName) && Objects.equals(receiverPhone, that.receiverPhone) && Objects.equals(state, that.state) && Objects.equals(orderDate, that.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, version, ordererId, ordererName, totalAmounts, shippingZipCode, shippingAddr1, shippingAddr2, shippingMessage, receiverName, receiverPhone, state, orderDate);
    }
}
