package entity;

import java.util.Objects;

public class Customer {
    private int idCustomer;
    private String firm;
    private String contactPerson;
    private String telephone;
    private int code;

    public Customer() {
    }

    public Customer(int idCustomer, String firm, String contactPerson, String telephone, int code) {
        this.idCustomer = idCustomer;
        this.firm = firm;
        this.contactPerson = contactPerson;
        this.telephone = telephone;
        this.code = code;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return idCustomer == customer.idCustomer && code == customer.code && firm.equals(customer.firm) && contactPerson.equals(customer.contactPerson) && telephone.equals(customer.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCustomer, firm, contactPerson, telephone, code);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", firm='" + firm + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", telephone='" + telephone + '\'' +
                ", code=" + code +
                '}';
    }
}
