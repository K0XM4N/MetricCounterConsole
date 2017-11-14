package pl.cdaas.counter;

import pl.cdaas.counter.model.Ticket;
import pl.cdaas.counter.service.ConverterService;
import pl.cdaas.counter.service.CounterService;
import pl.cdaas.counter.service.DateConverterService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println("Hello World!");


        ConverterService converterService = new ConverterService();
        List<Ticket> listOfParsedTickets = new ArrayList<Ticket>();

        converterService.setPathToFile("F:\\INC BUILD.csv");
        listOfParsedTickets = converterService.convertCSV();

        for(Ticket t: listOfParsedTickets){
            System.out.println(t.getSubject() + " " + DateConverterService.convertDateToString(t.getReceived()));
        }

        CounterService counterService = new CounterService();
        counterService.setListOfAllTickets(listOfParsedTickets);
        counterService.startCountingTickets();


    }
}


