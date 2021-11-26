package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Proposal;
import ru.netology.repo.ProposalRepo;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProposalManagerTest {
    ProposalRepo repository = new ProposalRepo();
    ProposalManager manager = new ProposalManager(repository);

    Proposal one = new Proposal(1, 2000, "RVH", "GOJ", 60);
    Proposal two = new Proposal(2, 3000, "DME", "GOJ", 70);
    Proposal three = new Proposal(3, 1500, "DME", "GOJ", 120);
    Proposal four = new Proposal(4, 4000, "LED", "DME", 60);
    Proposal five = new Proposal(5, 1700, "DME", "GOJ", 90);
    Proposal six = new Proposal(6, 1500, "DME", "GOJ", 95);
    Proposal seven = new Proposal(4, 3000, "LED", "DME", 60);

    @BeforeEach
    public void adder() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
    }

    @Test
    public void shouldSearchProposalOne() {
        assertArrayEquals(manager.searchBy("RVH", "GOJ"), new Proposal[]{one});
    }

    @Test
    public void shouldSearchProposalSomeWithoutRepeat() {
        assertArrayEquals(manager.searchBy("LED", "DME"), new Proposal[]{seven, four});
    }

    @Test
    public void shouldSearchProposalSomeWithRepeat() {
        assertArrayEquals(manager.searchBy("DME", "GOJ"), new Proposal[]{three, six, five, two});
    }

    @Test
    public void shouldSearchProposalNone() {
        assertArrayEquals(manager.searchBy("DME", "123"), new Proposal[]{});
    }
}
