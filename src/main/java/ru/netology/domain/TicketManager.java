package ru.netology.domain;

public class TicketManager {
    private TicketRepository repository;
    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket item) {
        repository.save(item);
    }


   public Ticket[] findByAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                    int length = result.length + 1;
                    Ticket[] tmp = new Ticket[length];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    int lastIndex = tmp.length - 1;
                    tmp[lastIndex] = ticket;
                    result = tmp;
                }
            }
       return result;
        }


    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().contains(from)) {
            return true;
        }
        if (ticket.getTo().contains(to)) {
            return true;
        }
        return false;
    }

}


