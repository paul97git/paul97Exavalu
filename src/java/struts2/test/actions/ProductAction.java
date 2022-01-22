/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2.test.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import struts2.test.beans.Product;
import struts2.test.dao.Products;


/**
 *
 * @author paulomi
 */
public class ProductAction extends ActionSupport{
    
      private int productId;
    private String productName;
    private String productMake;
    private double price;
    private int availability;
   
    
     private static long serialVersionUID = 6329394260276112660L;
    private ResultSet rs = null;
    private Product product = null;
    private List<Product> productList = null;
    
    
  
    private Products dao = new Products();
    private String submitType;
    
    
    private boolean noData = false;

    private String msg = "";
    private Products pdt = null;
    private int ctr = 0;
    
    public String registerProduct(){
        
        setPdt(new Products());

        try {
            setCtr(getPdt().registerProduct(productId,productName,productMake,price,availability));
            if (getCtr() > 0) {
                setMsg("Registration Successfull");
            } else {
                setMsg("Some error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REGISTER";
    }
    
    public String reportProduct(){
        Products dao = new Products();
         try {
            setProductList(new ArrayList<>());
            setProductList(dao.reportProduct());
            

            if (!productList.isEmpty() ) {
                setNoData(false);
                System.out.println("Products retrieve = "+getProductList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REPORT";
    }
    
    public String updateProduct(){
        try {
            if (getSubmitType().equals("updatedata")) {
                Product product = getDao().fetchProductDetails(productId);
                if (product != null) {
                    setProductId(product.getProductId());
                    setProductName(product.getProductName());
                    setProductMake(product. getProductMake());
                    setPrice(product.getPrice());
                    setAvailability(product.getAvailability());
                    
                }
            } else {System.out.println(productId);
                 setCtr(getDao().updateProduct(productId,productName,productMake,price,availability));
                if (getCtr() > 0) {
                    setMsg("Record Updated Successfuly");
                } else {
                    setMsg("error");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATE";
    }
    
    
    public String deleteProduct(){
         try {
            int isDeleted = getDao().deleteProductDetails(productId);
            if (isDeleted > 0) {
                setMsg("Record deleted successfully");
            } else {
                setMsg("Some error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DELETE";
    }

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productMake
     */
    public String getProductMake() {
        return productMake;
    }

    /**
     * @param productMake the productMake to set
     */
    public void setProductMake(String productMake) {
        this.productMake = productMake;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the availability
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the productList
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * @return the dao
     */
    public Products getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(Products dao) {
        this.dao = dao;
    }

    /**
     * @return the submitType
     */
    public String getSubmitType() {
        return submitType;
    }

    /**
     * @param submitType the submitType to set
     */
    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

    /**
     * @return the noData
     */
    public boolean isNoData() {
        return noData;
    }

    /**
     * @param noData the noData to set
     */
    public void setNoData(boolean noData) {
        this.noData = noData;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the pdt
     */
    public Products getPdt() {
        return pdt;
    }

    /**
     * @param pdt the pdt to set
     */
    public void setPdt(Products pdt) {
        this.pdt = pdt;
    }

    /**
     * @return the ctr
     */
    public int getCtr() {
        return ctr;
    }

    /**
     * @param ctr the ctr to set
     */
    public void setCtr(int ctr) {
        this.ctr = ctr;
    }
    
    
}
