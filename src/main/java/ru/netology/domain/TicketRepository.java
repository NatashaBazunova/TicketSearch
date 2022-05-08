package ru.netology.domain;

public class TicketRepository {
    private Ticket[] search = new Ticket[0];

    public void save(Ticket item) {
        int length = search.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(search, 0, tmp, 0, search.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        search = tmp;
    }
    public Ticket[] findAll() {
        return search;
    }


    public void removeById(int id) {
        int length = search.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket item : search) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        search = tmp;
    }

}
