package pl.cdaas.counter.service;

import pl.cdaas.counter.model.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by radwa on 26.11.2017.
 */
public class RouterService {

    private List<Ticket> allTickets;
    private List<Ticket> buildTickets;
    private List<Ticket> binaryTickets;
    private List<Ticket> codeTickets;
    private List<Ticket> deployTickets;
    private List<Ticket> ispTickets;
    private List<Ticket> isrTickets;
    private List<Ticket> testingTickets;
    private List<Ticket> webTickets;


    public RouterService(List<Ticket> allTickets) {
        this.allTickets = allTickets;
        buildTickets = new ArrayList<>();
        binaryTickets = new ArrayList<>();
        codeTickets = new ArrayList<>();
        deployTickets = new ArrayList<>();
        ispTickets = new ArrayList<>();
        isrTickets = new ArrayList<>();
        testingTickets = new ArrayList<>();
        webTickets = new ArrayList<>();
    }

    public List<Ticket> getAllTickets() {
        return allTickets;
    }

    public void setAllTickets(List<Ticket> allTickets) {
        this.allTickets = allTickets;
    }


}
