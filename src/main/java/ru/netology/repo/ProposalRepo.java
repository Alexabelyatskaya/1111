package ru.netology.repo;

import ru.netology.domain.Proposal;

public class ProposalRepo {
    private Proposal[] items = new Proposal[0];

    public Proposal[] findAll() {
        return items;
    }

    public void addItem(Proposal item) {
        Proposal[] tmp = new Proposal[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Proposal findById(int id) {
        for (Proposal item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {

        Proposal[] tmp = new Proposal[items.length - 1];
        int index = 0;
        for (Proposal item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
