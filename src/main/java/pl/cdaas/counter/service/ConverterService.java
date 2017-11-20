package pl.cdaas.counter.service;

import pl.cdaas.counter.model.Ticket;

import java.io.*;
import java.util.*;

/**
 * Created by Krzysztof on 2017-10-26.
 */
public class ConverterService {

    private Ticket ticket;
    private String pathToFile;
    private List<Ticket> redundantTicketsFromFile;
    private List<Ticket> allTickets;
    private Map<String, Ticket> mappedTickets;


    public ConverterService() {
        this.pathToFile = null;
        this.ticket = null;
        this.redundantTicketsFromFile = new ArrayList<>();
        this.allTickets = new ArrayList<>();
        this.mappedTickets = new HashMap<>();
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public List<Ticket> getRedundantTicketsFromFile() {
        return redundantTicketsFromFile;
    }

    public void setRedundantTicketsFromFile(List<Ticket> redundantTicketsFromFile) {
        this.redundantTicketsFromFile = redundantTicketsFromFile;
    }

    public List<Ticket> getAllTickets() {
        return allTickets;
    }

    public void setAllTickets(List<Ticket> allTickets) {
        this.allTickets = allTickets;
    }

    public Map<String, Ticket> getMappedTickets() {
        return mappedTickets;
    }

    public void setMappedTickets(Map<String, Ticket> mappedTickets) {
        this.mappedTickets = mappedTickets;
    }




    public void getPathFromUser(){

        Scanner inputPath = new Scanner(System.in);
        System.out.println("Please input path to CSV file: ");
        String tempPath = inputPath.nextLine();

        this.setPathToFile(tempPath);
    }


    public List<Ticket> convertCSV() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
        String line = "";

        while ((line = reader.readLine()) != null){

            line = line.replace("; ",",");

            String[] splitedRow = line.split(";");
            splitedRow[4] = splitedRow[4].replace("\"","");
            String[] splitedLables = splitedRow[4].split(",");

            Ticket ticketFromFile = new Ticket();
            ticketFromFile.setSender(splitedRow[0]);
            ticketFromFile.setFullSubject(splitedRow[1]);
            String subjectWithoutPrefix = removeSubjectPrefix(ticketFromFile.getFullSubject());
            ticketFromFile.setSubject(retriveSubject(subjectWithoutPrefix));
            ticketFromFile.setType(retriveTypeCategoryNumber("type", ticketFromFile.getFullSubject()));
            ticketFromFile.setCategory(retriveTypeCategoryNumber("category",ticketFromFile.getFullSubject()));
            ticketFromFile.setDate(DateConverterService.convertDateFromString(splitedRow[2]));
            ticketFromFile.setSize(splitedRow[3]);
            ticketFromFile.setTicketNumber(retriveTypeCategoryNumber("number",ticketFromFile.getFullSubject()));
            ticketFromFile.setLabels(splitedLables);
            ticketFromFile.setMovedToSecondLine(isTicketMovedToL2(ticketFromFile.getCategory()));

            redundantTicketsFromFile.add(ticketFromFile);
        }

        removeHeaderTicket();

        return ignoreDuplicatedTickets();
    }

    private void removeHeaderTicket() {
        if (redundantTicketsFromFile.get(0).getSubject().contains("Subject")){
            redundantTicketsFromFile.remove(0);
        }
    }


    private List<Ticket> ignoreDuplicatedTickets(){

        String ticketSubject = "";
        Ticket mappedTicket = null;
        List<String> ticketSubjects = new ArrayList<>();

        for(int i = 0; i<redundantTicketsFromFile.size(); i++) {

            mappedTicket = redundantTicketsFromFile.get(i);
            ticketSubject = mappedTicket.getSubject();

            if (!ticketSubjects.contains(ticketSubject)) {
                ticketSubjects.add(ticketSubject);
                allTickets.add(mappedTicket);
                mappedTickets.put(ticketSubject, mappedTicket);
            }
        }

        return allTickets;
    }


    private String removeSubjectPrefix(String subject){

        String correctSubject = subject;
        int bracketPosition = 0;
        bracketPosition = subject.indexOf('[');

        if (bracketPosition > 0){
            correctSubject = subject.substring(bracketPosition);
        }

        return correctSubject;
    }

    private String retriveTicketType(String subject){

        String ticketType = subject.substring(1,4);
        return ticketType;
    }

    private String retriveSubject(String fullSubject){

        String subject = "";
        String[] splitedSubject = fullSubject.split(" ");
        for(String s: splitedSubject){
            if (!s.contains("[") && !s.contains("]")){
                subject = subject.concat(s + " ");
            }
        }
        return subject.trim();
    }

    private String retriveTypeCategoryNumber(String typeCategoryNumber, String fullSubject){

        int flag = 0;
        String[] splitedSubject = removeSubjectPrefix(fullSubject).split(" ");

        switch(typeCategoryNumber){
            case "type":{
                flag = 0;
                break;
            }
            case "category":{
                flag = 1;
                break;
            }
            case "number": {
                for (int i = 0; i<splitedSubject.length; i++){
                    if (splitedSubject[i].contains("[#")){
                        splitedSubject[i] = splitedSubject[i].replaceAll("#","");
                        flag = i;
                        break;
                    }
                    else{
                        flag = -1;
                    }
                }
                break;
            }
        }

        String receivedTypeCategoryNumber = "not mapped";
        if (flag < splitedSubject.length && flag >= 0){
            receivedTypeCategoryNumber = splitedSubject[flag].replaceAll("\\[","").replaceAll("]","");
        }
        return receivedTypeCategoryNumber;
    }

    private boolean isTicketMovedToL2(String category){

        boolean movedToL2 = false;
        if (category.contains("L2")){
            movedToL2 = true;
        }

        return movedToL2;
    }

}
