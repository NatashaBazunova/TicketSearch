package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();
    Ticket first = new Ticket (1, 5400, "UFA", "DME", 120);
    Ticket second = new Ticket (2, 5700, "UFA", "DME", 120);
    Ticket third = new Ticket (3, 4650, "KZN", "DME", 90);
    Ticket fourth = new Ticket (4, 4500, "KZN", "DME", 90);
    Ticket fifth = new Ticket (5, 5550, "UFA", "DME", 120);
    Ticket sixth = new Ticket (6, 4300, "KZN", "DME", 90);

    @Test
    public void shouldFindAll() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);
        repo.save(sixth);
        Ticket[] expected = new Ticket[] {first, second, third, fourth, fifth, sixth};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.removeById(3);
        Ticket[] expected = new Ticket[] {first, second, fourth};
        Ticket[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }



}