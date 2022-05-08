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
            if (matchesFrom(ticket, from)) {
                if (matchesTo(ticket, to)) {
                    int length = result.length + 1;
                    Ticket[] tmp = new Ticket[length];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    int lastIndex = tmp.length - 1;
                    tmp[lastIndex] = ticket;
                    result = tmp;
                }
            }
        }
        return result;
   }
   public boolean matchesFrom(Ticket ticket, String search) {
        return ticket.getFrom().contains(search);
   }
   public boolean matchesTo(Ticket ticket,String search) {
        return ticket.getTo().contains(search);
   }
//добавить остальное по такому же принципу
}
