package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket first = new Ticket (1, 5400, "UFA", "DME", 120);
    Ticket second = new Ticket (2, 5700, "UFA", "DME", 120);
    Ticket third = new Ticket (3, 4650, "KZN", "DME", 90);
    Ticket fourth = new Ticket (4, 4500, "KZN", "DME", 90);
    Ticket fifth = new Ticket (5, 5550, "UFA", "DME", 120);
    Ticket sixth = new Ticket (6, 4300, "KZN", "DME", 90);

    @Test
    public void shouldFindByUfa(){
        manager.add(first);
        manager.add(second);
        manager.add(fifth);

        Ticket[] expected = new Ticket[] {first, fifth, second};
        Ticket[] actual = manager.findByAll("UFA", "DME");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByKZN() {
        manager.add(third);
        manager.add(fourth);
        manager.add(sixth);
        Ticket[] expected = new Ticket[] {sixth, fourth, third};
        Ticket[] actual = manager.findByAll("KZN", "DME");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByDME() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        Ticket[] expected = new Ticket[] {sixth, fourth, third, first, fifth, second};
        Ticket[] actual = manager.findByAll("DME", "");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindNone() {
        manager.add(third);
        manager.add(fourth);
        manager.add(sixth);
        Ticket[] expected = new Ticket[] {};
        Ticket[] actual = manager.findByAll("DME", "KZN");

        assertArrayEquals(expected, actual);
    }







}