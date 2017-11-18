package pl.cdaas.counter.model;

import java.util.Date;

/**
 * Created by Krzysztof on 2017-10-26.
 */
public class Ticket {

    private String sender;
    private String subject;
    private Date received;
    private String size;
    private String categories;
    private String type;
    private String category;
    private String ticketNumber;

    public Ticket(){

    }

    public Ticket(String sender, String subject, Date received, String size, String categories, String type, String category, String ticketNumber) {
        this.sender = sender;
        this.subject = subject;
        this.received = received;
        this.size = size;
        this.categories = categories;
        this.type = type;
        this.category = category;
        this.ticketNumber = ticketNumber;
    }


    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (sender != null ? !sender.equals(ticket.sender) : ticket.sender != null) return false;
        if (subject != null ? !subject.equals(ticket.subject) : ticket.subject != null) return false;
        if (received != null ? !received.equals(ticket.received) : ticket.received != null) return false;
        if (size != null ? !size.equals(ticket.size) : ticket.size != null) return false;
        if (categories != null ? !categories.equals(ticket.categories) : ticket.categories != null) return false;
        if (type != null ? !type.equals(ticket.type) : ticket.type != null) return false;
        if (category != null ? !category.equals(ticket.category) : ticket.category != null) return false;
        return ticketNumber != null ? ticketNumber.equals(ticket.ticketNumber) : ticket.ticketNumber == null;
    }

    @Override
    public int hashCode() {
        int result = sender != null ? sender.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (received != null ? received.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (ticketNumber != null ? ticketNumber.hashCode() : 0);
        return result;
    }
}
