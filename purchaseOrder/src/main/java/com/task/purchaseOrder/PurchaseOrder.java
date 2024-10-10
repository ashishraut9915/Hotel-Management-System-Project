package com.task.purchaseOrder;

import java.util.Date;

public class PurchaseOrder {
    private String orderNumber;
    private Date creationDate;
    private String vendorName;
    private String productCode;
    private String productName;
    private double quantityOrdered;
    private String orderedBy;
    private Date lastUpdatedDate;
    private String status;
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(double quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	public String getOrderedBy() {
		return orderedBy;
	}
	public void setOrderedBy(String orderedBy) {
		this.orderedBy = orderedBy;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [orderNumber=" + orderNumber + ", creationDate=" + creationDate + ", vendorName="
				+ vendorName + ", productCode=" + productCode + ", productName=" + productName + ", quantityOrdered="
				+ quantityOrdered + ", orderedBy=" + orderedBy + ", lastUpdatedDate=" + lastUpdatedDate + ", status="
				+ status + "]";
	}

}
