package pl.cdaas.counter.service;

import pl.cdaas.counter.model.Ticket;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Krzysztof on 2017-10-26.
 */
public class CounterService {

    private Ticket ticket;
    private long totalTickets;
    private long firstLineTickets;
    private long secondLineTickets;
    private List<Ticket> listOfAllTickets;



    public enum Maps {CODE, BUILD, BINARY, WEB, DEPLOY, TEST, ISP, ISR}
    public enum Lines {L2}


    public CounterService(){
        this.totalTickets = 0;
        this.firstLineTickets = 0;
        this.secondLineTickets = 0;
        this.ticket = null;
        listOfAllTickets = new ArrayList<Ticket>();
    }

    public long getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(long totalTickets) {
        this.totalTickets = totalTickets;
    }

    public long getFirstLineTickets() {
        return firstLineTickets;
    }

    public void setFirstLineTickets(long firstLineTickets) {
        this.firstLineTickets = firstLineTickets;
    }

    public long getSecondLineTickets() {
        return secondLineTickets;
    }

    public void setSecondLineTickets(long secondLineTickets) {
        this.secondLineTickets = secondLineTickets;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<Ticket> getListOfAllTickets() {
        return listOfAllTickets;
    }

    public void setListOfAllTickets(List<Ticket> listOfAllTickets) {
        this.listOfAllTickets = listOfAllTickets;
    }




    public void startCountingTickets() {
        totalTickets = countAllTickets();
        System.out.println("Total tickets: " + totalTickets);
    }


    private long countAllTickets(){
        return listOfAllTickets.size();
    }


    public long countTicketsFromDay(String dateAsString) {

        List<Ticket> ticketsFromGivenDay = new ArrayList<>();
        long numberOfTickets = 0;

        for (Ticket t: listOfAllTickets){

            if (t.getReceived() != null) {
                String ticketDate = DateConverterService.convertDateToString(t.getReceived());
                if (ticketDate.equals(dateAsString)) {
                    numberOfTickets++;
                }
            }
        }

        return numberOfTickets;

    }



    private long ignoreDuplicates(List<Ticket> ticketFromDay){

        long startTime = System.nanoTime();

        List<String> ticketsWithoutDuplications = new ArrayList<>();
        Map<String, Ticket> mappedTickets = new HashMap<>();

        for(int i=0;i<ticketFromDay.size(); i++){

            Ticket ticketToCompare = ticketFromDay.get(i);
            if (!ticketsWithoutDuplications.contains(ticketToCompare.getSubject())){
                ticketsWithoutDuplications.add(ticketToCompare.getSubject());
                mappedTickets.put(ticketToCompare.getSubject(),ticketToCompare);
            }

        }

        long finishTime = System.nanoTime() - startTime;
        double finishTimeRounded = (new Double(finishTime) / 1000000000);
        System.out.println(String.format("Finish time: %.4f sec",finishTimeRounded));

        return ticketsWithoutDuplications.size();
    }


    private long ignoreDuplicatesSet(List<Ticket> ticketFromDay){

        long startTime = System.nanoTime();
        Set<String> ticketsWithoutDuplications = new HashSet<>();
        Map<String, Ticket> ticketMap = new HashMap<>();

        for(int i=0;i<ticketFromDay.size(); i++){
            Ticket ticketToCompare = ticketFromDay.get(i);
            ticketsWithoutDuplications.add(ticketToCompare.getSubject());
        }

        for (String ticket: ticketsWithoutDuplications){

        }



        long finishTime = System.nanoTime() - startTime;
        double finishTimeRounded = (new Double(finishTime) / 1000000000);
        System.out.println(String.format("Finish time: %.4f sec",finishTimeRounded));

        return ticketsWithoutDuplications.size();
    }

}
