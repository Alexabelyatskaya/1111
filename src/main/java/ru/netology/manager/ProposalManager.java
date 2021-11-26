package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Proposal;
import ru.netology.repo.ProposalRepo;

import java.util.Arrays;

@NoArgsConstructor
@Data
public class ProposalManager {
    private ProposalRepo repository;

    public ProposalManager(ProposalRepo repository) {
        this.repository = repository;
    }

    public void add(Proposal product) {
        repository.addItem(product);
    }

    public Proposal[] searchBy(String from, String to) {
        Proposal[] result = new Proposal[0];
        for (Proposal proposal: repository.findAll()) {
            if (matchesFrom(proposal, from)) {
                if (matchesTo(proposal, to)) {
                    Proposal[] tmp = new Proposal[result.length + 1];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = proposal;
                    result = tmp;
                    Arrays.sort(result);
                }
            }
        }
        return result;
    }

    private boolean matchesFrom(Proposal proposal, String search) {
        if (proposal.getDepartureAirport().contains(search)) {
            return true;
        }
        return false;
    }

    private boolean matchesTo(Proposal proposal, String search) {
        if (proposal.getArrivalAirport().contains(search)) {
            return true;
        }
        return false;
    }
}
