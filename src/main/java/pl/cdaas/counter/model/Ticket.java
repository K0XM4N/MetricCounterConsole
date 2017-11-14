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

    public Ticket(){

    }

    public Ticket(String sender, String subject, Date received, String size, String categories) {
        this.sender = sender;
        this.subject = subject;
        this.received = received;
        this.size = size;
        this.categories = categories;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (sender != null ? !sender.equals(ticket.sender) : ticket.sender != null) return false;
        if (subject != null ? !subject.equals(ticket.subject) : ticket.subject != null) return false;
        if (received != null ? !received.equals(ticket.received) : ticket.received != null) return false;
        if (size != null ? !size.equals(ticket.size) : ticket.size != null) return false;
        return categories != null ? categories.equals(ticket.categories) : ticket.categories == null;
    }

    @Override
    public int hashCode() {
        int result = sender != null ? sender.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (received != null ? received.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        return result;
    }
}
