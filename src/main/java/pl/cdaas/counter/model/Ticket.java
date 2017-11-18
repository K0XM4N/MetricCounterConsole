package pl.cdaas.counter.model;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Krzysztof on 2017-10-26.
 */
public class Ticket {

    private String sender;
    private String fullSubject;
    private String subject;
    private Date date;
    private String size;
    private String[] labels;
    private String type;
    private String category;
    private String ticketNumber;
    private boolean isMovedToSecondLine;

    public Ticket(){

    }

    public Ticket(String sender, String fullSubject, String subject, Date date, String size, String[] labels, String type, String category, String ticketNumber, boolean isMovedToSecondLine) {
        this.sender = sender;
        this.fullSubject = fullSubject;
        this.subject = subject;
        this.date = date;
        this.size = size;
        this.labels = labels;
        this.type = type;
        this.category = category;
        this.ticketNumber = ticketNumber;
        this.isMovedToSecondLine = isMovedToSecondLine;
    }


    //GETTERS & SETTERS

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getFullSubject() {
        return fullSubject;
    }

    public void setFullSubject(String fullSubject) {
        this.fullSubject = fullSubject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
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

    public boolean isMovedToSecondLine() {
        return isMovedToSecondLine;
    }

    public void setMovedToSecondLine(boolean movedToSecondLine) {
        isMovedToSecondLine = movedToSecondLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (isMovedToSecondLine != ticket.isMovedToSecondLine) return false;
        if (sender != null ? !sender.equals(ticket.sender) : ticket.sender != null) return false;
        if (fullSubject != null ? !fullSubject.equals(ticket.fullSubject) : ticket.fullSubject != null) return false;
        if (subject != null ? !subject.equals(ticket.subject) : ticket.subject != null) return false;
        if (date != null ? !date.equals(ticket.date) : ticket.date != null) return false;
        if (size != null ? !size.equals(ticket.size) : ticket.size != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(labels, ticket.labels)) return false;
        if (type != null ? !type.equals(ticket.type) : ticket.type != null) return false;
        if (category != null ? !category.equals(ticket.category) : ticket.category != null) return false;
        return ticketNumber != null ? ticketNumber.equals(ticket.ticketNumber) : ticket.ticketNumber == null;
    }

    @Override
    public int hashCode() {
        int result = sender != null ? sender.hashCode() : 0;
        result = 31 * result + (fullSubject != null ? fullSubject.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(labels);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (ticketNumber != null ? ticketNumber.hashCode() : 0);
        result = 31 * result + (isMovedToSecondLine ? 1 : 0);
        return result;
    }
}
