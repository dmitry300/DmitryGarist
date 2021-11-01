package by.training.barbershop.controller;

import by.training.barbershop.controller.impl.*;
import by.training.barbershop.controller.impl.admin.*;
import by.training.barbershop.controller.impl.client.*;

import java.util.EnumMap;

public class CommandProvider {
    private static final CommandProvider instance = new CommandProvider();
    private final EnumMap<CommandType, Command> commands = new EnumMap<>(CommandType.class);

    public static CommandProvider getInstance() {
        return instance;
    }

    private CommandProvider() {
        commands.put(CommandType.REGISTRATION, new RegistrationCommand());
        commands.put(CommandType.HOME, new HomeCommand());
        commands.put(CommandType.LOGIN, new LoginCommand());
        commands.put(CommandType.LOGOUT, new LogoutCommand());
        commands.put(CommandType.GO_TO_REGISTRATION, new GoToRegistrationCommand());
        commands.put(CommandType.GO_TO_LOGIN, new GoToLoginCommand());
        commands.put(CommandType.GO_TO_ABOUT_US, new GoToAboutUsCommand());
        commands.put(CommandType.LANGUAGE, new LanguageCommand());
        commands.put(CommandType.SERVICES, new ServiceListCommand());
        commands.put(CommandType.BARBERS, new BarberListCommand());
        commands.put(CommandType.ORDER, new GoToOrderCommand());
        commands.put(CommandType.ORDER_WAITING, new OrderSendCommand());
        commands.put(CommandType.GO_TO_ORDER_WAITING, new ClientOrderWaitingCommand());
        commands.put(CommandType.CLIENT_PROFILE, new GoToClientProfileCommand());
        commands.put(CommandType.CLIENT_PERSONAL_DATA, new ClientPersonalDataCommand());
        commands.put(CommandType.GO_TO_CLIENT_EDIT_PROFILE, new GoToEditProfileCommand());
        commands.put(CommandType.CLIENT_EDIT_PERSONAL_DATA, new EditProfileCommand());
        commands.put(CommandType.CLIENT_ORDERS, new ClientOrderCommand());
        commands.put(CommandType.CLIENT_REMOVE_ORDER, new ClientRemoveOrderCommand());
        commands.put(CommandType.CLIENTS_LIST, new ClientListCommand());
        commands.put(CommandType.VIEW_ORDERS, new ViewOrdersCommand());
        commands.put(CommandType.CHANGE_USER_STATUS, new ChangeClientStatusCommand());
        commands.put(CommandType.CHANGE_ORDER_STATUS, new ChangeOrderStatusCommand());
        commands.put(CommandType.REMOVE_ORDER, new RemoveOrderCommand());
        commands.put(CommandType.GO_TO_EDIT_ORDER, new GoToEditOrderCommand());
        commands.put(CommandType.EDIT_ORDER, new EditOrderCommand());
        commands.put(CommandType.ACTIVE_ORDERS, new AllActiveOrdersCommand());
        commands.put(CommandType.INACTIVE_ORDERS, new AllInactiveOrdersCommand());
        commands.put(CommandType.LIST_HAIRCUTS, new ListOfHaircutsCommand());
        commands.put(CommandType.ADD_HAIRCUT, new AddHaircutCommand());
        commands.put(CommandType.REMOVE_HAIRCUT, new RemoveHaircutCommand());
        commands.put(CommandType.EDIT_HAIRCUT, new EditHaircutCommand());
        commands.put(CommandType.GO_TO_EDIT_HAIRCUT, new GoToEditHaircutCommand());
        commands.put(CommandType.ACTIVE_BARBERS, new ListOfActiveBarbersCommand());
        commands.put(CommandType.DISMISSED_BARBERS, new ListOfDismissedBarbersCommand());
        commands.put(CommandType.ADD_BARBER, new AddBarberCommand());
        commands.put(CommandType.REMOVE_BARBER, new RemoveBarberCommand());
        commands.put(CommandType.GO_TO_EDIT_BARBER, new GoToEditBarberCommand());
        commands.put(CommandType.EDIT_BARBER, new EditBarberCommand());
        commands.put(CommandType.GO_TO_REVIEW, new GoToReviewCommand());
        commands.put(CommandType.ADD_REVIEW, new AddReviewCommand());
        commands.put(CommandType.REMOVE_REVIEW, new RemoveReviewCommand());
        commands.put(CommandType.EDIT_REVIEW, new EditReviewCommand());
        commands.put(CommandType.GO_TO_EDIT_REVIEW, new GoToEditReviewCommand());
        commands.put(CommandType.ERROR, new Error404Command());
    }

    public Command getCommand(String commandName) {
        if (commandName == null) {
            return commands.get(CommandType.ERROR);
        }
        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandName.toUpperCase());
        } catch (IllegalArgumentException e) {
            commandType = CommandType.ERROR;
        }
        return commands.get(commandType);
    }
}
