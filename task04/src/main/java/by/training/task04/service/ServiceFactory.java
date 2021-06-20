package by.training.task04.service;

import by.training.task04.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final Blocking blocking = new BlockAccount();
    private final Finding finding = new FindAccount();
    private final SeparateSum separateSum = new PosAndNegSumClient();
    private final Sorting sorting = new SortClientAccount();
    private final TotalNegAndPosSum totalNegSum = new NegativeBalanceBank();
    private final TotalNegAndPosSum totalPosSum = new PositiveBalanceBank();
    private final TotalSumClient totalSumAccount = new TotalBalanceClient();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public Blocking getBlocking() {
        return blocking;
    }

    public Finding getFinding() {
        return finding;
    }

    public SeparateSum getSeparateSum() {
        return separateSum;
    }

    public Sorting getSorting() {
        return sorting;
    }

    public TotalNegAndPosSum getTotalNegSum() {
        return totalNegSum;
    }

    public TotalNegAndPosSum getTotalPosSum() {
        return totalPosSum;
    }

    public TotalSumClient getTotalSumAccount() {
        return totalSumAccount;
    }
}
