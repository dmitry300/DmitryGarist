package by.training.task04.service;

import by.training.task04.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final BlockingLoad blocking = new BlockAccountLoad();
    private final FindingLoad finding = new FindAccountLoad();
    private final SeparateSumLoad separateSum = new PosAndNegSumClientLoad();
    private final SortingLoad sorting = new SortClientAccountLoad();
    private final TotalNegAndPosSumLoad totalNegSum = new NegativeBalanceBankLoad();
    private final TotalNegAndPosSumLoad totalPosSum = new PositiveBalanceBankLoad();
    private final TotalSumClientLoad totalSumAccount = new TotalBalanceClientLoad();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public BlockingLoad getBlocking() {
        return blocking;
    }

    public FindingLoad getFinding() {
        return finding;
    }

    public SeparateSumLoad getSeparateSum() {
        return separateSum;
    }

    public SortingLoad getSorting() {
        return sorting;
    }

    public TotalNegAndPosSumLoad getTotalNegSum() {
        return totalNegSum;
    }

    public TotalNegAndPosSumLoad getTotalPosSum() {
        return totalPosSum;
    }

    public TotalSumClientLoad getTotalSumAccount() {
        return totalSumAccount;
    }
}
